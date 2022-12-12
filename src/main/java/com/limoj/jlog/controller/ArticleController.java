package com.limoj.jlog.controller;

import com.limoj.jlog.domain.ResponseResult;
import com.limoj.jlog.domain.entity.Article;
import com.limoj.jlog.domain.vo.ArticleDetailVo;
import com.limoj.jlog.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name="article", description = "the Article API")
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Operation(summary = "Get all categories")
    @GetMapping("/getCategoryList")
    public ResponseResult getCategory() {
        return articleService.getCategory();
    }


    @Operation(summary = "Get articles in pages")
    @GetMapping("/allArticleList")
    public ResponseResult allArticleList(Integer pageNum, Integer pageSize, Long categoryId, String content) {
        return articleService.allArticleList(pageNum,pageSize,categoryId,content);
    }

    @Operation(summary = "Get stared articles displayed on home page and rightlist")
    @GetMapping("/staredArticles")
    public ResponseResult staredArticleList() {
        ResponseResult responseResult = articleService.staredArticleList();
        return responseResult;
    }

    @Operation(summary = "Get 5 newly posted articles on rightlist")
    @GetMapping("/newArticles")
    public ResponseResult newArticles() {
        ResponseResult responseResult = articleService.newArticleList();
        return responseResult;
    }

    @Operation(summary = "Get article's detail by id")
    @GetMapping("/{id}")
    public ResponseResult getArticleDetail(@PathVariable("id") Long id) {
        return articleService.getArticleDetail(id);
    }

    @Operation(summary = "Delete articles by id")
    @PostMapping("/delArticles")
    public ResponseResult delArticles(@RequestBody List<Integer> articleIds) {
        return articleService.delArticles(articleIds);
    }
    @Operation(summary = "Star articles")
    @PostMapping("/starArticles")
    public ResponseResult starArticles(@RequestBody List<Integer> articleIds) {
        return articleService.starArticles(articleIds);
    }

    @Operation(summary = "Update edited article")
    @PostMapping("/edit")
    public ResponseResult editArticle(@RequestBody Article article) {
        return articleService.editArticle(article);
    }

    @Operation(summary = "Add article")
    @PostMapping("/add")
    public ResponseResult addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }
}
