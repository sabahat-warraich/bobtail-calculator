package com.bobtail.utalities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class DataUtils {

    //read content data json file and get content for video file

    @DataProvider
    public Object[] calDataProvider() {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject;
        // Read JSON file and after parsing store in java object
        //java object
        Object obj=null;
        try {
            obj = parser.parse(new FileReader(".\\TestData\\bobtail.json"));
            //Parse java object to json object
        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
        }
        jsonObject = (JSONObject) obj;

        // Extract array data from JSONObject
        assert jsonObject != null;
        JSONArray formInfo = (JSONArray) jsonObject.get("calculator");
        // String array to store JSONArray data
        String[] dataArray = new String[formInfo.size()];

        // JSONObject to read each JSONArray object
        JSONObject formInfoData;
        String _vatPrice, _vatRate,_inclusiveVat;

        // Get data from JSONArray and store it in String array
        for (int i = 0; i < formInfo.size(); i++) {
            formInfoData = (JSONObject) formInfo.get(i);
            _vatPrice= (String) formInfoData.get("vatPrice");
            _vatRate = (String) formInfoData.get("vatRate");
            _inclusiveVat = (String) formInfoData.get("inclusivePrice");


            dataArray[i] = _vatPrice + "," + _vatRate + "," + _inclusiveVat;
        }
        return  dataArray;
    }


}

