package com.example.CriptoProjeto.entrypoint;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParser {

    public static String parseJson(String responseBody){
        JSONArray albuns = new JSONArray(responseBody);
        for(Object album : albuns){
           int id = ((JSONObject) album).getInt("id");
           int userId = ((JSONObject) album).getInt("userId");
           String title = ((JSONObject) album).getString("title");
           System.out.println(id + " " + userId + " " + title);
        }
        return null;
    }
}
