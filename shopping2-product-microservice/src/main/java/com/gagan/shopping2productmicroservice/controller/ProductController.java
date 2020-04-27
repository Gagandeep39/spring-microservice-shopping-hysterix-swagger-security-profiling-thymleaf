package com.gagan.shopping2productmicroservice.controller;

import com.gagan.shopping2productmicroservice.model.Product;
import com.gagan.shopping2productmicroservice.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 19:47
 */
@RestController
@Api("Product Cntroller to manage product crud operation")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    @ApiOperation(value = "Fetch all products")
    public List<Product> fetchAllProducts(){
        return productService.fetchAllProducts();
    }

    @GetMapping("/products/{id}")
    @ApiOperation(value = "Fetch products by ID")
    public Product fetchById(
            @ApiParam(value = "ID through which product will be fetched")
            @PathVariable Integer id){
        return productService.fetchById(id);
    }

    @PostMapping("/products")
    @ApiOperation(value = "Add product")
    public Product addProduct(
            @ApiParam(value = "Produt to be added")
            @RequestBody Product product){
        productService.addProduct(product);
        return product;
    }

    @GetMapping("/products/category/{category}")
    @ApiOperation(value = "Fetch products by category")
    public List<Product> fetchProductByCategory(
            @ApiParam(value = "Cartegory by which products will be fetched")
            @PathVariable String category){
        return productService.fetchByCategory(category);
    }

    @PutMapping(value="/products/stock/{productId}/{quantity}")
    @ApiOperation(value = "Update product quuantity")
    public Product updateStocks(
            @ApiParam(value = "Produc ID whose stcks are to be updated")
            @PathVariable Integer productId,
            @ApiParam(value = "Amount by which the stovks will be replaced")
            @PathVariable Integer quantity) throws Exception {
        Product product = productService.updateStocks(productId, quantity);
        return product;
    }
    
}
