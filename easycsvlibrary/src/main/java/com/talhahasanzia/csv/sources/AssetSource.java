package com.talhahasanzia.csv.sources;

import android.content.Context;

import com.talhahasanzia.csv.core.Source;
import com.talhahasanzia.csv.core.SourceCallback;
import com.talhahasanzia.csv.exceptions.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AssetSource implements Source {

    private Context context;
    private String filePathName;

    public AssetSource(Context context, String filePathName) {
        this.context = context;
        this.filePathName = filePathName;
    }

    @Override
    public void getData(SourceCallback sourceCallback) {
        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader reader = null;

        boolean success = true;

        try {

            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(filePathName)));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //add line
                stringBuilder.append(mLine).append("\n");
            }


        } catch (IOException e) {
            success = false;
            sourceCallback.onSourceError(new ParseException(e.getMessage()));
        } finally {

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                    success = false;
                    sourceCallback.onSourceError(new ParseException(e.getMessage()));
                }
            }
        }

        if (success) {
            sourceCallback.onSourceFound(stringBuilder.toString());
        }
    }
}
