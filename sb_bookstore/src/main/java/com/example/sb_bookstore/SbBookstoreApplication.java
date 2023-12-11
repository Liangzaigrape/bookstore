package com.example.sb_bookstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.example.sb_bookstore.mapper")
@SpringBootApplication
public class SbBookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbBookstoreApplication.class, args);
    }

}
