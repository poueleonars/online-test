package cn.kmbeast.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 科目试题
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectType {
    private Integer id;
    private String name;
}
