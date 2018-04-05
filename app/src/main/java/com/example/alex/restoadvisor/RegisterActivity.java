package com.example.alex.restoadvisor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.alex.restoadvisor.MainActivity.restaurantApi;

public class RegisterActivity extends AppCompatActivity {
private String name;
private String email;
private String password;
private String c_password;

private User user = new User();
private final String TAG = "RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }



    private void inputName(){
        EditText editText = (EditText) findViewById(R.id.name);
        name = editText.getText().toString();
    }
    private void inputEmail(){
        EditText editText = (EditText) findViewById(R.id.email);
        email = editText.getText().toString();
    }
    private void inputPassword(){
        EditText editpass = (EditText) findViewById(R.id.password);
        EditText editc_pass = (EditText) findViewById(R.id.c_password);
        String pass = editpass.getText().toString();
        String c_pass = editc_pass.getText().toString();

        if (pass.equals(c_pass)) {
            password = pass;
            c_password = c_pass;
            final TextView text = (TextView) findViewById(R.id.isregister);
            text.setText("your account is create mr : " + name);
        }
        else {
            final TextView text = (TextView) findViewById(R.id.isregister);
            text.setText("password and his confirmation must be the same value");
        }
    }

    public void Register(View view) {
        inputEmail();
        inputName();
        inputPassword();

        restaurantApi.register(email, password, name, c_password).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG, "onResponse:");
                user = response.body();
                if (user != null) {
                    Log.d(TAG, "you are now register");
                } else {
                    Log.d(TAG, "failed at adding one persone " + response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "onFailur: " + t.getMessage());
            }
        });

    }
}
