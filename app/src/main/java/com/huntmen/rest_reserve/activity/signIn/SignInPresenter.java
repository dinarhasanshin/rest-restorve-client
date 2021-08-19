package com.huntmen.rest_reserve.activity.signIn;

import androidx.annotation.NonNull;

import com.huntmen.rest_reserve.api.ApiClient;
import com.huntmen.rest_reserve.api.ApiInterface;
import com.huntmen.rest_reserve.model.User;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInPresenter {

    private SignInView view;

    public SignInPresenter(SignInView view) {
        this.view = view;
    }

    void getRegister(String firstName, String lastName, String numberPhone, String password){

        HashMap<String, String> map = new HashMap<>();

        map.put("firstName", firstName);
        map.put("lastName", lastName);
        map.put("numberPhone", numberPhone);
        map.put("password", password);

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<User> call = apiInterface.register(map);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {

                if (response.isSuccessful() && response.body() != null) {

                    view.onGetResult(response.body());

                }

            }

            @Override
            public void onFailure(@NonNull Call<User> call,@NonNull Throwable t) {

                view.onErrorLoading(t.getLocalizedMessage());

            }
        });

    }

}
