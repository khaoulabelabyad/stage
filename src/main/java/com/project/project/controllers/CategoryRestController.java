package com.project.project.controllers;

import com.project.project.entities.Category;

import com.project.project.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.project.controllers.Paths.CategoryPaths.CATEGORY_GET_CONTENT_ENDPOINT;

public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    // GET-ALL
    @GetMapping(value = "/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // GET
    @GetMapping(value = "/category/{category_id}")
    public Category getCategory(@PathVariable int id) {
        return categoryService.getCategory(id);
    }

    // PUT
    @PutMapping(value = "/category/{category_id}")
    public void updateProduct(@PathVariable(name = "id") int id, @RequestBody Category category) {
        categoryService.updateCategory(id, category);
    }

    // POST
    @PostMapping(value = "/categories")
    public void save(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    // DELETE
    @DeleteMapping(value = "/category/{category_id}")
    public void delete(@PathVariable(name = "id") int id) {
        categoryService.deleteCategory(id);
    }
}
