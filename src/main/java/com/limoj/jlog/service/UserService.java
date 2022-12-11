package com.limoj.jlog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.limoj.jlog.domain.ResponseResult;
import com.limoj.jlog.domain.entity.User;


/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-12-10 22:14:14
 */
public interface UserService extends IService<User> {
    ResponseResult login(User user);
}

