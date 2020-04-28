package com.gagan.shopping2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Shopping2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Shopping2ServerApplication.class, args);
    }

}
