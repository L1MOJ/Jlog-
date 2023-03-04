package com.limoj.jlog.controller;

import com.limoj.jlog.domain.ResponseResult;
import com.limoj.jlog.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

