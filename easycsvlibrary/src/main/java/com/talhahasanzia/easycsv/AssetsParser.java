package com.talhahasanzia.easycsv;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Talha Hasan Zia on 12-Feb-18.
 * <p></p><b>Description:</b><p></p> Why class was created?
 * <p></p>
 * <b>Public Methods:</b><p></p> Only listing to public methods usage.
 */
class AssetsParser implements Parser {

    private Context context;
    private String path;
    private String encoding;


    public AssetsParser(Context context, String path) {
        this.context = context;
        this.path = path;
    }

    public AssetsParser(Context context, String path, String encoding) {
        this.context = context;
        this.path = path;
        this.encoding = encoding;
    }



    @Override
    public String[] getLines(String fullText) {
        AssetManager assetManager = context.getAssets();

        if (encoding != null)
            return readFromFile(assetManager, encoding);
        else
            return readFromFile(assetManager);

    }

    @Override
    public String[] getWords(String line) {
        return new String[0];
    }


    private String[] readFromFile(AssetManager assetManager) {

        ArrayList<String> lines = new ArrayList<>();

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(
                    new InputStreamReader(assetManager.open(path)));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                //process line
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }
        return lines.toArray(new String[lines.size()]);
    }


    private String[] readFromFile(AssetManager assetManager, String encoding) {

        ArrayList<String> lines = new ArrayList<>();


        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(
                    new InputStreamReader(assetManager.open(path), encoding));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                //process line
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }
        return lines.toArray(new String[lines.size()]);
    }
}
