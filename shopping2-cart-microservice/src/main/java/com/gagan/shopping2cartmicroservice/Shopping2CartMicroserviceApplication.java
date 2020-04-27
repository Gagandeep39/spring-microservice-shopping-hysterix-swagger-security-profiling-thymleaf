package com.gagan.shopping2cartmicroservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableSwagger2WebMvc
public class Shopping2CartMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Shopping2CartMicroserviceApplication.class, args);
    }

}
