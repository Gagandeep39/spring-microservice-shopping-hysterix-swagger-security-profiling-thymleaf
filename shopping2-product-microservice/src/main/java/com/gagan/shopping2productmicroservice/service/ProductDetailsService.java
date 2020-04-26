package com.gagan.shopping2productmicroservice.service;

import com.gagan.shopping2productmicroservice.model.ProductDetails;

import java.util.List;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 20:05
 */
public interface ProductDetailsService {

    public List<ProductDetails> fetchAllProductDetails();
    public ProductDetails fetchById(Integer id);
}
