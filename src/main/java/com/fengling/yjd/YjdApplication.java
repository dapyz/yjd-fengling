package com.fengling.yjd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.fengling.yjd.mapper")
public class YjdApplication {

    public static void main(String[] args) {
        SpringApplication.run(YjdApplication.class, args);
    }

}
