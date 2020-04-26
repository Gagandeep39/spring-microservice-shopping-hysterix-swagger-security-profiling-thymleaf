package com.gagan.shopping2loginmicroservice.controller;

import com.gagan.shopping2loginmicroservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 10:54
 */

@Controller
@RequestMapping("/LoginCtrl")
public class MyLoginController {

    Logger logger = LoggerFactory.getLogger(MyLoginController.class);

    @GetMapping("/login")
    public String loginForm(Model model, Principal principal){
        if (principal!=null) return "/home";
        model.addAttribute("user", new User());
        return "/LoginPage";
    }

    /**
     * ******DOESNT WORK******
     * ******ASK Sir**********
     * Question: http.loginProcessingUrl("/login") in Security Config doesnt redirect to thus mapping
     * @param user
     * @param bindingResult
     * @return
     */
    @PostMapping("/login")
    public String loginValidation(@Valid User user, BindingResult bindingResult){
        logger.info("--------------------");
        if (bindingResult.hasErrors())
            return "/LoginPage";
        return "/Home";
    }
}
