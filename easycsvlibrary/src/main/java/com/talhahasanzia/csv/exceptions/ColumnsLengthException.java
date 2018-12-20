package com.talhahasanzia.csv.exceptions;

/**
 * Exception thrown when the number of columns in a row (line) entry does not match the number of columns of title row.
 */
public class ColumnsLengthException extends ParseException {

    private int expected, actual;

    public ColumnsLengthException(int expected, int actual) {
        this.expected = expected;
        this.actual = actual;
    }

    @Override
    public String getMessage() {
        return "Columns length mismatch. Expected : " + expected + ", Found: " + actual + " columns.";
    }
}
