package com.gagan.shopping2purchasemicroservice.controller;

import com.gagan.shopping2purchasemicroservice.model.Purchase;
import com.gagan.shopping2purchasemicroservice.model.ShoppingCart;
import com.gagan.shopping2purchasemicroservice.service.PurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gagandeep
 * @date 27-04-2020
 * @time 08:55
 */

@RestController
@Api("Purchase Controller make a purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/purchases/customer/{customerId}")
    @ApiOperation(value = "Fetch purchse hostory by customer id")
    public List<Purchase> fetchCustomerPurchases(
            @ApiParam(value = "Customer ID thorugh which purchase history will be fetched")
            @PathVariable Integer customerId){
        return purchaseService.fetchAllCustomerPurchase(customerId);
    }

    @PostMapping("/purchases/{shoppingCartId}")
    @ApiOperation(value = "Make purchase for a given shopping cart")
    public Purchase makePurchase(
            @ApiParam(value = "Shopping cart to be checked out")
            @PathVariable Integer shoppingCartId) throws Exception {
        return purchaseService.makePurchase(shoppingCartId);
    }
}
