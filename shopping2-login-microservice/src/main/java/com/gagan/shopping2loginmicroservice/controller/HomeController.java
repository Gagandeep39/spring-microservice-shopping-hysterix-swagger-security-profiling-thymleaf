package com.gagan.shopping2loginmicroservice.controller;

import com.gagan.shopping2loginmicroservice.model.Customer;
import com.gagan.shopping2loginmicroservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 11:20
 */

@Controller
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserDetails userDetails;
    @Autowired
    private UserService userService;

    public Customer customer;

    @GetMapping("/")
    public String indexPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user", authentication.getName());
        return "AuthenticatingPage";
    }

    @GetMapping("/home")
    public ModelAndView showHomeScreen(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        customer = userService.findByUsername(name);
        ModelAndView modelAndView = new ModelAndView();
        if (customer==null)
            customer = new Customer();
        modelAndView.addObject("customer", customer);
        modelAndView.setViewName("Home");
        return modelAndView;
    }

}
