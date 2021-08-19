package com.huntmen.rest_reserve.activity.main;

import com.huntmen.rest_reserve.model.User;

public interface MainView {

    void showLoading();
    void hideLoading();
    void onGetResult(User user);
    void onErrorLoading(String message);

}
