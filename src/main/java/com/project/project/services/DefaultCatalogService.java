package com.project.project.services;

import com.project.project.dao.CategoryRepository;
import com.project.project.dao.ProductRepository;
import com.project.project.dao.StockRepository;
import com.project.project.entities.Category;
import com.project.project.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultCatalogService implements CatalogService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAllByOrderByOrderIdAsc();
    }

    @Override
    public List<Product> getCategoryContent(int categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isPresent()) {
            return category.get().getProducts();
        }
        return Collections.emptyList();
    }

}
