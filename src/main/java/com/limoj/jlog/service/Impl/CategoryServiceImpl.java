package com.limoj.jlog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.limoj.jlog.domain.ResponseResult;
import com.limoj.jlog.domain.entity.Category;
import com.limoj.jlog.domain.entity.User;
import com.limoj.jlog.enums.AppHttpCodeEnum;
import com.limoj.jlog.mapper.CategoryMapper;
import com.limoj.jlog.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-12-10 22:14:14
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Override
    public ResponseResult getCategoryList(){
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        List<Category> categoryList=baseMapper.selectList(queryWrapper);
        return ResponseResult.okResult(categoryList);
    }

    @Override
    public ResponseResult addCategory(String categoryName) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getName,categoryName);
        if (baseMapper.selectOne(queryWrapper)!=null){
            return ResponseResult.errorResult(AppHttpCodeEnum.CATEGORYNAME_EXIST);
        }
        Category category = new Category();
        System.out.println(category);
        category.setName(categoryName);
        baseMapper.insert(category);
        System.out.println(category);
        return ResponseResult.okResult(category);
    }

}

