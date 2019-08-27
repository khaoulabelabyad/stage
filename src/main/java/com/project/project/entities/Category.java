package com.project.project.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    private String name;
    private String description;
    private int orderId; // ??? why

    // referencing side


    //one category to many products
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category" )
    // maps to the variable of the referencing side in the owning side
    private List<Product> products = new ArrayList<>();

    public Category() {
    }

    public Category(int category_id, String name, String description) {
        this.category_id = category_id;
        this.name = name;
        this.description = description;
    }
    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
