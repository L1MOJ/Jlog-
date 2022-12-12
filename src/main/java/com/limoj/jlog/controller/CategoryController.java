package com.limoj.jlog.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.limoj.jlog.domain.ResponseResult;
import com.limoj.jlog.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 分类表(Category)表控制层
 *
 * @author makejava
 * @since 2022-12-11 16:39:26
 */
@RestController
@Tag(name="category", description = "the Category API")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/getCategoryList")
    public ResponseResult getCategoryList(){
        return categoryService.getCategoryList();
    }

    @PostMapping("/add")
    public ResponseResult addCategory(@RequestBody String categoryName) {
        return categoryService.addCategory(categoryName);
    }
}

