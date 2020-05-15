package com.application.springboot_step_by_step.handler;

import com.application.springboot_step_by_step.error.ResourceNotFoundDetails;
import com.application.springboot_step_by_step.error.ResourceNotFoundException;
import com.application.springboot_step_by_step.error.ValidatorErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException manvException) {

        List<FieldError> fieldErros = manvException.getBindingResult().getFieldErrors();

        String fields = fieldErros.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String fieldMessages = fieldErros.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));

        ValidatorErrorDetails rfnDetails = ValidatorErrorDetails.Builder
                                                                        .newBuilder()
                                                                        .timestamp(new Date().getTime())
                                                                        .status(HttpStatus.NOT_FOUND.value())
                                                                        .title("Resource Not Found")
                                                                        .detail(manvException.getMessage())
                                                                        .developerMessage(manvException.getClass().getName())
                                                                        .field(fields)
                                                                        .fieldMessage(fieldMessages)
                                                                        .build();

        return new ResponseEntity<>(rfnDetails,HttpStatus.NOT_FOUND);

    }
}
