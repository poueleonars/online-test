package cn.kmbeast.pojo.vo;

import cn.kmbeast.pojo.entity.Paper;
import cn.kmbeast.pojo.entity.Practice;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PracticeVO extends Practice {
    private String projectName;
    private String userName;
}
