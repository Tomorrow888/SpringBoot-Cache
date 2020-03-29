package com.jiajinshuo.sbt_jedis;

import com.jiajinshuo.sbt_jedis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.JedisPool;

@SpringBootTest
class SbtJedisApplicationTests {

    @Autowired
    UserService userService;
    /**
     * jedis操作string类型
     *
     */
    @Test
    public void StringTest(){
        String name = userService.getString("name");
        System.out.println(name);
    }
}
