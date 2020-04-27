package com.gagan.shopping2loginmicroservice.controller;

import com.gagan.shopping2loginmicroservice.model.Customer;
import com.gagan.shopping2loginmicroservice.model.Purchase;
import com.gagan.shopping2loginmicroservice.model.ShoppingCart;
import com.gagan.shopping2loginmicroservice.service.CartService;
import com.gagan.shopping2loginmicroservice.service.PurchaseService;
import com.gagan.shopping2loginmicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Gagandeep
 * @date 27-04-2020
 * @time 10:45
 */

@Controller
@RequestMapping("/PurchaseCtrl")
public class PurchaseController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private PurchaseService purchaseService;

    private Customer customer;
    private ShoppingCart shoppingCart;

    @GetMapping("/checkout")
    public ModelAndView checkOut(){
        if (customer==null)
            initData();
        ModelAndView modelAndView = new ModelAndView();
        shoppingCart = cartService.createOrFetchCart(customer.getId());
        Purchase purchase = purchaseService.createPurchase(shoppingCart);
        modelAndView.addObject("purchase", purchase);
        modelAndView.setViewName("/BillingPage");
        return modelAndView;
    }

    private void initData() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        customer = userService.findByUsername(username);
    }

    @GetMapping("/purchase")
    public ModelAndView showAllPurchases(){
        if (customer==null)
            initData();
        ModelAndView modelAndView = new ModelAndView();
        List<Purchase> purchases = purchaseService.fetchAllCustomerPurchase(customer.getId());
        modelAndView.setViewName("/PurchaseHistory");
        modelAndView.addObject("purchases", purchases);
        return modelAndView;
    }

}
