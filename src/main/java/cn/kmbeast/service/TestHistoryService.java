package cn.kmbeast.service;

import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.TestHistoryQueryDto;
import cn.kmbeast.pojo.dto.save.TestHistoryDto;
import cn.kmbeast.pojo.entity.TestHistory;
import cn.kmbeast.pojo.vo.TestHistoryVO;

import java.util.List;

/**
 * 答题历史业务逻辑接口
 */
public interface TestHistoryService {

    Result<Void> save(List<TestHistoryDto> testHistoryDtos);

    Result<Void> batchDelete(List<Integer> ids);

    Result<Void> update(TestHistory testHistory);

    Result<List<TestHistoryVO>> query(TestHistoryQueryDto testHistoryQueryDto);

}
