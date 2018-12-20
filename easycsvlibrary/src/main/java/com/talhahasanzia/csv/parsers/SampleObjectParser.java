package com.talhahasanzia.csv.parsers;

import com.talhahasanzia.csv.core.ParseCallback;
import com.talhahasanzia.csv.core.Parser;
import com.talhahasanzia.csv.exceptions.ColumnsLengthException;
import com.talhahasanzia.csv.models.Row;
import com.talhahasanzia.csv.models.SampleObject;

import java.util.LinkedList;
import java.util.List;

public class SampleObjectParser implements Parser<SampleObject[]> {

    private int totalColumns;
    private Row titleRow;
    private Row[] rows;
    private final String splitterRegex = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";


    @Override
    public void parse(String data, ParseCallback<SampleObject[]> parseResult) {
        // clear cached instances on each time parse is called
        rows = null;
        titleRow = null;
        totalColumns = 0;


        Row[] rows;

        try {
            rows = getRows(data);
        } catch (ColumnsLengthException e) {
            parseResult.onParsingFailure(e);
            return;
        }

        SampleObject[] sampleObjects = new SampleObject[rows.length];

        for (int i = 0; i < rows.length; i++) {

            sampleObjects[i] = new SampleObject(
                    rows[i].getEntryAtColumn(0),
                    rows[i].getEntryAtColumn(1),
                    rows[i].getEntryAtColumn(2),
                    Integer.parseInt(rows[i].getEntryAtColumn(3))

            );


        }

        parseResult.onParsingSuccess(sampleObjects);

    }

    @Override
    public Row[] getRows(String data) throws ColumnsLengthException {

        if (rows == null) {

            List<Row> rowList = new LinkedList<>();

            int previous = 0;
            int index;

            char[] dataArray = data.toCharArray();

            for (index = previous; index < data.length(); index++) {

                if (dataArray[index] == '\n') {

                    String[] words = getWords(data.substring(previous, index));

                    if (words.length != getTitles(data).getEntries().length) {
                        throw new ColumnsLengthException(titleRow.getEntries().length, words.length);
                    }

                    Row row = new Row(words);
                    rowList.add(row);
                    previous = ++index;
                }
            }

            if (index > ++previous) {
                // a line was missed
                String[] words = getWords(data.substring(previous, data.length()));

                if (words.length != getTitles(data).getEntries().length) {
                    throw new ColumnsLengthException(titleRow.getEntries().length, words.length);
                }

                Row row = new Row(words);
                rowList.add(row);

            }

            rowList.remove(0); // remove title column from the data

            // cache rows
            rows = rowList.toArray(new Row[0]);
        }

        return rows;

    }

    @Override
    public String[] getWords(String rowAsString) {
        return rowAsString.split(splitterRegex);

    }

    @Override
    public Row getTitles(String data) {

        if (titleRow == null) {
            String firstLine = data.substring(0, data.indexOf('\n'));
            // cache parsed titles

            String[] splitted = firstLine.split(splitterRegex);


            this.titleRow = new Row(splitted);
        }

        return titleRow;

    }


    @Override
    public int getTotalColumns(Row titles) {


        if (totalColumns == 0) {
            // cache total columns
            this.totalColumns = titles.getEntries().length;
        }

        return totalColumns;
    }


}
