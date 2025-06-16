package cn.kmbeast.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 试题实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Practice {

    private Integer id;
    private Integer practiceType;
    /**
     * 题目的富文本
     */
    private String askItem;
    /**
     * 题目的列表显示
     */
    private String askItemText;
    private Integer projectId;
    private Integer userId;
    private String question;
    private String answer;
    private String rightAnswer;
    private Integer score;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
