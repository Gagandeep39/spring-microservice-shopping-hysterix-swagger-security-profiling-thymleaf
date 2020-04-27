package com.gagan.shopping2loginmicroservice.controller;

import com.gagan.shopping2loginmicroservice.model.Category;
import com.gagan.shopping2loginmicroservice.model.Customer;
import com.gagan.shopping2loginmicroservice.model.Product;
import com.gagan.shopping2loginmicroservice.model.ShoppingCart;
import com.gagan.shopping2loginmicroservice.service.CartService;
import com.gagan.shopping2loginmicroservice.service.ProductService;
import com.gagan.shopping2loginmicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 20:24
 */

@Controller
@RequestMapping("/ProductCatalogCtrl")
public class ProductCatalogController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    private Customer customer;

    private List<Product> products;

    private ShoppingCart shoppingCart;
    private List<String> categories;


    @PostConstruct
    public void init(){
        products = productService.fetchAllProducts();
        categories = new ArrayList<>();
        categories.add("Laptop");
        categories.add("Mobile");
        categories.add("Groceries");
        categories.add("All");
    }

    @GetMapping("/productcatalog")
    public ModelAndView showProductCatalog(){
        if (customer == null){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            customer = userService.findByUsername(authentication.getName());
            shoppingCart = cartService.createOrFetchCart(customer.getId());
        }
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.fetchAllProducts();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("/ProductCatalog");
        modelAndView.addObject("productcategory", new Category());
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @PostMapping("/productcatalog/{productId}")
    public ModelAndView addItemToCart(@PathVariable Integer productId){
        ModelAndView modelAndView = new ModelAndView();
        cartService.saveItemToCart(shoppingCart.getCartId(), productId);
        modelAndView.addObject("products", products);
        modelAndView.addObject("productcategory", new Category());
        modelAndView.addObject("categories", categories);
        modelAndView.setViewName("/ProductCatalog");
        return modelAndView;
    }
    
    @PostMapping("/select")
    public ModelAndView searchByCategory(@ModelAttribute Category category){
        ModelAndView modelAndView = new ModelAndView();
        if (!category.getContent().equals("All"))
            products = productService.searchByCategory(category.getContent());
        else
            products = productService.fetchAllProducts();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("/ProductCatalog");
        modelAndView.addObject("productcategory", new Category());
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }
}
