package cn.kmbeast.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 试卷实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paper {

    private Integer id;
    private String name;
    private Integer projectId;
    private Integer userId;
    private String detail;
    private Long limitTime;
    private Integer totalScore;
    private Boolean isShow;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
