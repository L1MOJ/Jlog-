package com.limoj.jlog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.limoj.jlog.domain.ResponseResult;
import com.limoj.jlog.domain.entity.Donator;


/**
 * (Donator)表服务接口
 *
 * @author makejava
 * @since 2022-12-01 18:36:47
 */
public interface DonatorService extends IService<Donator> {
    ResponseResult getDonators(Integer pageNum, Integer pageSize);
}

