package com.gagan.shopping2loginmicroservice.controller;

import com.gagan.shopping2loginmicroservice.model.Customer;
import com.gagan.shopping2loginmicroservice.model.User;
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
import java.util.Optional;

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
    public String indexPage(Model model, Principal principal){
        if (principal!=null){
            Optional<Customer> customerObject = userService.checkForOAuthAccount(principal.getName());
            if (!customerObject.isPresent()){
                Customer customer = new Customer();
                customer.setUsername(principal.getName());
                customer.setPassword(principal.getName());
                model.addAttribute("customer", customer);
                return "/RegistrationPage";
            }
            return "/AuthenticatingPage";
        }
        return "redirect:/LoginCtrl/login";
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
