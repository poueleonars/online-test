package cn.kmbeast.service;

import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.ProjectTypeQueryDto;
import cn.kmbeast.pojo.entity.ProjectType;

import java.util.List;

/**
 * 标签业务逻辑接口
 */
public interface ProjectTypeService {

    Result<Void> save(ProjectType projectType);

    Result<Void> batchDelete(List<Long> ids);

    Result<Void> update(ProjectType projectType);

    Result<List<ProjectType>> query(ProjectTypeQueryDto projectTypeQueryDto);

}
