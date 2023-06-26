package com.ssafy.board.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

// dao와 mapper를 연결시켜주자
@Configuration
@MapperScan(basePackages = "com.ssafy.board.model.dao")
public class DBConfig {

}
