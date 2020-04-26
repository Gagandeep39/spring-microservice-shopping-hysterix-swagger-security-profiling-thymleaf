package com.gagan.shopping2cartmicroservice.service;

import com.gagan.shopping2cartmicroservice.model.CartItem;
import com.gagan.shopping2cartmicroservice.model.Customer;
import com.gagan.shopping2cartmicroservice.model.ShoppingCart;

import java.util.List;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 22:38
 */
public interface ShoppingCartService {

    public ShoppingCart addItemToCart(CartItem item, Integer cartId);
    public ShoppingCart deleteItemFromCart(Integer cartItemId, Integer cartId);
    public void deleteCart(Integer cartId);
    public List<ShoppingCart> fetchAllUserCart(Integer userId);
    public ShoppingCart getLatestCartOrCreate(Integer customerId);
    public ShoppingCart fetchCartById(Integer cartId);

}
