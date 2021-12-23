package com.example.registrationapi.Exception.handler;

import com.example.registrationapi.Exception.ApiException;
import com.example.registrationapi.Model.Response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(ApiException exception){
        log.error("Excepiton is occured. Exception:{}", exception.getMessage());
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(exception.getMessage())
                .exceptionType(exception.getClass().getSimpleName())
                .build();
        return ResponseEntity.status(exception.getHttpStatus()).body(errorResponse);
    }
}