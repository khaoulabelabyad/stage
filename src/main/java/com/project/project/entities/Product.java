package com.project.project.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "products")
// why serializable ?? every entity in JPA is automatically-serializable,  connection between different networks
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // assign a unique value to your identity field automatically
    private int id;
    private String designation;
    private int price;
    private int quantity;
    private int category_id;

    // the owning side of the relationship, side of the foreign key

    @ManyToOne(fetch = FetchType.LAZY )// many products to one category
    @JoinColumn(name = "category_id" , insertable = false , updatable = false)
    // means that the product table will have a fk_column named...
    private Category category;


    // categoryId foreign key referencing to the primary key on Category
    // Double and Integer in case both variables are unknown -> Category constructor
    public Product(int id, String designation, Integer price, Integer quantity, int category_id) {
        this.id = id;
        this.designation = designation;
        this.price = price;
        this.quantity = quantity;
        this.category_id = category_id;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantite) {
        this.quantity = quantite;
    }

    public int getCategoryId() {
        return category_id;
    }

    public void setCategoryId(int category_id) {
        this.category_id = category_id;
    }


}

