package com.project.project.services;

import com.project.project.dao.CategoryRepository;
import com.project.project.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    // GET-ALL
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        // adding each category to the categories list
        categoryRepository.findAll().forEach((categories::add));
        return categories;
    }

    // GET
    public Category getCategory(int id) {
        return categoryRepository.getOne(id);
    }

    // POST
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    // PUT
    public void updateCategory(int id , Category category) {
        category.setId(id);
        categoryRepository.save(category);
    }

    // DELETE
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}
