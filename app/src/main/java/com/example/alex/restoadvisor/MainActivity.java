package com.example.alex.restoadvisor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.restoadvisor.MESSAGE";
    public static RestaurantAPI restaurantApi;
    public static Retrofit retrofit;
    private List<Restaurant> restaurants;
    private final String TAG = "MainActivity";
    public ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.configureRetrofit();
        getRestaurantsViaAPI();

    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    public static void configureRetrofit() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder().baseUrl("http://172.16.15.194:8000/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

         restaurantApi = retrofit.create(RestaurantAPI.class);
    }

    private void getRestaurantsViaAPI() {
        restaurantApi.getRestaurants().enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                Log.d(TAG, "onResponse:");
                List<Restaurant> restaurantList = response.body();

                if (restaurantList != null) {
                    for (Restaurant restaurant: restaurantList) {
                        Log.d(TAG, "restaurant name is " + restaurant.getId());
                        //restaurants.add(restaurant);
                    }
                    //myListViewadapter.notifyDataSetChanged();
                } else {
                    Log.d(TAG, "onresponse: restaurant is empty " + response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                Log.e(TAG, "onfailur: " + t.getMessage());
            }
        });
    }

}
