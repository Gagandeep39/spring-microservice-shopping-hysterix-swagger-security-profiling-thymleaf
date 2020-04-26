package com.gagan.shopping2loginmicroservice.controller;

import com.gagan.shopping2loginmicroservice.model.Customer;
import com.gagan.shopping2loginmicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/register")
    public ModelAndView showRegistration(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customer", new Customer());
        modelAndView.setViewName("RegistrationPage");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@Valid Customer customer, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();

        if (!bindingResult.hasErrors()) {
            userService.saveUser(customer);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("customer", new Customer());
        }
        modelAndView.setViewName("RegistrationPage");
        return modelAndView;
    }

}
