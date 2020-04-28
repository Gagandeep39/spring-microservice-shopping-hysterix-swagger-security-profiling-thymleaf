package com.gagan.shopping2loginmicroservice.service.implementation;

import com.gagan.shopping2loginmicroservice.model.Product;
import com.gagan.shopping2loginmicroservice.model.ProductDetails;
import com.gagan.shopping2loginmicroservice.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import javafx.print.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 20:29
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Value("${url.service.product}")
    private String productServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CircuitBreakerService circuitBreakerService;

    @Override
    public List<Product> fetchAllProducts() {
        List<Product> products = circuitBreakerService.fetchProductsFromService();
        return products;
    }

    @Override
    public Product fetchById(Integer id) {
        return null;
    }


    @Override
    public List<Product> searchByCategory(String category) {
        List<Product> products = circuitBreakerService.fetchProductsFromServiceByCategory(category);
        return products;
    }
}
