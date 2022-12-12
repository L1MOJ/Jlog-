package com.limoj.jlog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.limoj.jlog.domain.ResponseResult;
import com.limoj.jlog.domain.entity.Article;
import com.limoj.jlog.domain.vo.ArticleDetailVo;

import java.util.List;

public interface ArticleService extends IService<Article> {

    ResponseResult staredArticleList();

    ResponseResult getArticleDetail(Long id);

    ResponseResult newArticleList();

    ResponseResult allArticleList(Integer pageNum, Integer pageSize, Long categoryId, String content);

    ResponseResult getCategory();

    ResponseResult delArticles(List<Integer> articleIds);

    ResponseResult editArticle(Article article);

    ResponseResult addArticle(Article article);

    ResponseResult starArticles(List<Integer> articleIds);
}
