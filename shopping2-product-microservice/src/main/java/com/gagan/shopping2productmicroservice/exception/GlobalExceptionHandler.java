package com.gagan.shopping2productmicroservice.exception;

import com.gagan.shopping2productmicroservice.model.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
      /**
     * @param Exception Handles all kinds of Exception
     * @return Returns a response object with an Error code
     * All generic exceptions will be caught by this error handler
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAllError(Exception exception){
        ErrorResponse response = new ErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setTimeStamp(System.currentTimeMillis());
        response.setMessage(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}