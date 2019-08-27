package com.project.project.services;


import com.project.project.dao.ProductRepository;
import com.project.project.dao.StockRepository;
import com.project.project.entities.StockEntry;
import com.project.project.services.Initializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockDataInitializer implements Initializer {

    @Autowired
    private ProductRepository articleRepo;
    @Autowired
    private StockRepository stockRepo;

    public void init(){
        articleRepo.findAll().forEach(product -> {
            StockEntry stockEntry = new StockEntry();
            stockEntry.setProduct(product);
            stockEntry.setQuantity(70);
            stockRepo.save(stockEntry);
        });
    }

}
