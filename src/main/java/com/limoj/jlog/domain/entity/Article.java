package com.limoj.jlog.domain.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 文章表(Article)表实体类
 *
 * @author makejava
 * @since 2022-11-29 14:06:48
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    
    private Long id;
    //标题
    private String title;
    //文章内容
    private String content;
    //文章摘要
    private String summary;
    //所属分类id
    private Long categoryId;
    //类名
    private String categoryName;
    private Date createTime;

    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

    private Integer stared;
    }

