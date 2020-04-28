package com.gagan.shopping2loginmicroservice.controller;

import com.gagan.shopping2loginmicroservice.model.Customer;
import com.gagan.shopping2loginmicroservice.model.User;
import com.gagan.shopping2loginmicroservice.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 11:36
 */

@Controller
@RequestMapping("/RegisterCtrl")
public class RegistrationController {

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    Customer customer = new Customer();

    @PostConstruct
    public void init(){
        customer = new Customer();
    }

    @GetMapping("/register")
    public ModelAndView showRegistration(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customer", customer);
        modelAndView.setViewName("RegistrationPage");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@Valid Customer customer, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        logger.info("PASSWORD: " + customer.getUsername());

        if (!bindingResult.hasErrors()) {
            userService.saveUser(customer);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("customer", new Customer());
        }
        modelAndView.setViewName("RegistrationPage");
        return modelAndView;
    }

    @GetMapping("/register/user")
    public ModelAndView addUserCredential(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("/RegisterUser");
        return modelAndView;
    }   

    @PostMapping("/register/user")
    public ModelAndView validateData(@Valid User user, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        if(!bindingResult.hasErrors()){
            logger.info(user.toString());
            customer.setUsername(user.getUsername());
            customer.setPassword(user.getPassword());
            modelAndView.setViewName("/RegistrationPage");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }
        modelAndView.setViewName("/RegisterUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

}
