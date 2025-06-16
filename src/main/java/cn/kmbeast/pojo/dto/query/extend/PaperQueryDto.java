package cn.kmbeast.pojo.dto.query.extend;

import cn.kmbeast.pojo.dto.query.base.QueryDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PaperQueryDto extends QueryDto {
    private Integer id;
    private String name;
    private Integer projectId;
    private Integer userId;
    private String detail;
    private Long limitTime;
    private Integer totalScore;
    private Boolean isShow;

}
