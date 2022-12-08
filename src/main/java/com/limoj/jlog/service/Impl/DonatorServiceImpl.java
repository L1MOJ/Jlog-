package com.limoj.jlog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.limoj.jlog.domain.ResponseResult;
import com.limoj.jlog.domain.entity.Article;
import com.limoj.jlog.domain.entity.Donator;
import com.limoj.jlog.domain.vo.PageVo;
import com.limoj.jlog.mapper.DonatorMapper;
import com.limoj.jlog.service.DonatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Donator)表服务实现类
 *
 * @author makejava
 * @since 2022-12-01 18:36:47
 */
@Service("donatorService")
public class DonatorServiceImpl extends ServiceImpl<DonatorMapper, Donator> implements DonatorService {

    @Override
    public ResponseResult getDonators(Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Donator> donatorWrapper = new LambdaQueryWrapper<>();
        //按打赏时间排序
        donatorWrapper.orderByDesc(Donator::getMoney);

        Page<Donator> page = new Page<>(pageNum,pageSize);
        page(page,donatorWrapper);

        PageVo pageVo = new PageVo(page.getRecords(),page.getTotal());

        return ResponseResult.okResult(pageVo);
    }
}

