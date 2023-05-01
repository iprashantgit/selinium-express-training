package com.ipras.service;

import com.ipras.repo.Product;
import com.ipras.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveProduct() {
        Product product = new Product();
        product.setId(102);
        product.setName("iPhone 15 Pro");
        productRepo.saveProduct(product);

        /**
         * Note:
         * 1) do not catch the exception here, it needs to propagate back
         * 2) @Transactional by default do not work for checked exception i.e. Exception.class,
         *    so we declare it with @Transactional(rollbackFor = Exception.class)
         * 3) we can disable the default rollback using @Transactional(noRollbackFor = RuntimeException.class)
         * 4) default propogation: @Transactional(propogation = Propogation.REQUIRED), REQUIRED always starts
         *    a new transaction incase a transaction doesn't exist. Otherwise it uses the same one.
         */
        if (true) {
            // throw new RuntimeException("Exception occurred while saving.");
        }

        productRepo.saveProduct(product);
        System.out.println("Product is saved.");
    }

}
