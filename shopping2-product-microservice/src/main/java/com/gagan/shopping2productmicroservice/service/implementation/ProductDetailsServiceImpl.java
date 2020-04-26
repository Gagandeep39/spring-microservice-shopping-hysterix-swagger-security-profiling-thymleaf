package com.gagan.shopping2productmicroservice.service.implementation;

import com.gagan.shopping2productmicroservice.model.ProductDetails;
import com.gagan.shopping2productmicroservice.repository.ProductDetailsRepository;
import com.gagan.shopping2productmicroservice.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 20:06
 */

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @Override
    public List<ProductDetails> fetchAllProductDetails() {
        return productDetailsRepository.findAll();
    }

    @Override
    public ProductDetails fetchById(Integer id) {
        return productDetailsRepository.findById(id).get();
    }
}
