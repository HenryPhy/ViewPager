package com.example.x1yk;
import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
public class okhttp {
    public static String getString(String path){
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request = new Request.Builder().get().url(path).build();
        try {
            Response execute = okHttpClient.newCall(request).execute();
            ResponseBody body = execute.body();
            return body.string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;}}