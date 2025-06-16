package cn.kmbeast.service;

import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.PracticeQueryDto;
import cn.kmbeast.pojo.entity.Practice;
import cn.kmbeast.pojo.vo.PracticeVO;

import java.util.List;

/**
 * 试题业务逻辑接口
 */
public interface PracticeService {

    Result<Void> save(Practice practice);

    Result<Void> batchDelete(List<Integer> ids);

    Result<Void> update(Practice practice);

    Result<List<PracticeVO>> query(PracticeQueryDto practiceQueryDto);

}
