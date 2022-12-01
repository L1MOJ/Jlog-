package com.limoj.jlog;

import com.limoj.jlog.mapper.ArticleMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.limoj.jlog.mapper")
class JlogApplicationTests {

    @Autowired
    private ArticleMapper articleMapper;
    @Test
    void contextLoads() {
        System.out.println(articleMapper.selectList(null));;
    }

}
