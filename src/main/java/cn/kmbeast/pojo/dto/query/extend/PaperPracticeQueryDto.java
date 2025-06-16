package cn.kmbeast.pojo.dto.query.extend;

import cn.kmbeast.pojo.dto.query.base.QueryDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PaperPracticeQueryDto extends QueryDto {
    private Integer id;
    private Integer paperId;
    private Integer practiceId;
}
