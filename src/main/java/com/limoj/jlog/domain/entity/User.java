package com.limoj.jlog.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    //用户名
    private String userName;
    //密码
    private String password;
}
