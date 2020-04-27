package com.gagan.shopping2loginmicroservice.service;

import com.gagan.shopping2loginmicroservice.model.Purchase;
import com.gagan.shopping2loginmicroservice.model.ShoppingCart;

import java.util.List;

/**
 * @author Gagandeep
 * @date 27-04-2020
 * @time 10:41
 */
public interface PurchaseService {
    public Purchase createPurchase(ShoppingCart shoppingCart);
    public List<Purchase> fetchAllCustomerPurchase(Integer customerId);
}
