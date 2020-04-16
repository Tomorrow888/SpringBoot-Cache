package com.jiajinshuo.sbt_jedis.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jiajinshuo
 * @create 2020-03-25 15:24
 * 因为默认使用的是 JDK的序列化，所以这边要实现接口
 */
@Data
public class User implements Serializable {

    private String name;
    private Integer id;
    private Integer age;


}
