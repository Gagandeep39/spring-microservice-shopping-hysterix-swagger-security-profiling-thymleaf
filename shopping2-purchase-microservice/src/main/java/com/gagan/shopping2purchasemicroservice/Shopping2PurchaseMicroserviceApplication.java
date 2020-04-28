package com.gagan.shopping2purchasemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableSwagger2WebMvc
@EnableEurekaClient
public class Shopping2PurchaseMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Shopping2PurchaseMicroserviceApplication.class, args);
    }


}
