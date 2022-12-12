package com.limoj.jlog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.limoj.jlog.domain.ResponseResult;
import com.limoj.jlog.domain.entity.Category;

/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-12-11 16:39:35
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();

    ResponseResult addCategory(String categoryName);
}

