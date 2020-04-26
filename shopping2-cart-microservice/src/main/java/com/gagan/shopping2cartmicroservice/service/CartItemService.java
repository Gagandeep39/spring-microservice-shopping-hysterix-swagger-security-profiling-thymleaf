package com.gagan.shopping2cartmicroservice.service;

import com.gagan.shopping2cartmicroservice.model.CartItem;

import java.util.List;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 22:43
 */
public interface CartItemService {
    public CartItem saveCartItem(CartItem cartItem);
    public void deleteCartItem(Integer cartItemId);
}
