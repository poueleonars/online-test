package cn.kmbeast.service.impl;

import cn.kmbeast.mapper.*;
import cn.kmbeast.pojo.api.ApiResult;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.*;
import cn.kmbeast.pojo.vo.ChartVO;
import cn.kmbeast.service.ViewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 首页可视化
 */
@Service
public class ViewsServiceImpl implements ViewsService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private PaperMapper paperMapper;
    @Resource
    private PracticeMapper practiceMapper;
    @Resource
    private EvaluationsMapper evaluationsMapper;
    @Resource
    private NoticeMapper noticeMapper;

    /**
     * 统计一些系统的基础数据
     *
     * @return Result<List < ChartVO>>
     */
    @Override
    public Result<List<ChartVO>> staticControls() {
        List<ChartVO> chartVOS = new ArrayList<>();
        // 1. 用户数
        UserQueryDto userQueryDto = new UserQueryDto();
        int userCount = userMapper.queryCount(userQueryDto);
        change(userCount, "存量用户（个）", chartVOS);
        // 2. 试卷数
        PaperQueryDto paperQueryDto = new PaperQueryDto();
        int paperCount = paperMapper.queryCount(paperQueryDto);
        change(paperCount, "存量试卷（张）", chartVOS);
        // 3. 题目
        PracticeQueryDto practiceQueryDto = new PracticeQueryDto();
        int practiceCount = practiceMapper.queryCount(practiceQueryDto);
        change(practiceCount, "收录题目（道）", chartVOS);
        // 4. 评论
        EvaluationsQueryDto evaluationsQueryDto = new EvaluationsQueryDto();
        int evaluationCount = evaluationsMapper.queryCount(evaluationsQueryDto);
        change(evaluationCount, "评论（条）", chartVOS);
        // 5. 公告
        NoticeQueryDto noticeQueryDto = new NoticeQueryDto();
        int noticeCount = noticeMapper.queryCount(noticeQueryDto);
        change(noticeCount, "公告（篇）", chartVOS);
        return ApiResult.success(chartVOS);
    }

    /**
     * 参数处理
     *
     * @param count    总数目
     * @param name     统计项
     * @param chartVOS 装它们的集合
     */
    private void change(Integer count, String name, List<ChartVO> chartVOS) {
        ChartVO chartVO = new ChartVO(name, count);
        chartVOS.add(chartVO);
    }


}
