package com.limoj.jlog.domain.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

//存入一个是否精选标签，若精选，则展示在首页
public class NewArticleVo {
    private Long id;
    //标题
    private String title;
    private Date createTime;
}
