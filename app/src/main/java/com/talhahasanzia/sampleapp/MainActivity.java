package com.talhahasanzia.sampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.talhahasanzia.csv.core.ParseCallback;
import com.talhahasanzia.csv.exceptions.ParseException;
import com.talhahasanzia.csv.lib.EasyParser;
import com.talhahasanzia.sampleapp.models.SampleObject;
import com.talhahasanzia.sampleapp.parsers.SampleObjectParser;
import com.talhahasanzia.csv.sources.AssetSource;

public class MainActivity extends AppCompatActivity implements ParseCallback<SampleObject[]> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EasyParser easyCSV = new EasyParser(new AssetSource(this, "sample.csv"), new SampleObjectParser(), this);
        easyCSV.parse();
    }


    @Override
    public void onParsingSuccess(SampleObject[] result) {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onParsingFailure(ParseException e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
