package cn.kmbeast.service.impl;

import cn.kmbeast.context.LocalThreadHolder;
import cn.kmbeast.mapper.PaperPracticeMapper;
import cn.kmbeast.mapper.PracticeMapper;
import cn.kmbeast.pojo.api.ApiResult;
import cn.kmbeast.pojo.api.PageResult;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.PracticeQueryDto;
import cn.kmbeast.pojo.entity.Practice;
import cn.kmbeast.pojo.vo.PracticeVO;
import cn.kmbeast.service.PracticeService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 试题业务逻辑实现
 */
@Service
public class PracticeServiceImpl implements PracticeService {

    @Resource
    private PracticeMapper practiceMapper;
    @Resource
    private PaperPracticeMapper paperPracticeMapper;

    /**
     * 试卷新增
     *
     * @param practice 参数
     * @return Result<Void>
     */
    @Override
    public Result<Void> save(Practice practice) {
        practice.setCreateTime(LocalDateTime.now());
        practice.setUserId(LocalThreadHolder.getUserId());
        askItemTextDeal(practice);
        practiceMapper.save(practice);
        return ApiResult.success();
    }

    /**
     * 由于题目存储时，存储的是富文本，在此处理成列表显示的文本内容
     *
     * @param practice 题目
     */
    private void askItemTextDeal(Practice practice) {
        if (practice.getAskItem() != null) {
            Document document = Jsoup.parse(practice.getAskItem());
            String askItemText = document.text();
            practice.setAskItemText(askItemText.length() > 100 ? askItemText.substring(0, 50) + "..." : askItemText);
        }
    }

    /**
     * 试卷删除
     *
     * @param ids 参数
     * @return Result<Void>
     */
    @Override
    public Result<Void> batchDelete(List<Integer> ids) {
        // 删除题目的信息
        practiceMapper.batchDelete(ids);
        // 还需要删除试卷绑定的题目关系
        paperPracticeMapper.del(ids);
        return ApiResult.success();
    }

    /**
     * 试卷修改
     *
     * @param practice 参数
     * @return Result<Void>
     */
    @Override
    public Result<Void> update(Practice practice) {
        askItemTextDeal(practice);
        practiceMapper.update(practice);
        return ApiResult.success();
    }

    /**
     * 试卷查询
     *
     * @param practiceQueryDto 查询参数
     * @return Result<List < PracticeVO>>
     */
    @Override
    public Result<List<PracticeVO>> query(PracticeQueryDto practiceQueryDto) {
        List<PracticeVO> practiceList = practiceMapper.query(practiceQueryDto);
        Integer totalCount = practiceMapper.queryCount(practiceQueryDto);
        return PageResult.success(practiceList, totalCount);
    }

}
