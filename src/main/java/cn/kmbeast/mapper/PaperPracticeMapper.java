package cn.kmbeast.mapper;

import cn.kmbeast.pojo.dto.query.extend.PaperPracticeQueryDto;
import cn.kmbeast.pojo.entity.PaperPractice;
import cn.kmbeast.pojo.vo.PaperPracticeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 试卷试题关联持久化接口
 */
@Mapper
public interface PaperPracticeMapper {

    void batchSave(List<PaperPractice> paperPractices);

    void batchDelete(@Param(value = "ids") List<Integer> ids);

    List<PaperPracticeVO> query(PaperPracticeQueryDto paperPracticeQueryDto);

    Integer queryCount(PaperPracticeQueryDto paperPracticeQueryDto);
    void del(List<Integer> ids);

}
