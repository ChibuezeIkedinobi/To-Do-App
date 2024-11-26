package com.group2.To_Do_App.exception.customException;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException() {
        super("The input is invalid...");
    }
}
