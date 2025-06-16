package cn.kmbeast.mapper;

import cn.kmbeast.pojo.dto.query.extend.ProjectTypeQueryDto;
import cn.kmbeast.pojo.entity.ProjectType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 标签持久化接口
 */
@Mapper
public interface ProjectTypeMapper {

    void save(ProjectType projectType);

    void update(ProjectType projectType);

    void batchDelete(@Param(value = "ids") List<Long> ids);

    List<ProjectType> query(ProjectTypeQueryDto projectTypeQueryDto);

    Integer queryCount(ProjectTypeQueryDto projectTypeQueryDto);

}
