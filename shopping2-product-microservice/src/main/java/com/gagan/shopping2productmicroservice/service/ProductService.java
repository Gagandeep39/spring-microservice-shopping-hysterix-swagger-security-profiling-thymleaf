package com.gagan.shopping2productmicroservice.service;

import com.gagan.shopping2productmicroservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 19:42
 */

@Service
public interface ProductService {

    public List<Product> fetchAllProducts();
    public Product fetchById(Integer id);
    public List<Product> fetchByCategory(String category);
    public Product addProduct(Product product);
    public Product updateStocks(Integer productId, Integer productQuantity) throws Exception;
}
