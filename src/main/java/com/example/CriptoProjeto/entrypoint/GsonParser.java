package com.example.CriptoProjeto.entrypoint;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class GsonParser {


    public static String objectToJson(Object object){
        return new Gson().toJson(object);

    }

    public static <T> List<T> jsonToObjectList(String json, Class<T[]> tClass){
        Gson gson = new Gson();
//        TypeToken<List<T>> token = new TypeToken<>(){};
//        Type type = token.getType();
//
//        return gson.fromJson(json, type);
        T[] arr = gson.fromJson(json, tClass);
        return Arrays.asList(arr);
    }

    public static <T> Object jsonToObject(String json, Class<T> tClass){
        Gson gson = new Gson();
//        TypeToken<List<T>> token = new TypeToken<>(){};
//        Type type = token.getType();
//
//        return gson.fromJson(json, type);
        T obj = gson.fromJson(json, tClass);
        return obj;
    }

}
