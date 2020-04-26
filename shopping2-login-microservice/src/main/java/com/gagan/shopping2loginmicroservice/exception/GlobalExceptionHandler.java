package com.gagan.shopping2loginmicroservice.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 15:26
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public String handleAll(Exception e){
        return e.getMessage();
    }
}
