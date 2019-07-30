package com.project.project.services;

import com.project.project.entities.Cart;
import com.project.project.entities.CartEntry;
import com.project.project.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TotalAmountCalculator {

    // totalPrices method using cart
    public double totalPrices(Cart activeCart) {
        return totalPrices(activeCart.getCartEntries());
    }

    // totalPrices method using cartEntries
    public double totalPrices(List<CartEntry> cartEntries) {
        double totalAmount = 0 ;
        for(CartEntry cartEntry : cartEntries){
            totalAmount += entryPrice(cartEntry);
        }
        return totalAmount;
    }



    private double entryPrice(CartEntry cartEntry) {
        return productPrice(cartEntry.getProduct()) * cartEntry.getQuantity();
    }

    private double productPrice(Product product) {
        return product.getPrice();
    }
}
