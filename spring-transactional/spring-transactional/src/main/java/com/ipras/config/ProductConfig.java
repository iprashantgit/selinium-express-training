package com.ipras.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.ipras")
public class ProductConfig {

    @Bean
    public DataSource dataSource() {
        System.out.println("init datasource");
        return new DriverManagerDataSource("jdbc:mysql://localhost:3306/database1", "root", "admin");
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

}
