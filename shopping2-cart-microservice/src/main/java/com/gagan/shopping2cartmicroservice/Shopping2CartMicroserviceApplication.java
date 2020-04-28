package com.gagan.shopping2cartmicroservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableSwagger2WebMvc
@EnableEurekaClient
public class Shopping2CartMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Shopping2CartMicroserviceApplication.class, args);
    }

}
