package com.limoj.jlog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.limoj.jlog.constants.SystemConstants;
import com.limoj.jlog.domain.ResponseResult;
import com.limoj.jlog.domain.entity.Article;
import com.limoj.jlog.domain.entity.Category;
import com.limoj.jlog.domain.vo.*;
import com.limoj.jlog.enums.AppHttpCodeEnum;
import com.limoj.jlog.mapper.ArticleMapper;
import com.limoj.jlog.service.ArticleService;
import com.limoj.jlog.service.CategoryService;
import com.limoj.jlog.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements ArticleService {

    @Override
    public ResponseResult staredArticleList() {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //必须是精选文章
        queryWrapper.eq(Article::getStared,SystemConstants.ARTICLE_STARED);
        List<Article> articles = baseMapper.selectList(queryWrapper);
        List<StaredArticleVo> vs = BeanCopyUtils.copyBeanList(articles, StaredArticleVo.class);
        return ResponseResult.okResult(vs);
    }

    @Override
    public ResponseResult getArticleDetail(Long id) {
        //根据id查询文章
        Article article = getById(id);
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article, ArticleDetailVo.class);
        return ResponseResult.okResult(articleDetailVo);
    }

    @Override
    public ResponseResult newArticleList() {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //按创建时间排序，后续可能改为按更新时间,取五个最新的
        queryWrapper.orderByDesc(Article::getCreateTime);
        queryWrapper.last("limit 5");
        List<Article> articles = baseMapper.selectList(queryWrapper);
        List<NewArticleVo> vs = BeanCopyUtils.copyBeanList(articles, NewArticleVo.class);
        return ResponseResult.okResult(vs);
    }

    @Override
    public ResponseResult allArticleList(Integer pageNum, Integer pageSize, Long categoryId,String content) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //判断是否传来categoryId,查询时和传来的相同,没传来则全部查询
        queryWrapper.eq(Objects.nonNull(categoryId) && categoryId > 0,Article::getCategoryId,categoryId);
        //如果content为null则查询全部
        queryWrapper.like(Objects.nonNull(content),Article::getTitle,content);
        //默认按发布时间排序，后续可能会考虑置顶？
        queryWrapper.orderByDesc(Article::getCreateTime);
        //分页查询
        Page<Article> page = new Page<>(pageNum,pageSize);
        page(page,queryWrapper);
        //结果封装
        List<ArticleDetailVo> articleDetailVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleDetailVo.class);
        PageVo pageVo = new PageVo(articleDetailVos,page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult getCategory() {
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        List<Article> articleList = baseMapper.selectList(articleWrapper);
        List<Article> categoryList = articleList.stream()
                .collect(Collectors.toMap(Article::getCategoryId, a -> a, (k1, k2) -> k1)) // 根据文章id去重
                .values().stream().collect(Collectors.toList()); // 提取去重后的文章列表
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categoryList, CategoryVo.class);
        return ResponseResult.okResult(categoryVos);
    }

    @Override
    public ResponseResult delArticles(List<Integer> articleIds) {
        UpdateWrapper<Article> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("id",articleIds);
        updateWrapper.set("del_flag",SystemConstants.ARTICLE_STATUS_DEL);
        baseMapper.update(null,updateWrapper);
        List<Article> articleList = baseMapper.selectList(updateWrapper);
        return ResponseResult.okResult(articleList);
    }

    @Override
    public ResponseResult starArticles(List<Integer> articleIds) {
        List<Article> articles = baseMapper.selectBatchIds(articleIds);
        for(Article article : articles) {
            article.setStared(article.getStared()==SystemConstants.ARTICLE_NOTSTARED?SystemConstants.ARTICLE_STARED:SystemConstants.ARTICLE_NOTSTARED);
            baseMapper.updateById(article);
        }
        return ResponseResult.okResult(articleIds);
    }
    @Autowired
    private CategoryService categoryService;
    @Override
    public ResponseResult editArticle(Article article) {
        UpdateWrapper<Article> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",article.getId());
        baseMapper.update(article,updateWrapper);
        Category category = categoryService.getBaseMapper().selectById(article.getCategoryId());
        updateWrapper.set("category_name",category.getName());
        baseMapper.update(article,updateWrapper);
        article.setCategoryName(category.getName());
        return ResponseResult.okResult(article);
    }

    @Override
    public ResponseResult addArticle(Article article) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getTitle,article.getTitle());
        if (baseMapper.selectOne(queryWrapper)!=null){
            return ResponseResult.errorResult(AppHttpCodeEnum.ARTICLE_EXIST);
        }
        baseMapper.insert(article);
        return ResponseResult.okResult(article);
    }
}
