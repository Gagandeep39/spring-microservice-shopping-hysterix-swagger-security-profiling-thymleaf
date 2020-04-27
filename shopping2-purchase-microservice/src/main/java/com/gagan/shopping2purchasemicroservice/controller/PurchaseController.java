package com.gagan.shopping2purchasemicroservice.controller;

import com.gagan.shopping2purchasemicroservice.model.Purchase;
import com.gagan.shopping2purchasemicroservice.model.ShoppingCart;
import com.gagan.shopping2purchasemicroservice.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gagandeep
 * @date 27-04-2020
 * @time 08:55
 */

@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/purchases/customer/{customerId}")
    public List<Purchase> fetchCustomerPurchases(@PathVariable Integer customerId){
        return purchaseService.fetchAllCustomerPurchase(customerId);
    }

    @PostMapping("/purchases/{shoppingCartId}")
    public Purchase makePurchase(@PathVariable Integer shoppingCartId) throws Exception {
        return purchaseService.makePurchase(shoppingCartId);
    }
}
