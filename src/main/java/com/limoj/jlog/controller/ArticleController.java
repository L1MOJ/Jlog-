package com.limoj.jlog.controller;

import com.limoj.jlog.domain.ResponseResult;
import com.limoj.jlog.domain.entity.Article;
import com.limoj.jlog.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name="article", description = "the Article API")
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Operation(summary = "Get all articles")
    @GetMapping("/list")
    public ResponseResult test() {

        return ResponseResult.okResult(articleService.list());
    }
    @Operation(summary = "Get articles in pages")
    @GetMapping("/allArticleList")
    public ResponseResult allArticleList(Integer pageNum, Integer pageSize, Long categoryId) {
        return articleService.allArticleList(pageNum,pageSize,categoryId);
    }

    @Operation(summary = "Get stared articles")
    @GetMapping("/staredArticles")
    public ResponseResult staredArticleList() {
        ResponseResult responseResult = articleService.staredArticleList();
        return responseResult;
    }

    @Operation(summary = "Get 5 newly posted articles")
    @GetMapping("/newArticles")
    public ResponseResult newArticles() {
        ResponseResult responseResult = articleService.newArticleList();
        return responseResult;
    }

    @GetMapping("/{id}")
    public ResponseResult getArticleDetail(@PathVariable("id") Long id) {
        return articleService.getArticleDetail(id);
    }
}
