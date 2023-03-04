package com.limoj.jlog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.limoj.jlog.domain.entity.Category;
import com.limoj.jlog.domain.entity.Donator;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
