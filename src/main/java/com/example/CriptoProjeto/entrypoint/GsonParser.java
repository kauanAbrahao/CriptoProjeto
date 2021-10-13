package com.example.CriptoProjeto.entrypoint;

import com.example.CriptoProjeto.entity.Criptomoeda;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class GsonParser {


    public static String objectToJson(Object object){
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return json;
    }

    public static Criptomoeda jsonToObject(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Criptomoeda.class);


    }

    public static List<Criptomoeda> jsonToObjectList(String json){
        Gson gson = new Gson();
        TypeToken<List<Criptomoeda>> token = new TypeToken<List<Criptomoeda>>(){};
        Type type = token.getType();

        return gson.fromJson(json, type);
    }
}
