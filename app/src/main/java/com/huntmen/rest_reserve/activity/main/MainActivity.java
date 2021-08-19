package com.huntmen.rest_reserve.activity.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.huntmen.rest_reserve.R;
import com.huntmen.rest_reserve.activity.signIn.SignInActivity;
import com.huntmen.rest_reserve.model.User;

public class MainActivity extends AppCompatActivity implements MainView {

    private EditText numberPhone;
    private EditText password;

    private Button login;
    private Button register_button;

    public MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberPhone = (EditText) findViewById(R.id.login_phone);
        password = (EditText) findViewById(R.id.login_password);

        presenter = new MainPresenter(this);

        login = (Button) findViewById(R.id.login_button);
        register_button = (Button) findViewById(R.id.register_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String numberPhoneData = numberPhone.getText().toString();
                String passwordData = password.getText().toString();

                presenter.getLogin(numberPhoneData, passwordData);
            }
        });

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
                MainActivity.this.finish();

            }
        });

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onGetResult(User user) {
        Toast.makeText(MainActivity.this, user.getToken(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}