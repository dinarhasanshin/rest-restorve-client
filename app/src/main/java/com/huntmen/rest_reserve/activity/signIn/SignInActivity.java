package com.huntmen.rest_reserve.activity.signIn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.huntmen.rest_reserve.R;
import com.huntmen.rest_reserve.activity.main.MainActivity;
import com.huntmen.rest_reserve.model.User;

public class SignInActivity extends AppCompatActivity implements SignInView {

    private EditText firstName;
    private EditText lastName;
    private EditText numberPhone;
    private EditText password;

    private Button signIn;
    private Button login;

    private SignInPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        numberPhone = (EditText) findViewById(R.id.login_phone);
        password = (EditText) findViewById(R.id.login_password);

        presenter = new SignInPresenter(this);

        login = (Button) findViewById(R.id.login_button);
        signIn = (Button) findViewById(R.id.register_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
                SignInActivity.this.finish();

            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstNameData = firstName.getText().toString();
                String lastNameData = lastName.getText().toString();
                String numberPhoneData = numberPhone.getText().toString();
                String passwordData =  password.getText().toString();

                presenter.getRegister(firstNameData, lastNameData, numberPhoneData, passwordData);
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
        Toast.makeText(this, user.getToken(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}