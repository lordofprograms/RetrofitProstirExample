package com.resttutor.prostiraccapp.model.api;

import com.resttutor.prostiraccapp.models.Accounts;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AccountApi {

    @GET("api/6b9842b6-14fe-11e9-8960-a93e970e1051")
    Call<Accounts> getAccounts();

}
