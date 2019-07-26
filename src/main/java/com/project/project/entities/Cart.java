package com.project.project.entities;

import com.project.project.dao.CartEntryRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Cart {
    private static final int NOT_FOUND = -1 ;
    @Id
    @GeneratedValue
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    // new cart equals new entry date
    public Cart() {
        created = new Date();
    }

    @OneToMany() // one cart to many cart entries
    private List<CartEntry> cartEntries = new ArrayList<>();

    public List<CartEntry> getCartEntries() {
        return cartEntries;
    }

    @ManyToOne(fetch = FetchType.EAGER) // many carts for each customer // why eager?? when the customer is authenticated, a cart is created
    private Customer customer;

    // why this method is public
    public void add(CartEntry newCartEntry, CartEntryRepository cartEntryRepository) {
        int index = findEntryByProduct(newCartEntry.getProduct());
        if (index != NOT_FOUND) {
            CartEntry oldEntry = getCartEntries().get(index);
            updateEntryQuantity(oldEntry, newCartEntry);
            cartEntryRepository.updateQuantity(newCartEntry.getQuantity(), oldEntry.getId());
        }
        else{
            getCartEntries().add(newCartEntry);
            cartEntryRepository.save(newCartEntry); // to save it into the db too
        }

    }


    // cart.count() count the quantities i.e total items of the cart
    public int count(){
        int sum = 0;
        // ??????????????
        for (CartEntry entry : getCartEntries()){
            sum += entry.getQuantity();
       }
        return sum;
    }

    public  void remove(Product product){
        int index = findEntryByProduct(product);
        if (index != NOT_FOUND) {
            getCartEntries().remove(index);
        }
    }

    private void updateEntryQuantity(CartEntry oldEntry, CartEntry newCartEntry) {
        int existedQuantity = oldEntry.getQuantity();
        newCartEntry.setQuantity(existedQuantity + newCartEntry.getQuantity());
    }

    private int findEntryByProduct(Product product) {
        /*for (CartEntry cartEntry: cartEntries)*/
        for (int i = 0; i <getCartEntries().size(); i++){
            Product current = getCartEntries().get(i).getProduct();
            if (current.getId() == product.getId()) {
                return i; // is i the cart entry id ???
            }
        }
        return NOT_FOUND;
    }

    public void clear() { cartEntries.clear();}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setCartEntries(List<CartEntry> cartEntries) {
        this.cartEntries = cartEntries;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
