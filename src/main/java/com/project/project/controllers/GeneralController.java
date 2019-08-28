package com.project.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class GeneralController extends AbstractController {
    @GetMapping(path = {"/", "home"})
    public String home(Model model, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = createCartCookie(request);
        response.addCookie(cookie);
        populateHeaderData(model, request);
        model.addAttribute("categories", catalogService.getCategories());
        return "index";
    }
}
