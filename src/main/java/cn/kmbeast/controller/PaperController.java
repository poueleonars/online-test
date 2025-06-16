package cn.kmbeast.controller;

import cn.kmbeast.aop.Pager;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.AutoCreatePaper;
import cn.kmbeast.pojo.dto.query.extend.PaperQueryDto;
import cn.kmbeast.pojo.entity.Paper;
import cn.kmbeast.pojo.vo.ChartVO;
import cn.kmbeast.pojo.vo.PaperVO;
import cn.kmbeast.service.PaperService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 试卷的 Controller
 */
@RestController
@RequestMapping(value = "/paper")
public class PaperController {

    @Resource
    private PaperService paperService;

    /**
     * 试卷新增
     *
     * @param paper 新增数据
     * @return Result<Void> 通用响应体
     */
    @PostMapping(value = "/save")
    public Result<Void> save(@RequestBody Paper paper) {
        return paperService.save(paper);
    }

    /**
     * 试卷删除
     *
     * @param ids 要删除的试卷ID列表
     * @return Result<Void> 通用响应体
     */
    @PostMapping(value = "/batchDelete")
    public Result<Void> batchDelete(@RequestBody List<Integer> ids) {
        return paperService.batchDelete(ids);
    }

    /**
     * 试卷修改
     *
     * @param paper 参数
     * @return Result<Void> 响应
     */
    @PutMapping(value = "/update")
    public Result<Void> update(@RequestBody Paper paper) {
        return paperService.update(paper);
    }

    /**
     * 查询已经审核的试卷
     *
     * @param paperQueryDto 查询参数
     * @return Result<List < PaperVO>> 通用响应
     */
    @Pager
    @PostMapping(value = "/queryAudit")
    public Result<List<PaperVO>> queryAudit(@RequestBody PaperQueryDto paperQueryDto) {
        paperQueryDto.setIsShow(true);
        return paperService.query(paperQueryDto);
    }

    /**
     * 试卷查询
     *
     * @param paperQueryDto 查询参数
     * @return Result<List < PaperVO>> 通用响应
     */
    @Pager
    @PostMapping(value = "/query")
    public Result<List<PaperVO>> query(@RequestBody PaperQueryDto paperQueryDto) {
        return paperService.query(paperQueryDto);
    }

    /**
     * 自动组卷
     *
     * @param autoCreatePaper 组卷配置接收类
     * @return Result<Void> 通用响应
     */
    @Pager
    @PostMapping(value = "/autoCreatePaper")
    public Result<Void> autoCreatePaper(@RequestBody AutoCreatePaper autoCreatePaper) {
        return paperService.autoCreatePaper(autoCreatePaper);
    }

    /**
     * 统计试卷存量数据
     *
     * @return Result<List < ChartVO>> 响应结果
     */
    @GetMapping(value = "/daysQuery/{day}")
    @ResponseBody
    public Result<List<ChartVO>> query(@PathVariable Integer day) {
        return paperService.daysQuery(day);
    }


}
