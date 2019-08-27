package com.project.project.web.dto;

import com.project.project.entities.Cart;
import com.project.project.entities.Category;
import com.project.project.services.TotalAmountCalculator;

import java.util.List;

public class HeaderDTOBuilder {
    private List<Category> categories;
    private TotalAmountCalculator amountCalculator;
    private Cart activeCart;

    public HeaderDTOBuilder withCategories(List<Category> categories){
        this.categories = categories;
        return this;
    }

    public HeaderDTOBuilder withAmountCalculator(TotalAmountCalculator amountCalculator){
        this.amountCalculator = amountCalculator;
        return this;
    }

    public HeaderDTOBuilder withActiveCart(Cart activeCart) {
        this.activeCart = activeCart;
        return this;
    }

    public HeaderDTO build(){
        return new HeaderDTO(activeCart, categories, amountCalculator);
    }

    public class HeaderDTO {
        private final List<Category> categories;
        private final int count;
        private double totalPrice;

        HeaderDTO(Cart activeCart, List<Category> categories, TotalAmountCalculator amountCalculator) {
            this.totalPrice = amountCalculator.totalPrices(activeCart);
            this.categories = categories;
            this.count = activeCart.count();
        }

        public List<Category> getCategories() {
            return categories;
        }

        public int getCount() {
            return count;
        }

        public double getTotalPrice() {
            return totalPrice;
        }
    }
}
