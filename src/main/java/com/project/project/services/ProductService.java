package com.project.project.services;

import com.project.project.dao.ProductRepository;
import com.project.project.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired // establish injection
    private ProductRepository productRepository;

    // GET-ALL
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    // GET
    public Optional<Product> getProduct(int id) {
        return productRepository.findById(id);
    }

    // POST
    public void addProduct(Product product){
        productRepository.save(product);
    }

    // PUT
    public void updateProduct(int id, Product product) {
        product.setId(id);
        productRepository.save(product);
    }
    // DELETE
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
}
