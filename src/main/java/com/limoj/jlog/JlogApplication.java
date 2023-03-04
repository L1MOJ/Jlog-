package com.limoj.jlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.limoj.jlog.mapper")
public class JlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(JlogApplication.class, args);
    }

}
