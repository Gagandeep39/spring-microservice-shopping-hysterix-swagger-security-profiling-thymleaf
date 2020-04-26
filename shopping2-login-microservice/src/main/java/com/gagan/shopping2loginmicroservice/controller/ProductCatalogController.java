package com.gagan.shopping2loginmicroservice.controller;

import com.gagan.shopping2loginmicroservice.model.Product;
import com.gagan.shopping2loginmicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 20:24
 */

@Controller
@RequestMapping("/ProductCatalogCtrl")
public class ProductCatalogController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productcatalog")
    public ModelAndView showProductCatalog(){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.fetchAllProducts();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("/ProductCatalog");
        return modelAndView;
    }
}
