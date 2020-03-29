package com.jiajinshuo.sbt_senior;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.jiajinshuo.sbt_senior.mapper")
@SpringBootApplication
@EnableCaching//开启注解的缓存
public class SbtSeniorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbtSeniorApplication.class, args);
    }

}
