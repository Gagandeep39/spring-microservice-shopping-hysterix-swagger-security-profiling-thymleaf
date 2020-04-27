package com.gagan.shopping2loginmicroservice.service;

import com.gagan.shopping2loginmicroservice.model.Product;

import java.util.List;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 20:27
 */
public interface ProductService {

    public List<Product> fetchAllProducts();
    public Product fetchById(Integer id);
    List<Product> searchByCategory(String category);

}
