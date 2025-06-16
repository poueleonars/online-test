package cn.kmbeast.pojo.vo;

import cn.kmbeast.pojo.entity.Practice;
import cn.kmbeast.pojo.entity.TestHistory;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TestHistoryVO extends TestHistory {
    private String projectName;
    private Integer paperId;
    private String paperName;
    private String askItem;
    private String question;
    private String askAnswer;
    private String rightAnswer;
    private Integer practiceType;
    private String userName;
}
