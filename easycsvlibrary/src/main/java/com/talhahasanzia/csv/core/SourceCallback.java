package com.talhahasanzia.csv.core;

import com.talhahasanzia.csv.exceptions.ParseException;

public interface SourceCallback {
    void onSourceFound(String data);

    void onSourceError(ParseException parseException);
}
