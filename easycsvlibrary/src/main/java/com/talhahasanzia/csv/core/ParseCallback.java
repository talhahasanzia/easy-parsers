package com.talhahasanzia.csv.core;

import com.talhahasanzia.csv.exceptions.ParseException;

public interface ParseCallback<T> {


    void onParsingSuccess(T result);

    void onParsingFailure(ParseException error);



}
