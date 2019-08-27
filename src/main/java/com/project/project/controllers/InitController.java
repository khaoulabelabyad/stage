package com.project.project.controllers;

import com.project.project.services.CategoryDataInitializer;
import com.project.project.services.CustomerInitializer;
import com.project.project.services.ProductDataInitializer;
import com.project.project.services.StockDataInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.project.project.controllers.Paths.AppPaths.APP_INIT;

public class InitController {
    @Autowired
    private ProductDataInitializer articlesInitializer;
    @Autowired
    private CategoryDataInitializer categoriesInitializer;



    @Autowired
    private StockDataInitializer stockInitializer;
    @Autowired
    private CustomerInitializer customerInitializer;

    @GetMapping(path = APP_INIT)
    @ResponseBody
    public String init(){
        categoriesInitializer.init();
        articlesInitializer.init();
        stockInitializer.init();
        customerInitializer.init();
        return "Initialization succeeded!";
    }
}
