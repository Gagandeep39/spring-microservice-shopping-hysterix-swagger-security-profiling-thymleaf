package com.gagan.shopping2cartmicroservice.controller;

import com.gagan.shopping2cartmicroservice.model.CartItem;
import com.gagan.shopping2cartmicroservice.model.ShoppingCart;
import com.gagan.shopping2cartmicroservice.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 22:45
 */

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/shoppingcartitem/{cartId}")
    public ShoppingCart addItemToCart(@RequestBody CartItem cartItem, @PathVariable Integer cartId){
        ShoppingCart shoppingCart = shoppingCartService.addItemToCart(cartItem, cartId);
        return shoppingCart;
    }

    @DeleteMapping("/shoppingcartitem/{cartId}/{cartItemId}")
    public ShoppingCart deleteFromCart(@PathVariable Integer cartId, @PathVariable Integer cartItemId){
        ShoppingCart shoppingCart = shoppingCartService.deleteItemFromCart(cartItemId, cartId);
        return shoppingCart;
    }

    @DeleteMapping("/shoppingcart/{cartId}")
    public String deleteCart(@PathVariable Integer cartId){
        shoppingCartService.deleteCart(cartId);
        return "Success";
    }

    @GetMapping("/shoppingcart/{cartId}")
    public ShoppingCart fetchShoppingCart(@PathVariable Integer cartId){
        return shoppingCartService.fetchCartById(cartId);
    }

    @PostMapping("/shoppingcart/{customerId}")
    public ShoppingCart getLatestCart(@PathVariable Integer customerId){
        ShoppingCart shoppingCart = shoppingCartService.getLatestCartOrCreate(customerId);
        return shoppingCart;
    }

    @PutMapping(value="/shoppingcart/{cartId}/{status}")
    public String putMethodName(@PathVariable Integer cartId, @PathVariable String status) {
        shoppingCartService.updateStatus(cartId, status);
        return "Updated";
    }

}
