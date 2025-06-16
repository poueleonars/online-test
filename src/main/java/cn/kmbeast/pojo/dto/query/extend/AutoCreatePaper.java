package cn.kmbeast.pojo.dto.query.extend;

import lombok.Data;

/**
 * 自动组卷配置接收类
 */
@Data
public class AutoCreatePaper {
    /**
     * 生成的单选题
     */
    private Integer oneSelected;
    /**
     * 生成的多选题
     */
    private Integer doubleSelected;
    /**
     * 生成的填空题
     */
    private Integer putWord;
    /**
     * 生成的判断题
     */
    private Integer judgeSelected;
    /**
     * 科目ID
     */
    private Integer projectId;
    /**
     * 试卷ID
     */
    private Integer paperId;
}
