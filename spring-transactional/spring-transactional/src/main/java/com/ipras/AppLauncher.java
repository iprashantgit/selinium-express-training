package com.ipras;

import com.ipras.config.ProductConfig;
import com.ipras.service.ProductService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppLauncher {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);

        ProductService productService = context.getBean("productService", ProductService.class);
        productService.saveProduct();

        context.registerShutdownHook();
        context.close();

    }

}
