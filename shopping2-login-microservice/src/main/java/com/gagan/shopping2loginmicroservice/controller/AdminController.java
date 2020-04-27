package com.gagan.shopping2loginmicroservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Gagandeep
 * @date 27-04-2020
 * @time 15:34
 */

@Controller
public class AdminController {
    @GetMapping("/admin")
    public ModelAndView showAdminPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/AdminOnly");
        return modelAndView;
    }
}
