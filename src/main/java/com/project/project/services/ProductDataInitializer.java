package com.project.project.services;

import com.project.project.dao.ProductRepository;
import com.project.project.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductDataInitializer {
    @Autowired
    ProductRepository productRepository;

    public void init() {
        {
            Product p = new Product();
            p.setId(1);
            p.setDesignation("Basketballs");
            p.setPrice(15);
            p.setQuantity(20);
            p.setCategoryId(1);
            productRepository.save(p);
        }
        {
            Product p = new Product();
            p.setId(2);
            p.setDesignation("Surfboards");
            p.setPrice(300);
            p.setQuantity(13);
            p.setCategoryId(1);
            productRepository.save(p);
        }
        {
            Product p = new Product();
            p.setId(3);
            p.setDesignation("Sneakers");
            p.setPrice(150);
            p.setQuantity(30);
            p.setCategoryId(2);
            productRepository.save(p);
        }
        {
            Product p = new Product();
            p.setId(4);
            p.setDesignation("Cycling Clothing");
            p.setPrice(200);
            p.setQuantity(20);
            p.setCategoryId(3);
            productRepository.save(p);
        }
        {
            Product p = new Product();
            p.setId(5);
            p.setDesignation("Sports Uniforms");
            p.setPrice(300);
            p.setQuantity(15);
            p.setCategoryId(3);
            productRepository.save(p);
        }

    }
}
