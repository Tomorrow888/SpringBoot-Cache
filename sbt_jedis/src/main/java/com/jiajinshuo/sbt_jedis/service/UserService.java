package com.jiajinshuo.sbt_jedis.service;

import com.jiajinshuo.sbt_jedis.domain.User;

/**
 * @author jiajinshuo
 * @create 2020-03-25 15:01
 */
public interface UserService {

    /**
     * redis  String 类型
     * @param key
     * @return
     */
    String getString(String key);

    public User selectUserById(Integer id);
}
