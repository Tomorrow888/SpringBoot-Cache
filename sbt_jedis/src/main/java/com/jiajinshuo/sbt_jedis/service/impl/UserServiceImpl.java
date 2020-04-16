package com.jiajinshuo.sbt_jedis.service.impl;

import com.jiajinshuo.sbt_jedis.config.JedisUtil;
import com.jiajinshuo.sbt_jedis.domain.User;
import com.jiajinshuo.sbt_jedis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiajinshuo
 * @create 2020-03-25 15:02
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    JedisPool jedisPool;//redis连接池

    @Override
    public String getString(String key) {
        String val = null;
        //1,得到jedis连接对象
        Jedis jedis = jedisPool.getResource();
        //2,判断key是否存在
        if(jedis.exists(key)){
            log.info("查询redis中的数据");
            jedis.get(key);
            val = jedis.get(key);
        }else {
            val = "sbt整合redis";
            log.info("查询的是MySQL中的数据");
            //查到后赋值给redis
            jedis.set(key,val);
        }
        //3,关闭连接
        jedis.close();
        return val;

    }

    @Override
    public User selectUserById(Integer id) {

        String key = "user:"+id;//实体类名:id
        User user = new User();
        Jedis jedis = JedisUtil.getJedis();
        if(jedis.exists(key)){
            log.info("查询的是redis中的数据");
            Map<String, String> map = jedis.hgetAll(key);
            user.setAge(Integer.parseInt(map.get("age")));

        }else {
            log.info("查询的是MySQL中的数据");

            user.setId(1);
            user.setName("marry");
            user.setAge(19);

            Map<String,Object> map = new HashMap<>();
            map.put("name",user.getName());
            map.put("id",user.getId());
            map.put("age",user.getAge());
            //存到redis中
            String hmset = (String) jedis.hmset(key, map);
        }

        JedisUtil.close(jedis);
        return user;
    }


    /**
     * key的有限期有24h
     * @param key
     * @param value
     */

    public void expireStr(String key,String value){
        Jedis jedis = JedisUtil.getJedis();

        jedis.set(key,value);
        jedis.expire(key,24 * 60 * 60);
        jedis.close();


    }
}
