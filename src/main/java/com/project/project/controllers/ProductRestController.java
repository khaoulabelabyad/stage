package com.project.project.controllers;

import com.project.project.entities.Product;
import com.project.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProductRestController {

    @Autowired
    ProductService productService;

   /* @Autowired // establish injection
    public ProductRepository productRepository;*/

    // GET-ALL
    @GetMapping(value = "/all")
    public @ResponseBody List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    /*@GetMapping(value = "/products/{id}")
    @ResponseBody
    public List<Product> getProducts(@RequestParam String designation) {
        return productRepository.findByDesignation(designation);
    }*/

    // GET
    @GetMapping(value = "/products/{id}")
    public Product getProduct(@PathVariable(name = "id") Long id) {
        return productService.getProduct(id);
    }

    // PUT
    @PutMapping(value = "/products/{id}")
    public void updateProduct(@PathVariable(name = "id") Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    // POST
    @PostMapping(value = "/products")
    public void save(@RequestBody Product product) {
        productService.addProduct(product);
    }

    // DELETE
    @DeleteMapping(value = "/products/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        productService.deleteProduct(id);
    }
}
