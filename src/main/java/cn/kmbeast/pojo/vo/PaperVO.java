package cn.kmbeast.pojo.vo;

import cn.kmbeast.pojo.entity.Paper;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PaperVO extends Paper {
    private String projectName;
    private String userName;
}
