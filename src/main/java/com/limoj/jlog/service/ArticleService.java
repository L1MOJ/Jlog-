package com.limoj.jlog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.limoj.jlog.domain.ResponseResult;
import com.limoj.jlog.domain.entity.Article;

public interface ArticleService extends IService<Article> {

    ResponseResult staredArticleList();

    ResponseResult getArticleDetail(Long id);

    ResponseResult newArticleList();

    ResponseResult allArticleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getCategory();
}
