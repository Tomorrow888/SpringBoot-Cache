package com.jiajinshuo.sbt_lettuce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SbtLettuceApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    RedisTemplate redisTemplate;

}
