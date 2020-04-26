package com.gagan.shopping2productmicroservice.controller;

import com.gagan.shopping2productmicroservice.model.Product;
import com.gagan.shopping2productmicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 19:47
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> fetchAllProducts(){
        return productService.fetchAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product fetchById(@PathVariable Integer id){
        return productService.fetchById(id);
    }

    @PostMapping("products")
    public Product addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return product;
    }

    @GetMapping("products/category/{category}")
    public List<Product> fetchProductByCategory(@PathVariable String category){
        return productService.fetchByCategory(category);
    }
}
