package com.limoj.jlog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.limoj.jlog.domain.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
