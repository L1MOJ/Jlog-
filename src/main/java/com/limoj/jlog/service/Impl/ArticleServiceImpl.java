package com.limoj.jlog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.limoj.jlog.constants.SystemConstants;
import com.limoj.jlog.domain.ResponseResult;
import com.limoj.jlog.domain.entity.Article;
import com.limoj.jlog.domain.vo.*;
import com.limoj.jlog.mapper.ArticleMapper;
import com.limoj.jlog.service.ArticleService;
import com.limoj.jlog.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements ArticleService {

    @Override
    public ResponseResult staredArticleList() {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //必须是正式文章，不能是草稿
        queryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);

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

        Long categoryId = articleDetailVo.getCategoryId();

        return null;
    }

    @Override
    public ResponseResult newArticleList() {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //必须是正式文章，不能是草稿
        queryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        //按创建时间排序，后续可能改为按更新时间,去五个最新的
        queryWrapper.orderByDesc(Article::getCreateTime);
        queryWrapper.last("limit 5");

        List<Article> articles = baseMapper.selectList(queryWrapper);

        List<NewArticleVo> vs = BeanCopyUtils.copyBeanList(articles, NewArticleVo.class);
        return ResponseResult.okResult(vs);
    }

    @Override
    public ResponseResult allArticleList(Integer pageNum, Integer pageSize, Long categoryId) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //判断是否传来categoryId,查询时和传来的相同
        queryWrapper.eq(Objects.nonNull(categoryId) && categoryId > 0,Article::getCategoryId,categoryId);
        //正式文章
        queryWrapper.eq(Article::getStatus,SystemConstants.ARTICLE_STATUS_NORMAL);
        //默认按发布时间排序，后续可能会考虑置顶？
        queryWrapper.orderByDesc(Article::getCreateTime);
        //分页查询
        Page<Article> page = new Page<>(pageNum,pageSize);
        page(page,queryWrapper);
        //结果封装
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVo.class);

        PageVo pageVo = new PageVo(articleListVos,page.getTotal());

        return ResponseResult.okResult(pageVo);

    }


}
