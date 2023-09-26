package com.example.orderservice.exception;

import com.example.orderservice.aop.ApplicationValidateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(value = ApplicationValidateException.class)
    public ResponseEntity<ErrorDto> handle(ApplicationValidateException e){
        final var build = ErrorDto.builder()
                .code("badrequest")
                .message("validated")
                .details(e.getDetailsList())
                                  .build();
        return new ResponseEntity<>(build, HttpStatus.BAD_REQUEST);
    }
}
