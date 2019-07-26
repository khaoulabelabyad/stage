package com.project.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Customer {
    // 2 cases , new customer/customer connected before

    @Id
    @GeneratedValue
    private int id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToOne // one customer for each cart
    private Cart activeCart;

    public Cart getActiveCart() {
        if(activeCart == null){
            activeCart = new Cart();
        }
        return activeCart;
    }

    public void setActiveCart(Cart activeCart) {
        this.activeCart = activeCart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
