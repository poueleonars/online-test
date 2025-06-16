package cn.kmbeast.pojo.vo;

import cn.kmbeast.pojo.entity.PaperPractice;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PaperPracticeVO extends PaperPractice {
    private String askItem;
    private String score;
    private String question;
    private String answer;
    private String rightAnswer;
    private String projectType;
    private String projectName;
    private String practiceType;
}
