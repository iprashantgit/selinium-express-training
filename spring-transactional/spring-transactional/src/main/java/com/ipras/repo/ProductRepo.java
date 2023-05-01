package com.ipras.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveProduct(Product product) {
        String sql = "INSERT INTO PRODUCT VALUE (?, ?)";
        jdbcTemplate.update(sql, product.getId(), product.getName());
    }

}
