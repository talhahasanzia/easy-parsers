package com.talhahasanzia.csv.exceptions;

/**
 * General Exception for the project
 */
public class ParseException extends Exception {
    private String message;

    ParseException() {

    }

    public ParseException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
