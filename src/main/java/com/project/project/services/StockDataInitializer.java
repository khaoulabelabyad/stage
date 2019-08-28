package com.project.project.services;


import com.project.project.dao.ProductRepository;
import com.project.project.dao.StockRepository;
import com.project.project.entities.StockEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockDataInitializer implements Initializer {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StockRepository stockRepo;

    public void init(){
        productRepository.findAll().forEach(product -> {
            StockEntry stockEntry = new StockEntry();
            stockEntry.setProduct(product);
            stockEntry.setQuantity(70);
            stockRepo.save(stockEntry);
        });
    }

}
