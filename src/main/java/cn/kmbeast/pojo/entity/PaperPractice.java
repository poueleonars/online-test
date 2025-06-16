package cn.kmbeast.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 试卷试题关联实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaperPractice {

    private Integer id;
    private Integer paperId;
    private Integer practiceId;

}
