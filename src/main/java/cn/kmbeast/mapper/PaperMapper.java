package cn.kmbeast.mapper;

import cn.kmbeast.pojo.dto.query.extend.PaperQueryDto;
import cn.kmbeast.pojo.entity.Paper;
import cn.kmbeast.pojo.vo.PaperVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 试卷持久化接口
 */
@Mapper
public interface PaperMapper {

    void save(Paper paper);

    void update(Paper paper);

    void batchDelete(@Param(value = "ids") List<Integer> ids);

    List<PaperVO> query(PaperQueryDto paperQueryDto);

    Integer queryCount(PaperQueryDto paperQueryDto);

}
