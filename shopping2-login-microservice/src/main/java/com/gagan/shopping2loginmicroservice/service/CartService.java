package com.gagan.shopping2loginmicroservice.service;

import com.gagan.shopping2loginmicroservice.model.ProductDetails;
import com.gagan.shopping2loginmicroservice.model.ShoppingCart;

/**
 * @author Gagandeep
 * @date 27-04-2020
 * @time 02:13
 */
public interface CartService {

    public ShoppingCart saveItemToCart(Integer cartId, Integer productId);
    public ShoppingCart removeItemFromCart(Integer cartId, Integer cartItemId);
    public ShoppingCart createOrFetchCart(Integer customerId);
}
