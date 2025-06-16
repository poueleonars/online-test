package cn.kmbeast.controller;

import cn.kmbeast.aop.Pager;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.PaperPracticeQueryDto;
import cn.kmbeast.pojo.entity.PaperPractice;
import cn.kmbeast.pojo.vo.PaperPracticeVO;
import cn.kmbeast.service.PaperPracticeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 试题的 Controller
 */
@RestController
@RequestMapping(value = "/paper-practice")
public class PaperPracticeController {

    @Resource
    private PaperPracticeService paperPracticeService;

    /**
     * 试卷题目新增
     *
     * @param paperPractices 新增数据
     * @return Result<Void> 通用响应体
     */
    @PostMapping(value = "/batchSave")
    public Result<Void> batchSave(@RequestBody List<PaperPractice> paperPractices) {
        return paperPracticeService.batchSave(paperPractices);
    }

    /**
     * 试卷题目删除
     *
     * @param ids 要删除的试卷题目ID列表
     * @return Result<Void> 通用响应体
     */
    @PostMapping(value = "/batchDelete")
    public Result<Void> batchDelete(@RequestBody List<Integer> ids) {
        System.out.println(ids);
        return paperPracticeService.batchDelete(ids);
    }

    /**
     * 试卷题目查询
     *
     * @param paperPracticeQueryDto 查询参数
     * @return Result<List < PaperPracticeVO>> 通用响应
     */
    @Pager
    @PostMapping(value = "/query")
    public Result<List<PaperPracticeVO>> query(@RequestBody PaperPracticeQueryDto paperPracticeQueryDto) {
        return paperPracticeService.query(paperPracticeQueryDto);
    }

}
