package cn.kmbeast.pojo.dto.save;

import cn.kmbeast.pojo.entity.TestHistory;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 考试参数接收类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TestHistoryDto extends TestHistory {

    /**
     * 考试开始时间
     */
    private Long startTime;

    /**
     * 考试结束时间
     */
    private Long endTime;

}
