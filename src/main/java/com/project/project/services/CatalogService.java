package com.project.project.services;

import com.project.project.entities.Category;
import com.project.project.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CatalogService {

    /**
     * List categories, ordered by order_idx
     *
     * @return list of all categories
     */
    List<Category> getCategories();

    /**
     * List all products in a category
     *
     * @return products, can be empty
     * @throws DataException if category does not exist
     */


    List<Product> getCategoryContent(int categoryId);

}
