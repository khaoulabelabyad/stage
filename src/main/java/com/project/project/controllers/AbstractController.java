package com.project.project.controllers;

import com.project.project.dao.CartRepository;
import com.project.project.dao.CustomerRepository;
import com.project.project.entities.Cart;
import com.project.project.entities.Customer;
import com.project.project.services.CatalogService;
import com.project.project.services.DefaultCatalogService;
import com.project.project.services.TotalAmountCalculator;
import com.project.project.web.dto.HeaderDTOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import com.project.project.services.CatalogService;

@Controller
public abstract class AbstractController {
    @Autowired
    public CatalogService catalogService;

    @Autowired
    protected TotalAmountCalculator amountCalculator;

    @Autowired
    protected CustomerRepository customerRepo;

    @Autowired
    protected CartRepository cartRepository;


    //Insert necessary data to the header tag
    public void populateHeaderData(Model model, Cart activeCart) {
        HeaderDTOBuilder.HeaderDTO headerDTO = new HeaderDTOBuilder().
                withAmountCalculator(amountCalculator)
                .withActiveCart(activeCart)
                .withCategories(catalogService.getCategories()).build();
        model.addAttribute("headerDTO", headerDTO);
    }


    public void populateHeaderData(Model model, HttpServletRequest request) {
        Cart activeCart = getCartFrom(request);
        if(activeCart == null){
            activeCart = new Cart();
        }
        populateHeaderData(model, activeCart);
    }

    protected Customer getAuthenticatedCustomer(HttpSession session) {
        Integer customerId = (Integer) session.getAttribute("auth");
        if (customerId == null) {
            return null;
        }
        Optional<Customer> customer = customerRepo.findById(customerId);
        return customer.orElse(null);
    }

    protected boolean isCustomerAuthenticatedIn(HttpSession session) {
        return session.getAttribute("auth") != null;
    }

    protected Cart getCartFrom(HttpServletRequest request){
        Cookie cookie = getCartCookieFrom(request);
        if(cookie == null){
            return null;
        }
        return getCartFrom(cookie);
    }

    /* I'm based on cookies instead of http session, because in good practice
        REST api shouldn't be aware of app context (REST is stateless)
     */
    protected Cookie createCartCookie(HttpServletRequest request) {
        Cookie cookie = getCartCookieFrom(request);
        if (expiredCart(cookie)) {
            int id = generateAnonymousCart();
            cookie = new Cookie("OTG_CART" , String.valueOf(id));
            cookie.setHttpOnly(true);
            cookie.setPath(getPath(request));
        }
        return cookie;
    }

    protected boolean expiredCartCookieFrom(HttpServletRequest request){
        Cookie cookie = getCartCookieFrom(request);
        return expiredCart(cookie);
    }

    private String getPath(HttpServletRequest request) {
        return request.getContextPath() + "/app";
    }

    protected Cookie invalidateCartCookie() {
        Cookie cookie = new Cookie("OTG_CART", null); // Not necessary, but saves bandwidth.
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        return cookie;
    }

    private boolean expiredCart(Cookie cookie){
        if(cookie == null || getCartFrom(cookie) == null){
            return true;
        }
        return false;
    }

    private Cookie getCartCookieFrom(HttpServletRequest request) {
        if(request.getCookies() == null){
            return null;
        }
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("OTG_CART")) {
                return cookie;
            }
        }
        return null;
    }

    // Regarding the above comment, we save the cart in the database instead of session
    private int generateAnonymousCart() {
        Cart cart = new Cart();
        cart = cartRepository.save(cart);
        return cart.getId();
    }

    private Cart getCartFrom(Cookie cookie) {
        int cartId = cartIdFrom(cookie);
        return cartRepository.findById(cartId).orElse(null);
    }

    private int cartIdFrom(Cookie cookie) {
        String cookieValue = cookie.getValue();
        return Integer.parseInt(cookieValue);
    }

}
