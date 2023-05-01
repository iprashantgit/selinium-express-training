package com.ipras.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveProduct(Product product) {
        String sql = "INSERT INTO PRODUCT VALUE (?, ?)";
        jdbcTemplate.update(sql, product.getId(), product.getName());
    }

}