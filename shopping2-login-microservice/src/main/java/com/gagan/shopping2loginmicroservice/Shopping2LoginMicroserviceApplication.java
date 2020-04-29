package com.gagan.shopping2loginmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * ****************************************************************************************************
 * ALWAYS run the page with hystrix fall back command once before entering the URL in Hystrix Dashboard
 * http://localhost:4001/actuator/hystrix.stream
 * ****************************************************************************************************
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
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
