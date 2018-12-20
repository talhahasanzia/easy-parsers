package com.talhahasanzia.csv.core;

import com.talhahasanzia.csv.models.Row;
import com.talhahasanzia.csv.exceptions.ColumnsLengthException;

/**
 * Created by Talha Hasan Zia on 12-Feb-18.
 * <p></p><b>Description:</b><p></p> Why class was created?
 * <p></p>
 * <b>Public Methods:</b><p></p> Only listing to public methods usage.
 */
public interface Parser<T> {
    void parse(String data, ParseCallback<T> parseResult);

    Row[] getRows(String data) throws ColumnsLengthException;

    String[] getWords(String row);

    Row getTitles(String data);

    int getTotalColumns(Row titles);

}
