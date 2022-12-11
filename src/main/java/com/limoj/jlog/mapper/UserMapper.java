package com.limoj.jlog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.limoj.jlog.domain.entity.Article;
import com.limoj.jlog.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
