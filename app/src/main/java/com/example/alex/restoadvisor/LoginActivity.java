package com.example.alex.restoadvisor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.alex.restoadvisor.MainActivity.restaurantApi;




public class LoginActivity extends AppCompatActivity {

public static String token = null;
private final String TAG = "LoginActivity";
private User user = new User();
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

    void connected() {
        final TextView text = (TextView) findViewById(R.id.isconnect);
        text.setText("you are now connected you can go back to restaurants");
    }

    void notConnected() {
        final TextView text = (TextView) findViewById(R.id.isconnect);
        text.setText("invalid mail or password");
    }

    public void registerbutton(View view2) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void Login(View view) {
        getLogEmail();
        getLogPassword();
        restaurantApi.login(logEmail, logPassword).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG, "onResponse:");
                user = response.body();
                if (user != null) {
                   token = user.getToken();
                    connected();
                } else {
                    notConnected();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "onFailur: " + t.getMessage());
            }
        });
    }


}
