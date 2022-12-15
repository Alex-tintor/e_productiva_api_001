package com.sena.eproductiva.manager.util;

import com.google.gson.Gson;

public class GsonUtil {

    public static String serializable(Object src){
        Gson gson = new Gson();
        return gson.toJson(src);
    }
    
    public static <D> D toObject(String json, Class<D> dClass){
        Gson gson = new Gson();
        return gson.fromJson(json, dClass);
    }

    public static <D> D toObject(Object src, Class<D> dClass){
        Gson gson = new Gson();
        String json = gson.toJson(src);
        return gson.fromJson(json, dClass);
    }
}
