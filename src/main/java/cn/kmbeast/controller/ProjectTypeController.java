package cn.kmbeast.controller;

import cn.kmbeast.aop.Pager;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.ProjectTypeQueryDto;
import cn.kmbeast.pojo.entity.ProjectType;
import cn.kmbeast.service.ProjectTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 科目的 Controller
 */
@RestController
@RequestMapping(value = "/project-type")
public class ProjectTypeController {

    @Resource
    private ProjectTypeService projectTypeService;

    /**
     * 科目新增
     *
     * @param projectType 新增数据
     * @return Result<Void> 通用响应体
     */
    @PostMapping(value = "/save")
    public Result<Void> save(@RequestBody ProjectType projectType) {
        return projectTypeService.save(projectType);
    }

    /**
     * 科目删除
     *
     * @param ids 要删除的科目ID列表
     * @return Result<Void> 通用响应体
     */
    @PostMapping(value = "/batchDelete")
    public Result<Void> batchDelete(@RequestBody List<Long> ids) {
        return projectTypeService.batchDelete(ids);
    }

    /**
     * 科目修改
     *
     * @param projectType 参数
     * @return Result<Void> 响应
     */
    @PutMapping(value = "/update")
    public Result<Void> update(@RequestBody ProjectType projectType) {
        return projectTypeService.update(projectType);
    }

    /**
     * 科目查询
     *
     * @param projectTypeQueryDto 查询参数
     * @return Result<List < projectType>> 通用响应
     */
    @Pager
    @PostMapping(value = "/query")
    public Result<List<ProjectType>> query(@RequestBody ProjectTypeQueryDto projectTypeQueryDto) {
        return projectTypeService.query(projectTypeQueryDto);
    }

}
