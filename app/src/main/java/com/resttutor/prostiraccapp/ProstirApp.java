package com.resttutor.prostiraccapp;

import android.app.Application;

import com.resttutor.prostiraccapp.model.api.AccountApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProstirApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static AccountApi getAccountApi() {
        return new Retrofit.Builder()
                .baseUrl("https://jsonblob.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(AccountApi.class);
    }

}
