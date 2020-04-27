package com.gagan.shopping2purchasemicroservice.service;

import com.gagan.shopping2purchasemicroservice.model.Purchase;
import com.gagan.shopping2purchasemicroservice.model.ShoppingCart;

import java.util.List;

/**
 * @author Gagandeep
 * @date 27-04-2020
 * @time 08:31
 */
public interface PurchaseService {
    Purchase makePurchase(Integer shoppingCartId) throws Exception;
    List<Purchase> fetchAllCustomerPurchase(Integer customerId);
}
