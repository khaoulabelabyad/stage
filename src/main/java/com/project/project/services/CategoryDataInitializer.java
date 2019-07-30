package com.project.project.services;

import com.project.project.dao.CategoryRepository;
import com.project.project.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryDataInitializer {
    @Autowired
    private CategoryRepository categoryRepository;

    public void init(){
        {
            Category c = new Category();
            c.setId(1);
            c.setName("Drinks");
            c.setOrderId(2);
            categoryRepository.save(c);
        }

        {
            Category c = new Category();
            c.setId(2);
            c.setName("Meat");
            c.setOrderId(3);
            categoryRepository.save(c);
        }

        {
            Category c = new Category();
            c.setId(3);
            c.setName("Sausage & stuffing");
            c.setOrderId(4);
            categoryRepository.save(c);
        }

        {
            Category c = new Category();
            c.setId(4);
            c.setName("Fruits & Vegetables");
            c.setOrderId(1);
            categoryRepository.save(c);
        }

        {
            Category c = new Category();
            c.setId(5);
            c.setName("Dairy Products");
            c.setOrderId(5);
            categoryRepository.save(c);
        }

        {
            Category c = new Category();
            c.setId(6);
            c.setName("Various");
            c.setOrderId(6);
            categoryRepository.save(c);
        }

    }

}
