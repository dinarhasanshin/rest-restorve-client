package com.huntmen.rest_reserve.activity.restaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RestaurantActivity extends AppCompatActivity implements RestaurantView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
    }
}