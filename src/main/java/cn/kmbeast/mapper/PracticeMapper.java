package cn.kmbeast.mapper;

import cn.kmbeast.pojo.dto.query.extend.PracticeQueryDto;
import cn.kmbeast.pojo.entity.Practice;
import cn.kmbeast.pojo.vo.PracticeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 实体持久化接口
 */
@Mapper
public interface PracticeMapper {

    void save(Practice practice);

    void update(Practice practice);

    void batchDelete(@Param(value = "ids") List<Integer> ids);

    List<PracticeVO> query(PracticeQueryDto practiceQueryDto);

    List<PracticeVO> queryByIds(@Param(value = "ids") List<Integer> ids);

    Integer queryCount(PracticeQueryDto practiceQueryDto);

}
