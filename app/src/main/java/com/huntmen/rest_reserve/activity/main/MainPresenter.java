package com.huntmen.rest_reserve.activity.main;

import androidx.annotation.NonNull;

import com.huntmen.rest_reserve.api.ApiClient;
import com.huntmen.rest_reserve.api.ApiInterface;
import com.huntmen.rest_reserve.model.User;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    void getLogin(String email, String password) {

//        view.showLoading();

        HashMap<String, String> map = new HashMap<>();

        map.put("email", email);
        map.put("password", password);

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<User> call = apiInterface.login(map);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call,@NonNull Response<User> response) {

//                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {

                    view.onGetResult(response.body());

                }

            }

            @Override
            public void onFailure(@NonNull Call<User> call,@NonNull Throwable t) {

//                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());

            }
        });

    }



}
