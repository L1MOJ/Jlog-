package com.limoj.jlog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.limoj.jlog.constants.SystemConstants;
import com.limoj.jlog.domain.ResponseResult;
import com.limoj.jlog.domain.entity.User;
import com.limoj.jlog.enums.AppHttpCodeEnum;
import com.limoj.jlog.mapper.UserMapper;
import com.limoj.jlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-12-10 22:14:14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public ResponseResult login(User user){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,user.getUserName());
        queryWrapper.eq(User::getPassword,user.getPassword());
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        User ouser = baseMapper.selectOne(queryWrapper);
        if (ouser != null){
            return ResponseResult.okResult(ouser);
        }
        return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_ERROR);
    }
}

