package com.huntmen.rest_reserve.activity.signIn;

import com.huntmen.rest_reserve.model.User;

public interface SignInView {

    void showLoading();
    void hideLoading();
    void onGetResult(User user);
    void onErrorLoading(String message);

}
