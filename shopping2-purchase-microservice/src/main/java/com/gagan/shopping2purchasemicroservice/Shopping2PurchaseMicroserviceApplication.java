package com.gagan.shopping2purchasemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Shopping2PurchaseMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Shopping2PurchaseMicroserviceApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
