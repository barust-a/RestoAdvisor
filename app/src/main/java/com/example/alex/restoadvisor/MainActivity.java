package com.example.alex.restoadvisor;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
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
    public ListView myListView;
    public MyListViewAdaptater myListViewAdaptater;
    private EditText editText;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView)findViewById(R.id.list);
        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        restaurants = new ArrayList<>();

        Restaurant resto = new Restaurant();
        resto.setName("Pizza");
        resto.setId(1);
        restaurants.add(resto);

        this.myListViewAdaptater = new MyListViewAdaptater(getApplicationContext(), restaurants);
        this.myListView.setAdapter(myListViewAdaptater);

        /*this.configureRetrofit();
        getRestaurantsViaAPI();*/

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = editText.getText().toString().trim();
                Restaurant restaurant1 = new Restaurant();
                restaurant1.setName(Name);
                restaurant1.setId(1);
                restaurants.add(restaurant1);
                myListViewAdaptater.notifyDataSetChanged();
            }
        });

    }

    public void goto_login(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    /**public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    public void sendMessage(View view) {
        String Name = editText.getText().toString().trim();
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setName(Name);
        restaurant1.setId(1);
        restaurants.add(restaurant1);
        myListViewAdaptater.notifyDataSetChanged();
    }*/

    public static void configureRetrofit() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder().baseUrl("http://172.168.43.7:8000/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

         restaurantApi = retrofit.create(RestaurantAPI.class);
    }

    private void getRestaurantsViaAPI() {
        restaurantApi.getRestaurants().enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                Log.d(TAG, "onResponse:");
                restaurants = response.body();
                if (restaurants != null) {
                    for (Restaurant restaurant: restaurants) {
                        //restaurants.add(restaurant);
                        Log.d(TAG, "restaurant name is " + restaurant.getId());
                    }
                    //MyListViewAdapter.NotifySetChange();
                } else {
                    Log.d(TAG, "onresponse: restaurant is empty " + response.body());
                }
                myListViewAdaptater.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                Log.e(TAG, "onfailure: " + t.getMessage());
            }
        });
    }

}
