package com.gagan.shopping2loginmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class Shopping2LoginMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Shopping2LoginMicroserviceApplication.class, args);
    }

    @Bean
    public Authentication getAuthentication(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }
}
