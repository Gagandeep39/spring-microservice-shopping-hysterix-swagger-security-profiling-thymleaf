package com.gagan.shopping2productmicroservice.controller;

import com.gagan.shopping2productmicroservice.model.ProductDetails;
import com.gagan.shopping2productmicroservice.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 20:07
 */

@RestController
public class ProductDetailsController {

    @Autowired
    private ProductDetailsService productDetailsService;

    @GetMapping("/productdetails")
    public List<ProductDetails> fetchAllProductDetails(){
        return productDetailsService.fetchAllProductDetails();
    }

    @GetMapping("/productdetails/{id}")
    public ProductDetails fetchProductDetailsById(@PathVariable Integer id){
        return productDetailsService.fetchById(id);
    }
}
