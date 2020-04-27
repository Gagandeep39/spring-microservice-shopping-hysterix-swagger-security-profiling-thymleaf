package com.gagan.shopping2cartmicroservice.controller;

import com.gagan.shopping2cartmicroservice.model.CartItem;
import com.gagan.shopping2cartmicroservice.model.ShoppingCart;
import com.gagan.shopping2cartmicroservice.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api("Shopping cart controller - Manages Cart Item crud operations")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @ApiOperation(
            value = "Add item to cart",
            notes = "Adds a cart Objec to  cart with the help of cart id")
    @PostMapping("/shoppingcartitem/{cartId}")
    public ShoppingCart addItemToCart(
            @ApiParam(value = "Cartitem object to be stored", required = true)
            @RequestBody CartItem cartItem,
            @ApiParam(value = "Cart Id using which the item will be stored", required = true)
            @PathVariable Integer cartId){
        ShoppingCart shoppingCart = shoppingCartService.addItemToCart(cartItem, cartId);
        return shoppingCart;
    }
    @ApiOperation(
            value = "Delete from cart",
            notes = "Deletes a cart item using cart ID")
    @DeleteMapping("/shoppingcartitem/{cartId}/{cartItemId}")
    public ShoppingCart deleteFromCart(
            @ApiParam(value = "Cart ID from which element will be deleted", required = true)
            @PathVariable Integer cartId,
            @ApiParam(value = "ID of cart item ov=bject to be deleted", required = true)
            @PathVariable Integer cartItemId){
        ShoppingCart shoppingCart = shoppingCartService.deleteItemFromCart(cartItemId, cartId);
        return shoppingCart;
    }

    @ApiOperation(
            value = "Delete whole cart",
            notes = "All the items including the cart will also be deleted")
    @DeleteMapping("/shoppingcart/{cartId}")
    public String deleteCart(
            @ApiParam(value = "ID of crt tio be deleted", required = true)
            @PathVariable Integer cartId){
        shoppingCartService.deleteCart(cartId);
        return "Success";
    }

    @ApiOperation(
            value = "Fetch cart by ID",
            notes = "Fetches a shopping cart using cart ID")
    @GetMapping("/shoppingcart/{cartId}")
    public ShoppingCart fetchShoppingCart(
            @ApiParam(value = "ID of the cart to be fetched", required = true)
            @PathVariable Integer cartId){
        return shoppingCartService.fetchCartById(cartId);
    }

    @PostMapping("/shoppingcart/{customerId}")
    public ShoppingCart getLatestCart(
            @ApiParam(value = "Fetch the latest shopping cart of the customer", required = true)
            @PathVariable Integer customerId){
        ShoppingCart shoppingCart = shoppingCartService.getLatestCartOrCreate(customerId);
        return shoppingCart;
    }

    @PutMapping(value="/shoppingcart/{cartId}/{status}")
    public String updateCartStatus(
            @ApiParam(value = "Id of the cart whose status is tp be updated", required = true)
            @PathVariable Integer cartId,
            @ApiParam(value = "Status with which the previous one will be replaced", required = true)
            @PathVariable String status) {
        shoppingCartService.updateStatus(cartId, status);
        return "Updated";
    }

}
