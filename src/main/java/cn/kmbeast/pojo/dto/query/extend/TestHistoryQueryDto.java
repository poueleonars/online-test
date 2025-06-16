package cn.kmbeast.pojo.dto.query.extend;

import cn.kmbeast.pojo.dto.query.base.QueryDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TestHistoryQueryDto extends QueryDto {
    private Integer id;
    private String answer;
    private Integer practiceId;
    private Integer paperId;
    private Integer userId;
    private Integer postScore;
}
