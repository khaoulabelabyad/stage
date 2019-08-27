package com.project.project.dao;

import com.project.project.entities.Product;
import com.project.project.entities.StockEntry;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<StockEntry,Integer> {
    StockEntry findByProduct(Product product);


}
