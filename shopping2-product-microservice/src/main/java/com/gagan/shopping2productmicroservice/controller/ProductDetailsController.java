package com.gagan.shopping2productmicroservice.controller;

import com.gagan.shopping2productmicroservice.model.ProductDetails;
import com.gagan.shopping2productmicroservice.service.ProductDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api("Product Details Controller for managing crud ipeation")
public class ProductDetailsController {

    @Autowired
    private ProductDetailsService productDetailsService;

    @GetMapping("/productdetails")
    @ApiOperation(value = "Fettch All Product details")
    public List<ProductDetails> fetchAllProductDetails(){
        return productDetailsService.fetchAllProductDetails();
    }

    @GetMapping("/productdetails/{id}")@ApiOperation(
            value = "Fetch Details by ID",
            notes = "Fetch details of a product based on ID")
    public ProductDetails fetchProductDetailsById(
            @ApiParam(value = "ID through which details will be fetched from repository", required = true)
            @PathVariable Integer id){
        return productDetailsService.fetchById(id);
    }
}
