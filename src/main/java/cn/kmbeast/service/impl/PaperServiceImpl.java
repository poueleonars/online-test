package cn.kmbeast.service.impl;

import cn.kmbeast.context.LocalThreadHolder;
import cn.kmbeast.mapper.PaperMapper;
import cn.kmbeast.mapper.PaperPracticeMapper;
import cn.kmbeast.mapper.PracticeMapper;
import cn.kmbeast.pojo.api.ApiResult;
import cn.kmbeast.pojo.api.PageResult;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.base.QueryDto;
import cn.kmbeast.pojo.dto.query.extend.*;
import cn.kmbeast.pojo.em.PracticeTypeEnum;
import cn.kmbeast.pojo.em.RoleEnum;
import cn.kmbeast.pojo.entity.Paper;
import cn.kmbeast.pojo.entity.PaperPractice;
import cn.kmbeast.pojo.entity.User;
import cn.kmbeast.pojo.vo.ChartVO;
import cn.kmbeast.pojo.vo.PaperPracticeVO;
import cn.kmbeast.pojo.vo.PaperVO;
import cn.kmbeast.pojo.vo.PracticeVO;
import cn.kmbeast.service.PaperService;
import cn.kmbeast.utils.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 试卷业务逻辑实现
 */
@Service
public class PaperServiceImpl implements PaperService {

    @Resource
    private PaperMapper paperMapper;
    @Resource
    private PaperPracticeMapper paperPracticeMapper;
    @Resource
    private PracticeMapper practiceMapper;

    /**
     * 试卷新增
     *
     * @param paper 参数
     * @return Result<Void>
     */
    @Override
    public Result<Void> save(Paper paper) {
        paper.setCreateTime(LocalDateTime.now());
        paper.setUserId(LocalThreadHolder.getUserId());
        // 未审核
        paper.setIsShow(false);
        if (LocalThreadHolder.getRoleId().equals(RoleEnum.ADMIN.getRole())) {
            // 管理员新增不用审核
            paper.setIsShow(true);
        }
        paperMapper.save(paper);
        return ApiResult.success();
    }

    /**
     * 试卷删除
     *
     * @param ids 参数
     * @return Result<Void>
     */
    @Override
    public Result<Void> batchDelete(List<Integer> ids) {
        paperMapper.batchDelete(ids);
        return ApiResult.success();
    }

    /**
     * 试卷修改
     *
     * @param paper 参数
     * @return Result<Void>
     */
    @Override
    public Result<Void> update(Paper paper) {
        paperMapper.update(paper);
        return ApiResult.success();
    }

    /**
     * 试卷查询
     *
     * @param paperQueryDto 查询参数
     * @return Result<List < PaperVO>>
     */
    @Override
    public Result<List<PaperVO>> query(PaperQueryDto paperQueryDto) {
        List<PaperVO> paperList = paperMapper.query(paperQueryDto);
        Integer totalCount = paperMapper.queryCount(paperQueryDto);
        return PageResult.success(paperList, totalCount);
    }

    /**
     * 自动组卷业务逻辑
     *
     * @param autoCreatePaper 参数
     * @return 响应
     */
    @Override
    public Result<Void> autoCreatePaper(AutoCreatePaper autoCreatePaper) {
        // 获取试卷的基本信息
        Paper paper = getPaper(autoCreatePaper);
        if (paper == null) {
            return ApiResult.error("卷子信息异常");
        }
        // 获取当前试卷绑定的题目
        List<PaperPracticeVO> practiceVos = getPaperPracticeVos(autoCreatePaper);
        // 试卷已经绑定的题目Id列表
        List<Integer> practiceIds = practiceVos.stream()
                .map(PaperPracticeVO::getPracticeId)
                .collect(Collectors.toList());
        // 获取题目源
        List<PracticeVO> practiceVOS = getPracticeVos(autoCreatePaper);
        // 组卷
        return createPaper(autoCreatePaper, paper, practiceIds, practiceVOS);
    }


    /**
     * 组卷逻辑
     *
     * @param autoCreatePaper  接收的组卷配置参数
     * @param paper            试卷
     * @param paperPracticeIds 当前试卷已经绑定的试卷ID
     * @param practiceVOS      题目源
     */
    private Result<Void> createPaper(AutoCreatePaper autoCreatePaper,
                                     Paper paper,
                                     List<Integer> paperPracticeIds,
                                     List<PracticeVO> practiceVOS) {
        List<PaperPractice> paperPractices = new ArrayList<>();
        // 选择题
        List<PracticeVO> oneSelectedList = practiceVOS.stream()
                .filter(practice -> Objects.equals(practice.getPracticeType(), PracticeTypeEnum.ONE_SELECTED.getType()))
                .collect(Collectors.toList());
        // 多选题
        List<PracticeVO> doubleSelectedList = practiceVOS.stream()
                .filter(practice -> Objects.equals(practice.getPracticeType(), PracticeTypeEnum.DOUBLE_SELECTED.getType()))
                .collect(Collectors.toList());
        // 填空题
        List<PracticeVO> putWordList = practiceVOS.stream()
                .filter(practice -> Objects.equals(practice.getPracticeType(), PracticeTypeEnum.WORD_PUT.getType()))
                .collect(Collectors.toList());
        // 判断题
        List<PracticeVO> judgeSelectedList = practiceVOS.stream()
                .filter(practice -> Objects.equals(practice.getPracticeType(), PracticeTypeEnum.JUDGEMENT.getType()))
                .collect(Collectors.toList());
        // 处理不同题目 -- 有题目 --- 分别构造，因为题源不一样，生成的题型数量也不一样
        // 单选
        if (!CollectionUtils.isEmpty(oneSelectedList)) {
            createStoragePaper(
                    paper.getId(),
                    oneSelectedList.stream().map(PracticeVO::getId).collect(Collectors.toList()),
                    autoCreatePaper.getOneSelected(),
                    paperPracticeIds,
                    paperPractices
            );
        }
        // 多选
        if (!CollectionUtils.isEmpty(doubleSelectedList)) {
            createStoragePaper(
                    paper.getId(),
                    doubleSelectedList.stream().map(PracticeVO::getId).collect(Collectors.toList()),
                    autoCreatePaper.getDoubleSelected(),
                    paperPracticeIds,
                    paperPractices
            );
        }
        // 填空
        if (!CollectionUtils.isEmpty(putWordList)) {
            createStoragePaper(
                    paper.getId(),
                    putWordList.stream().map(PracticeVO::getId).collect(Collectors.toList()),
                    autoCreatePaper.getPutWord(),
                    paperPracticeIds,
                    paperPractices
            );
        }
        // 判断
        if (!CollectionUtils.isEmpty(judgeSelectedList)) {
            createStoragePaper(
                    paper.getId(),
                    judgeSelectedList.stream().map(PracticeVO::getId).collect(Collectors.toList()),
                    autoCreatePaper.getJudgeSelected(),
                    paperPracticeIds,
                    paperPractices
            );
        }
        // 批量新增
        paperPracticeMapper.batchSave(paperPractices);
        return ApiResult.success();
    }


    /**
     * 构造可直接用于存储的试卷-题目关联对象
     *
     * @param paperId         试卷ID
     * @param practiceIds     题目源ID
     * @param limit           生成题型目标数据
     * @param bindPracticeIds 试卷存量题目Id列表
     * @param paperPractices  装目标题目关联的容器
     */
    private void createStoragePaper(
            Integer paperId,
            List<Integer> practiceIds,
            Integer limit,
            List<Integer> bindPracticeIds,
            List<PaperPractice> paperPractices) {
        List<Integer> savePracticeIds = practiceIds.size() <= limit ? practiceIds : practiceIds.subList(0, limit);
        // 过滤和映射
        List<PaperPractice> newPaperPractices = savePracticeIds.stream()
                .filter(savePracticeId -> !bindPracticeIds.contains(savePracticeId))
                .map(savePracticeId -> {
                    PaperPractice paperPractice = new PaperPractice();
                    paperPractice.setPaperId(paperId);
                    paperPractice.setPracticeId(savePracticeId);
                    return paperPractice;
                }).collect(Collectors.toList());
        // 如果需要将新创建的PaperPractice对象添加到已有的paperPractices列表中
        paperPractices.addAll(newPaperPractices);
    }

    /**
     * 获取试卷的信息
     *
     * @param autoCreatePaper 组卷配置接收参数
     * @return Paper
     */
    private Paper getPaper(AutoCreatePaper autoCreatePaper) {
        PaperQueryDto paperQueryDto = new PaperQueryDto();
        paperQueryDto.setId(autoCreatePaper.getPaperId());
        List<PaperVO> paperVOS = paperMapper.query(paperQueryDto);
        // 通过ID去查，要么找不到，要么只有一个
        return paperVOS.isEmpty() ? null : paperVOS.get(0);
    }

    private List<PaperPracticeVO> getPaperPracticeVos(AutoCreatePaper autoCreatePaper) {
        PaperPracticeQueryDto queryDto = new PaperPracticeQueryDto();
        queryDto.setPaperId(autoCreatePaper.getPaperId());
        return paperPracticeMapper.query(queryDto);
    }

    private List<PracticeVO> getPracticeVos(AutoCreatePaper autoCreatePaper) {
        PracticeQueryDto queryDto = new PracticeQueryDto();
        queryDto.setProjectId(autoCreatePaper.getProjectId());
        return practiceMapper.query(queryDto);
    }

    /**
     * 统计指定时间里面的用户存量数据
     *
     * @param day 天数
     * @return Result<List < ChartVO>>
     */
    @Override
    public Result<List<ChartVO>> daysQuery(Integer day) {
        QueryDto queryDto = DateUtil.startAndEndTime(day);
        PaperQueryDto paperQueryDto = new PaperQueryDto();
        paperQueryDto.setStartTime(queryDto.getStartTime());
        paperQueryDto.setEndTime(queryDto.getEndTime());
        List<PaperVO> paperVOList = paperMapper.query(paperQueryDto);
        List<LocalDateTime> localDateTimes = paperVOList.stream().map(Paper::getCreateTime).collect(Collectors.toList());
        List<ChartVO> chartVOS = DateUtil.countDatesWithinRange(day, localDateTimes);
        return ApiResult.success(chartVOS);
    }
}
