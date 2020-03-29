package com.jiajinshuo.sbt_lettuce.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jiajinshuo
 * @create 2020-03-25 16:50
 */
@Data
public class User implements Serializable {

    private Integer id;
    private String name;
    private Integer age;

}
