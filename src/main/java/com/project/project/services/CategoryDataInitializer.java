package com.project.project.services;

import com.project.project.dao.CategoryRepository;
import com.project.project.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryDataInitializer implements Initializer{
    @Autowired
    private CategoryRepository categoryRepository;

    public void init(){
        {
            Category c = new Category();
            c.setCategory_id(1);
            c.setName("Equipement");
            c.setOrderId(1);
            categoryRepository.save(c);
        }

        {
            Category c = new Category();
            c.setCategory_id(2);
            c.setName("Footwear");
            c.setOrderId(2);
            categoryRepository.save(c);
        }

        {
            Category c = new Category();
            c.setCategory_id(3);
            c.setName("ActiveWear");
            c.setOrderId(3);
            categoryRepository.save(c);
        }

    }

}
