package com.project.project.controllers;

import com.project.project.dao.ProductRepository;
import com.project.project.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProductRestController {
    @Autowired // establish injection
    public ProductRepository productRepository;

    @GetMapping(value="/products")
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @GetMapping(value="/products")
    @ResponseBody
    public  List<Product> getProducts(@RequestParam String designation){
        return productRepository .findByDesignation(designation);
    }

    @GetMapping(value="/products/{id}")
    public Product listProducts(@PathVariable(name="id") Long id) {
        return productRepository.findById(id).get();
    }

    @PutMapping(value="/products/{id}")
    public Product update(@PathVariable(name="id") Long id,@RequestBody Product p) {
        p.setId(id);
        return productRepository.save(p);
    }

    @PostMapping (value="/products")
    public Product save(@RequestBody Product p) {
        //return productRepository.save(p);
        return productRepository.save(p);
    }

    @DeleteMapping (value="/products/{id}")
    public void delete(@PathVariable (name="id") Long id ) {
        productRepository.deleteById(id);
    }
}
