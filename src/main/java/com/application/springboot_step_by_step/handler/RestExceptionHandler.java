package com.application.springboot_step_by_step.handler;

import com.application.springboot_step_by_step.error.ResourceNotFoundDetails;
import com.application.springboot_step_by_step.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rfnException) {

        ResourceNotFoundDetails rfnDetails = ResourceNotFoundDetails.Builder
                                                                        .newBuilder()
                                                                        .timestamp(new Date().getTime())
                                                                        .status(HttpStatus.NOT_FOUND.value())
                                                                        .title("Resource Not Found")
                                                                        .detail(rfnException.getMessage())
                                                                        .developerMessage(rfnException.getClass().getName())
                                                                        .build();
        
        return new ResponseEntity<>(rfnDetails,HttpStatus.NOT_FOUND);

    }
}
