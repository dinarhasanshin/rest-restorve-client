package com.huntmen.rest_reserve.activity.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.huntmen.rest_reserve.activity.main.MainActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO: Проверить авторизован ли пользователь

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}