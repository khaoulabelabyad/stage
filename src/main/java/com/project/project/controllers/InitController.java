package com.project.project.controllers;

import com.project.project.services.CategoryDataInitializer;
import com.project.project.services.CustomerInitializer;
import com.project.project.services.ProductDataInitializer;
import com.project.project.services.StockDataInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InitController {
    @Autowired
    private ProductDataInitializer productDataInitializer;
    @Autowired
    private CategoryDataInitializer categoriesInitializer;
    @Autowired
    private StockDataInitializer stockInitializer;
    @Autowired
    private CustomerInitializer customerInitializer;

    @GetMapping(path = "/init")
    @ResponseBody
    public String init(){
        categoriesInitializer.init();
        productDataInitializer.init();
        stockInitializer.init();
        customerInitializer.init();
        return "Initialization succeeded!";
    }
}
