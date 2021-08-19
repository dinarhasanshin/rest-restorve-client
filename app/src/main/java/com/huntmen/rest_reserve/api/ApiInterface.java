package com.huntmen.rest_reserve.api;

import com.huntmen.rest_reserve.model.User;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("auth/client/login")
    Call<User> login(@Body HashMap<String, String> map);

    @POST("auth/client/register")
    Call<User> register(@Body HashMap<String, String> map);

}
