package cn.kmbeast.service;

import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.AutoCreatePaper;
import cn.kmbeast.pojo.dto.query.extend.PaperQueryDto;
import cn.kmbeast.pojo.entity.Paper;
import cn.kmbeast.pojo.vo.ChartVO;
import cn.kmbeast.pojo.vo.PaperVO;

import java.util.List;

/**
 * 试卷业务逻辑接口
 */
public interface PaperService {

    Result<Void> save(Paper paper);

    Result<Void> batchDelete(List<Integer> ids);

    Result<Void> update(Paper paper);

    Result<List<PaperVO>> query(PaperQueryDto paperQueryDto);

    Result<Void> autoCreatePaper(AutoCreatePaper autoCreatePaper);

    Result<List<ChartVO>> daysQuery(Integer day);
}
