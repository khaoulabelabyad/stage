package com.project.project.controllers;

import com.project.project.entities.Customer;
import com.project.project.web.dto.CustomerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class CustomerController extends AbstractController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(path = {"/login", "login"})
    public String showLogin(Model model, HttpSession session, HttpServletRequest request) {
        if (isCustomerAuthenticatedIn(session)) {
            return "index";
        }
        model.addAttribute("Referer", request.getHeader("Referer"));
        populateHeaderData(model, request);
        return "login";
    }

    @PostMapping(path = "/login")
    public String login(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse RESPONSE) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Customer customer = customerRepo.findByLogin(login);

        if (!userIsLoggedIn(password, customer)) {
            model.addAttribute("loginError", "login or password invalid!");
            return "login";
        }
        session.setAttribute("auth", customer.getId());
        if (shouldRedirectToOrderPage(request)) {
            return "redirect:" + "/app" + "/" + "/order/confirm";
        }
        return "redirect:home";
    }


    private boolean userIsLoggedIn(String password, Customer customer) {
        if (customer == null) {
            return false;
        }
        return passwordEncoder.matches(password, customer.getPassword());
    }

    private boolean shouldRedirectToOrderPage(HttpServletRequest request) {
        return request.getParameter("Referer".toLowerCase()).contains("/cart/read");
    }

    @GetMapping(path = "/register")
    public String register(Model model, HttpSession session, HttpServletRequest request) {
        if (isCustomerAuthenticatedIn(session)) {
            return "index";
        }
        populateHeaderData(model, request);
        model.addAttribute("customerForm", new CustomerForm());
        return "register-user";
    }

    @PostMapping(path = "/register")
    public String register(@Valid CustomerForm customerForm, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "register-user";
        }
        Customer customer = customerForm.toCustomerModel(passwordEncoder);
        customerRepo.save(customer);
        authenticate(session, customerForm);
        return "redirect:home";
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletResponse response, HttpSession session) {
        session.invalidate();
        response.addCookie(invalidateCartCookie());
        return "redirect:home";
    }

    private void authenticate(HttpSession session, CustomerForm customerForm) {
        int customerId = customerRepo.findByLogin(customerForm.getLogin()).getId();
        session.setAttribute("auth", customerId);
    }
}


