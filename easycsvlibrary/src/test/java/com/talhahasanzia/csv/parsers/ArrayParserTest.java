package com.talhahasanzia.csv.parsers;

import com.talhahasanzia.csv.core.ParseCallback;
import com.talhahasanzia.csv.core.Parser;
import com.talhahasanzia.csv.exceptions.ColumnsLengthException;
import com.talhahasanzia.csv.exceptions.ParseException;
import com.talhahasanzia.csv.parsers.ArrayParser;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class ArrayParserTest {

    private Parser<String[][]> parser;

    private ArrayParserCallback callback;

    private String simpleData = "Name,Comment,Title,Age\n" +
            "Azteca Montenerro,Too early to be late,Guardian,22\n" +
            "Michel Santos,Misleading Headlines,Warrior,24\n" +
            "Mista Wista,Im gonna say the yesn't,Nope,34";

    private String specialCharsData = "Name,Comment,Title,Age\n" +
            "Azteca Montenerro,\"Too \"\"early\"\" to be late\",Guardian,22\n" +
            "Michel Santos,\"Misleading, Headlines\",Warrior,24\n" +
            "Mista Wista,\"Im gonna say the \"\"yesn't\"\"\",\"N%%%&,\",34";

    @Before
    public void setUp() {
        parser = new ArrayParser();
        callback = new ArrayParserCallback();
    }

    @Test
    public void parserTestSimpleData() throws ColumnsLengthException {
        System.out.println("\n\n---------Test Simple Characters Data---------");
        parser.parse(simpleData, callback);

    }


    @Test
    public void parserTestSpecialData() throws ColumnsLengthException {
        System.out.println("\n\n---------Test Special Character Data---------");
        parser.parse(specialCharsData, callback);

    }

    private class ArrayParserCallback implements ParseCallback<String[][]> {

        @Override
        public void onParsingSuccess(String[][] result) {

            for (int i = 0; i < 3; i++) {  // we know in sample data we provided 3 entries only

                for (int j = 0; j < 4; j++) { // we know we have 4 columns
                    assertNotNull("value not present: " + result[i][j], result[i][j]);
                    System.out.print(result[i][j] + " - ");
                }

                System.out.println("");
            }

        }

        @Override
        public void onParsingFailure(ParseException error) {
            assertNotNull(error.getMessage(), null); // forcefully flag test fail
        }

    }
}