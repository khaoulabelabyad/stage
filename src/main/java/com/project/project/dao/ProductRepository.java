package com.project.project.dao;

import com.project.project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findById(int id);

    void deleteById(int id);
    // public List<Product> findByDesignation(String designation);
}
