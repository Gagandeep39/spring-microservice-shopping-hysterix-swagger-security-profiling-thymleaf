package com.gagan.shopping2loginmicroservice.controller;

import com.gagan.shopping2loginmicroservice.model.CartItem;
import com.gagan.shopping2loginmicroservice.model.Customer;
import com.gagan.shopping2loginmicroservice.model.ShoppingCart;
import com.gagan.shopping2loginmicroservice.service.CartService;
import com.gagan.shopping2loginmicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Gagandeep
 * @date 27-04-2020
 * @time 03:23
 */

@Controller
@RequestMapping("/ShoppingCartCtrl")
public class ShoppingCartController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    private Customer customer;
    private ShoppingCart shoppingCart;

    @GetMapping("/cart")
    public ModelAndView showCart(){
        if (customer == null){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            customer = userService.findByUsername(authentication.getName());
        }
        shoppingCart = cartService.createOrFetchCart(customer.getId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cart", shoppingCart);
        modelAndView.addObject("total", calculateCartTotal());
        modelAndView.setViewName("/CartItem");
        return modelAndView;
    }

    @PostMapping("/remove/{cartItemId}")
    public ModelAndView removeItemFromCart(@PathVariable Integer cartItemId){
        ModelAndView modelAndView = new ModelAndView();
        cartService.removeItemFromCart(shoppingCart.getCartId(), cartItemId);
        shoppingCart = cartService.createOrFetchCart(customer.getId());
        modelAndView.addObject("total", calculateCartTotal());
        modelAndView.addObject("cart", shoppingCart);
        modelAndView.setViewName("/CartItem");
        return modelAndView;
    }

    private Integer calculateCartTotal() {
        List<CartItem> items = shoppingCart.getCartItems();
        int temp = 0;
        for (CartItem item : items) {
            temp += item.getQuantity() * item.getProductDetails().getPrice();
        }
        return temp;
    }

}
