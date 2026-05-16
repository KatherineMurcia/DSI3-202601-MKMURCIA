package com.dsi3.api_usuarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {
    @Bean
    JdbcTemplate configureDataBase(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
