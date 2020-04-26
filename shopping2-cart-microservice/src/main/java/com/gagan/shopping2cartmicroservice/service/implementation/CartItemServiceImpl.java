package com.gagan.shopping2cartmicroservice.service.implementation;

import com.gagan.shopping2cartmicroservice.model.CartItem;
import com.gagan.shopping2cartmicroservice.repository.CartItemRepository;
import com.gagan.shopping2cartmicroservice.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 23:43
 */

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItem(Integer cartItemId) {
        CartItem cartItem = cartItemRepository.getOne(cartItemId);
        cartItemRepository.delete(cartItem);
    }

}
