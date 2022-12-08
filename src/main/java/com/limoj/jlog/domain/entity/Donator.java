package com.limoj.jlog.domain.entity;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Donator)表实体类
 *
 * @author makejava
 * @since 2022-12-01 18:36:59
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donator  {
    @TableId
    private Long id;

    //打赏人姓名
    private String name;
    //打赏金额
    private Long money;
    //打赏时间
    private Date donateTime;



}

