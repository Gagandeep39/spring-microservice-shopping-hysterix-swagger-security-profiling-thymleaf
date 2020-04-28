package com.gagan.shopping2loginmicroservice.service.implementation;

import com.gagan.shopping2loginmicroservice.model.CartItem;
import com.gagan.shopping2loginmicroservice.model.ProductDetails;
import com.gagan.shopping2loginmicroservice.model.Purchase;
import com.gagan.shopping2loginmicroservice.model.ShoppingCart;
import com.gagan.shopping2loginmicroservice.service.PurchaseService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Gagandeep
 * @date 27-04-2020
 * @time 10:53
 */

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${url.service.purchase}")
    private String purchaseUrl;

    @Autowired
    private CircuitBreakerService circuitBreakerService;

    @Override
    public Purchase createPurchase(ShoppingCart shoppingCart) {
        Purchase purchase = circuitBreakerService.makeNewPurchase(shoppingCart);
        return purchase;
    }

    @Override
    public List<Purchase> fetchAllCustomerPurchase(Integer customerId) {
        List<Purchase> purchases = circuitBreakerService.fetchCustomerFromPurchaseService(customerId);
        return purchases;
    }

}
