package com.project.project.controllers;

public final class Paths {

    public interface CartPaths {
        String CART_READ_ENDPOINT = "/cart/read";
        String CART_CLEAR_ENDPOINT = "/cart/clear";
        String CART_ADD_ENDPOINT = "/cart/add";
        String CART_REMOVE_ENDPOINT = "/cart/remove/{productId}";
    }

    public interface CustomerPaths {
        String LOGIN_ENDPOINT = "/login";
        String LOGOUT_ENDPOINT = "/logout";
        String REGISTRATION_ENDPOINT = "/register";
    }

    public interface CategoryPaths {
        String CATEGORY_GET_CONTENT_ENDPOINT = "/category/{category_id}";
    }

    public interface OrderPaths {
        String ORDER_CONFIRM_ENDPOINT = "/order/confirm";
    }

    public interface AppPaths {
        String ORDER_CONFIRM_ENDPOINT = "/app";
        String APP_INIT = "/init";
    }
}
