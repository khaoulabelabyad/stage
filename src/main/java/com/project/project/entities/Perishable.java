package com.project.project.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance
@DiscriminatorValue("Perishable") // indicates the values that distinguishes products
public class Perishable extends Product {

    public Perishable(Long id, String designation, Integer price, Integer quantity, Long category_id) {
        super(id, designation, price, quantity, category_id);
    }
    @Temporal(TemporalType.DATE)
    private Date bestBefore;
    private String lot;

    public Date getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(Date bestBefore) {
        this.bestBefore = bestBefore;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }
}
