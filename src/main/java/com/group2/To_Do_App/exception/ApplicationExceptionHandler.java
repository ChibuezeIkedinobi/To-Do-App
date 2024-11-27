package com.group2.To_Do_App.exception;

import com.group2.To_Do_App.exception.customException.BadCredentialsCustomException;
import com.group2.To_Do_App.exception.customException.InvalidInputException;
import com.group2.To_Do_App.exception.customException.ResourceNotFoundException;
import com.group2.To_Do_App.exception.errorResponse.ErrorResponseFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseFormat> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponseFormat error = new ErrorResponseFormat(
                List.of(ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadCredentialsCustomException.class)
    public ResponseEntity<ErrorResponseFormat> handleBadCredentialsException(BadCredentialsCustomException ex) {
        ErrorResponseFormat error = new ErrorResponseFormat(
                List.of(ex.getMessage()),
                HttpStatus.UNAUTHORIZED
        );
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponseFormat> handleInvalidInputException(InvalidInputException ex) {
        ErrorResponseFormat error = new ErrorResponseFormat(
                List.of(ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseFormat> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorResponseFormat error = new ErrorResponseFormat(
                List.of("An unexpected error occurred. Please try again later."),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}