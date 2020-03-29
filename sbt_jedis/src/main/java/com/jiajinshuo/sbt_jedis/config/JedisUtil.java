package com.jiajinshuo.sbt_jedis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author jiajinshuo
 * @create 2020-03-25 15:42
 * jedis工具类
 *
 */
@Component
public class JedisUtil {

    @Autowired
    static JedisPool jedisPool;

    /**
     * 获得redis连接
     * @return
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    /**
     * 释放资源
     * @param jedis
     */
    public static void close(Jedis jedis){
        if(jedis != null){
            jedis.close();
        }

    }
}
