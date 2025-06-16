package cn.kmbeast.service.impl;

import cn.kmbeast.mapper.ProjectTypeMapper;
import cn.kmbeast.pojo.api.ApiResult;
import cn.kmbeast.pojo.api.PageResult;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.ProjectTypeQueryDto;
import cn.kmbeast.pojo.entity.ProjectType;
import cn.kmbeast.service.ProjectTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 科目业务逻辑实现
 */
@Service
public class ProjectTypeServiceImpl implements ProjectTypeService {

    @Resource
    private ProjectTypeMapper projectTypeMapper;

    /**
     * 科目新增
     *
     * @param projectType 参数
     * @return Result<Void>
     */
    @Override
    public Result<Void> save(ProjectType projectType) {
        projectTypeMapper.save(projectType);
        return ApiResult.success();
    }

    /**
     * 科目删除
     *
     * @param ids 参数
     * @return Result<Void>
     */
    @Override
    public Result<Void> batchDelete(List<Long> ids) {
        projectTypeMapper.batchDelete(ids);
        return ApiResult.success();
    }

    /**
     * 科目修改
     *
     * @param projectType 参数
     * @return Result<Void>
     */
    @Override
    public Result<Void> update(ProjectType projectType) {
        projectTypeMapper.update(projectType);
        return ApiResult.success();
    }

    /**
     * 科目查询
     *
     * @param projectTypeQueryDto 查询参数
     * @return Result<List < ProjectType>>
     */
    @Override
    public Result<List<ProjectType>> query(ProjectTypeQueryDto projectTypeQueryDto) {
        List<ProjectType> projectTypeList = projectTypeMapper.query(projectTypeQueryDto);
        Integer totalCount = projectTypeMapper.queryCount(projectTypeQueryDto);
        return PageResult.success(projectTypeList, totalCount);
    }


}
