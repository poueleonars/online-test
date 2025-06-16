package cn.kmbeast.service;

import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.PaperPracticeQueryDto;
import cn.kmbeast.pojo.entity.PaperPractice;
import cn.kmbeast.pojo.vo.PaperPracticeVO;

import java.util.List;

/**
 * 试卷试题业务逻辑接口
 */
public interface PaperPracticeService {

    Result<Void> batchSave(List<PaperPractice> paperPractices);

    Result<Void> batchDelete(List<Integer> ids);

    Result<List<PaperPracticeVO>> query(PaperPracticeQueryDto practiceQueryDto);

}
