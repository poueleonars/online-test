package cn.kmbeast.controller;

import cn.kmbeast.aop.Pager;
import cn.kmbeast.pojo.api.ApiResult;
import cn.kmbeast.pojo.api.Result;
import cn.kmbeast.pojo.dto.query.extend.PracticeQueryDto;
import cn.kmbeast.pojo.em.PracticeTypeEnum;
import cn.kmbeast.pojo.entity.Practice;
import cn.kmbeast.pojo.vo.PracticeTypeVO;
import cn.kmbeast.pojo.vo.PracticeVO;
import cn.kmbeast.service.PracticeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 试题的 Controller
 */
@RestController
@RequestMapping(value = "/practice")
public class PracticeController {

    @Resource
    private PracticeService practiceService;

    /**
     * 获取全部的题目类型
     *
     * @return Result<Void> 通用响应体
     */
    @GetMapping(value = "/getPracticeTypes")
    public Result<List<PracticeTypeVO>> getPracticeTypes() {
        List<PracticeTypeVO> practiceTypeVOS = new ArrayList<>();
        PracticeTypeEnum[] practiceTypeEnums = PracticeTypeEnum.values();
        for (PracticeTypeEnum practiceTypeEnum : practiceTypeEnums) {
            PracticeTypeVO practiceTypeVO = new PracticeTypeVO(
                    practiceTypeEnum.getType(),
                    practiceTypeEnum.getDetail()
            );
            practiceTypeVOS.add(practiceTypeVO);
        }
        return ApiResult.success(practiceTypeVOS);
    }

    /**
     * 题目新增
     *
     * @param practice 新增数据
     * @return Result<Void> 通用响应体
     */
    @PostMapping(value = "/save")
    public Result<Void> save(@RequestBody Practice practice) {
        return practiceService.save(practice);
    }

    /**
     * 题目删除
     *
     * @param ids 要删除的题目ID列表
     * @return Result<Void> 通用响应体
     */
    @PostMapping(value = "/batchDelete")
    public Result<Void> batchDelete(@RequestBody List<Integer> ids) {
        return practiceService.batchDelete(ids);
    }

    /**
     * 题目修改
     *
     * @param practice 参数
     * @return Result<Void> 响应
     */
    @PostMapping(value = "/update")
    public Result<Void> update(@RequestBody Practice practice) {
        return practiceService.update(practice);
    }

    /**
     * 题目查询
     *
     * @param practiceQueryDto 查询参数
     * @return Result<List < PracticeVO>> 通用响应
     */
    @Pager
    @PostMapping(value = "/query")
    public Result<List<PracticeVO>> query(@RequestBody PracticeQueryDto practiceQueryDto) {
        return practiceService.query(practiceQueryDto);
    }

}
