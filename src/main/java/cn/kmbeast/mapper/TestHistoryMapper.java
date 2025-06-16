package cn.kmbeast.mapper;

import cn.kmbeast.pojo.dto.query.extend.TestHistoryQueryDto;
import cn.kmbeast.pojo.entity.TestHistory;
import cn.kmbeast.pojo.vo.TestHistoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 答题历史持久化接口
 */
@Mapper
public interface TestHistoryMapper {

    void save(@Param(value = "list") List<TestHistory> list);

    void update(TestHistory testHistory);

    void batchDelete(@Param(value = "ids") List<Integer> ids);

    List<TestHistoryVO> query(TestHistoryQueryDto testHistoryQueryDto);

    Integer queryCount(TestHistoryQueryDto testHistoryQueryDto);

}
