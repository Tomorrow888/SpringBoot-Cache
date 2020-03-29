package com.jiajinshuo.sbt_senior;

import com.jiajinshuo.sbt_senior.domain.Employee;
import com.jiajinshuo.sbt_senior.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import sun.applet.resources.MsgAppletViewer;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class SbtSeniorApplicationTests {

    @Autowired(required = false)
    EmployeeMapper employeeMapper;

    @Test
    public void test1(){
        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);
    }

    //kv都是对象的
//    @Autowired
//    RedisTemplate redisTemplate;

    //kv都是字符串，因为字符串操作比较多，就单独加入组件
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;


    @Test
    public void testRedis(){
        //给redis中保存数据
        stringRedisTemplate.opsForValue().append("msg","hello");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
    }
    /**
     * 测试保存对象
     */
    @Test
    public void testObject(){
        Employee empById = employeeMapper.getEmpById(1);
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
//        redisTemplate.opsForValue().set("emp01",empById);
        //将数据以json的方式保存
        redisTemplate.opsForValue().set("emp01",empById);
        //设置key的有效期
        redisTemplate.expire("emp01",20, TimeUnit.SECONDS);

    }
}
