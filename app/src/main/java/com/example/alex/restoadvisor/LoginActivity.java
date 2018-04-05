package com.example.alex.restoadvisor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.alex.restoadvisor.MainActivity.restaurantApi;




public class LoginActivity extends AppCompatActivity {

public static String token;
private final String TAG = "LoginActivity";
private User user;
private String logEmail;
private String logPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    private void getLogEmail(){
        EditText editText = (EditText) findViewById(R.id.email);
        logEmail = editText.getText().toString();
    }

    private void getLogPassword() {
        EditText editText = (EditText) findViewById(R.id.password);
        logPassword = editText.getText().toString();
    }
    public void Login(View view) {
        getLogEmail();
        getLogPassword();
        Log.d(TAG, logEmail);
        Log.d(TAG, logPassword);
        restaurantApi.login(logEmail, logPassword).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG, "onResponse:");
               User user = response.body();
                if (user != null) {
                    Log.d(TAG, "user connecter reussi " + user.token);
                } else {
                    Log.d(TAG, "onresponse: login form is empty " + response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "onfailur: " + t.getMessage());
            }
        });
    }


}
