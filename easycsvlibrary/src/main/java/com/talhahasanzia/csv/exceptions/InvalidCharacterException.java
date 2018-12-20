package com.talhahasanzia.csv.exceptions;


/**
 * Exception thrown when there is invalid character while parsing a row (line).
 */
public class InvalidCharacterException extends ParseException {

    private int invalidCharacterIndex;
    private String line;

    public InvalidCharacterException(int invalidCharacterIndex, String line) {
        this.invalidCharacterIndex = invalidCharacterIndex;
        this.line = line;
    }

    @Override
    public String getMessage() {
        return "Invalid row token found at index " + invalidCharacterIndex + " in line \"" + line + "\".";
    }
}
