package com.workintech.s19d1.exceptions;

import com.workintech.s19d1.exception.ApiException;
import com.workintech.s19d1.exception.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class ApiGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleApiException(ApiException exception) {
        log.error("API Exception occurred: {}", exception.getMessage(), exception);
        ExceptionResponse response = new ExceptionResponse(
                exception.getMessage(),
                exception.getHttpStatus().value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, exception.getHttpStatus());
    }
}