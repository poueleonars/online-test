package cn.kmbeast.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 考试成绩实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestHistory {

    private Integer id;
    private Integer practiceId;
    private Integer paperId;
    private Integer userId;
    private Integer postScore;
    private String answer;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
