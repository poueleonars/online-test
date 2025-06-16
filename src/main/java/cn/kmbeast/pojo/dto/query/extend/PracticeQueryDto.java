package cn.kmbeast.pojo.dto.query.extend;

import cn.kmbeast.pojo.dto.query.base.QueryDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PracticeQueryDto extends QueryDto {
    private Integer id;
    private String askItem;
    private Integer projectId;
    private Integer practiceType;
    private Integer userId;
    private String detail;
    private Integer score;
}
