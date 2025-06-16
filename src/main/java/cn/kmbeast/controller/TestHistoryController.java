package cn.kmbeast.controller;

import cn.kmbeast.aop.Pager;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.TestHistoryQueryDto;
import cn.kmbeast.pojo.dto.save.TestHistoryDto;
import cn.kmbeast.pojo.entity.TestHistory;
import cn.kmbeast.pojo.vo.TestHistoryVO;
import cn.kmbeast.service.TestHistoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 答题历史的 Controller
 */
@RestController
@RequestMapping(value = "/test-history")
public class TestHistoryController {

    @Resource
    private TestHistoryService testHistoryService;

    /**
     * 成绩新增
     *
     * @param testHistoryDtos 新增数据列表
     * @return Result<Void> 通用响应体
     */
    @PostMapping(value = "/save")
    public Result<Void> save(@RequestBody List<TestHistoryDto> testHistoryDtos) {
        return testHistoryService.save(testHistoryDtos);
    }

    /**
     * 成绩删除
     *
     * @param ids 要删除的成绩ID列表
     * @return Result<Void> 通用响应体
     */
    @PostMapping(value = "/batchDelete")
    public Result<Void> batchDelete(@RequestBody List<Integer> ids) {
        return testHistoryService.batchDelete(ids);
    }

    /**
     * 成绩修改
     *
     * @param testHistory 参数
     * @return Result<Void> 响应
     */
    @PutMapping(value = "/update")
    public Result<Void> update(@RequestBody TestHistory testHistory) {
        return testHistoryService.update(testHistory);
    }

    /**
     * 成绩查询
     *
     * @param testHistoryQueryDto 查询参数
     * @return Result<List < TestHistoryVO>> 通用响应
     */
    @Pager
    @PostMapping(value = "/userQuery")
    public Result<List<TestHistoryVO>> query(@RequestBody TestHistoryQueryDto testHistoryQueryDto) {
        return testHistoryService.query(testHistoryQueryDto);
    }

}

