package com.ipras.service;

import com.ipras.repo.Product;
import com.ipras.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public void saveProduct(){
        Product product = new Product();
        product.setId(102);
        product.setName("iPhone 15 Pro");
        productRepo.saveProduct(product);
        System.out.println("Product is saved.");
    }

}
