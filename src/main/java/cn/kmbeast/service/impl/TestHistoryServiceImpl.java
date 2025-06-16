package cn.kmbeast.service.impl;

import cn.kmbeast.context.LocalThreadHolder;
import cn.kmbeast.mapper.PaperMapper;
import cn.kmbeast.mapper.PracticeMapper;
import cn.kmbeast.mapper.TestHistoryMapper;
import cn.kmbeast.pojo.api.ApiResult;
import cn.kmbeast.pojo.api.PageResult;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.PaperQueryDto;
import cn.kmbeast.pojo.dto.query.extend.TestHistoryQueryDto;
import cn.kmbeast.pojo.dto.save.TestHistoryDto;
import cn.kmbeast.pojo.entity.TestHistory;
import cn.kmbeast.pojo.vo.PaperVO;
import cn.kmbeast.pojo.vo.PracticeVO;
import cn.kmbeast.pojo.vo.TestHistoryVO;
import cn.kmbeast.service.TestHistoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 答题历史业务逻辑实现
 */
@Service
public class TestHistoryServiceImpl implements TestHistoryService {

    @Resource
    private TestHistoryMapper testHistoryMapper;
    @Resource
    private PaperMapper paperMapper;
    @Resource
    private PracticeMapper practiceMapper;

    /**
     * 试卷新增
     *
     * @param testHistoryDtos 参数
     * @return Result<Void>
     */
    @Override
    public Result<Void> save(List<TestHistoryDto> testHistoryDtos) {
        // 1. 先判断时间是否超出
        if (CollectionUtils.isEmpty(testHistoryDtos)) {
            return ApiResult.error("请认真答题");
        }
        TestHistoryDto testHistoryDto = testHistoryDtos.get(0);
        Long startTime = testHistoryDto.getStartTime();
        Long endTime = testHistoryDto.getEndTime();
        long l = endTime - startTime;
        // 2. 试卷信息是否正确
        PaperQueryDto paperQueryDto = new PaperQueryDto();
        paperQueryDto.setId(testHistoryDto.getPaperId());
        List<PaperVO> paperVOS = paperMapper.query(paperQueryDto);
        if (CollectionUtils.isEmpty(paperVOS)) {
            return ApiResult.error("请求不合法");
        }
        PaperVO paperVO = paperVOS.get(0);
        // 时间超过，不能提交
        // 1分钟 ---> 60秒 ---> 1000 * 60
        long limitTime = paperVO.getLimitTime() * 1000 * 60 * 60;
        if (l > limitTime) {
            return ApiResult.error("考试超时");
        }
        List<Integer> practiceIds = testHistoryDtos.stream()
                .map(TestHistoryDto::getPracticeId)
                .collect(Collectors.toList());
        // 3. 比对答案(先去查询题目信息，通过ID去批量查回来)、赋分
        //  题目源
        List<PracticeVO> practiceVOS = practiceMapper.queryByIds(practiceIds);
        // 构造存储的答题数据
        List<TestHistory> testHistoryList = new ArrayList<>();
        LocalDateTime createTime = LocalDateTime.now();
        testHistoryDtos.forEach(testHistoryDto1 -> {
            TestHistory testHistory = new TestHistory();
            testHistory.setCreateTime(createTime);
            testHistory.setUserId(LocalThreadHolder.getUserId());
            testHistory.setPaperId(testHistoryDto1.getPaperId());
            testHistory.setPracticeId(testHistoryDto1.getPracticeId());
            testHistory.setAnswer(testHistoryDto1.getAnswer());
            for (PracticeVO practiceVO : practiceVOS) {
                if (Objects.equals(practiceVO.getId(), testHistoryDto1.getPracticeId())) {
                    String rightAnswer = practiceVO.getRightAnswer();
                    if (Objects.equals(rightAnswer, testHistoryDto1.getAnswer())) {
                        // 奖励分数
                        testHistory.setPostScore(practiceVO.getScore());
                    }else{
                        // 奖励零分
                        testHistory.setPostScore(0);
                    }
                }
            }
            testHistoryList.add(testHistory);
        });
        // 4. 新增
        testHistoryMapper.save(testHistoryList);
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
        testHistoryMapper.batchDelete(ids);
        return ApiResult.success();
    }

    /**
     * 试卷修改
     *
     * @param testHistory 参数
     * @return Result<Void>
     */
    @Override
    public Result<Void> update(TestHistory testHistory) {
        testHistoryMapper.update(testHistory);
        return ApiResult.success();
    }

    /**
     * 试卷查询
     *
     * @param testHistoryQueryDto 查询参数
     * @return Result<List < TestHistoryVO>>
     */
    @Override
    public Result<List<TestHistoryVO>> query(TestHistoryQueryDto testHistoryQueryDto) {
        List<TestHistoryVO> testHistoryList = testHistoryMapper.query(testHistoryQueryDto);
        Integer totalCount = testHistoryMapper.queryCount(testHistoryQueryDto);
        return PageResult.success(testHistoryList, totalCount);
    }


}
