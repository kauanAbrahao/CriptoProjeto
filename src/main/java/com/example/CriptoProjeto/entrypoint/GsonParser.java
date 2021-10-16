package com.example.CriptoProjeto.entrypoint;

import com.example.CriptoProjeto.entity.CriptoExtremo;
import com.example.CriptoProjeto.entity.CriptoValor;
import com.example.CriptoProjeto.entity.Criptomoeda;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
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

    public static <T> Collection jsonToObjectList(String json, Class<T> tClass){
        Gson gson = new Gson();
        TypeToken<List<T>> token = new TypeToken<List<T>>(){};
        Type type = token.getType();

        return gson.fromJson(json, type);
    }

    public static List<CriptoExtremo> jsonToObjectList(String json){
        Gson gson = new Gson();
        TypeToken<List<CriptoExtremo>> token = new TypeToken<>(){};
        Type type = token.getType();

        return gson.fromJson(json, type);
    }

    public static List<CriptoValor> jsonToObjectList(String json, boolean euEstouAquiPorFavorMeRetire){
        Gson gson = new Gson();
        TypeToken<List<CriptoValor>> token = new TypeToken<>(){};
        Type type = token.getType();

        return gson.fromJson(json, type);
    }

    public static List<Criptomoeda> jsonToCriptomoedaList(String json){
        Gson gson = new Gson();
        TypeToken<List<Criptomoeda>> token = new TypeToken<>(){};
        Type type = token.getType();

        return gson.fromJson(json, type);
    }
}
