package cn.kmbeast.service.impl;

import cn.kmbeast.mapper.PaperPracticeMapper;
import cn.kmbeast.pojo.api.ApiResult;
import cn.kmbeast.pojo.api.PageResult;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.PaperPracticeQueryDto;
import cn.kmbeast.pojo.entity.PaperPractice;
import cn.kmbeast.pojo.vo.PaperPracticeVO;
import cn.kmbeast.service.PaperPracticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 试题试题业务逻辑实现
 */
@Service
public class PaperPracticeServiceImpl implements PaperPracticeService {

    @Resource
    private PaperPracticeMapper paperPracticeMapper;

    /**
     * 试卷新增
     *
     * @param paperPractices 参数
     * @return Result<Void>
     */
    @Override
    public Result<Void> batchSave(List<PaperPractice> paperPractices) {
        System.out.println(paperPractices);
        paperPracticeMapper.batchSave(paperPractices);
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
        paperPracticeMapper.batchDelete(ids);
        return ApiResult.success();
    }

    /**
     * 试卷查询
     *
     * @param paperPracticeQueryDto 查询参数
     * @return Result<List < PaperPracticeVO>>
     */
    @Override
    public Result<List<PaperPracticeVO>> query(PaperPracticeQueryDto paperPracticeQueryDto) {
        List<PaperPracticeVO> paperPracticeList = paperPracticeMapper.query(paperPracticeQueryDto);
        Integer totalCount = paperPracticeMapper.queryCount(paperPracticeQueryDto);
        return PageResult.success(paperPracticeList, totalCount);
    }


}
