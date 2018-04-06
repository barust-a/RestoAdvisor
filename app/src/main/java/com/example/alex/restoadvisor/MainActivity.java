package com.example.alex.restoadvisor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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
    public myListViewAdapter MyListViewAdaptater;
    private EditText editText;
    private Button button;
    public static String token = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.configureRetrofit();
        getRestaurantsViaAPI();
         Button logButton = (Button) findViewById(R.id.login);
         if (token != null) {
             logButton.setVisibility(View.GONE);
         }
        myListView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        restaurants = new ArrayList<>();
        Restaurant resto = new Restaurant();
        this.MyListViewAdaptater = new myListViewAdapter(getApplicationContext(), restaurants);
        this.myListView.setAdapter(MyListViewAdaptater);
        Restaurant restaurant1 = new Restaurant();

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>parent,View v, int position, long id){

                Restaurant restaurant1 = restaurants.get(position);
                Intent intent = new Intent(MainActivity.this, RestaurantActivity.class);
                intent.putExtra("id", restaurant1.getId());
                intent.putExtra("name", restaurant1.getName());
                intent.putExtra("description",restaurant1.getDescription());
                intent.putExtra("phone",restaurant1.getPhone());
                intent.putExtra("localisation",restaurant1.getLocalisation());
                intent.putExtra("rate",restaurant1.getRate());
                intent.putExtra("opentime",restaurant1.getOpenTime());
                intent.putExtra("closetime",restaurant1.getCloseTime());
                //based on item add info to intent
                startActivity(intent);
            }
        });

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = editText.getText().toString().trim();
                Restaurant restaurant1 = new Restaurant();
                restaurant1.setName(Name);
                restaurant1.setId(1);
                restaurants.add(restaurant1);
                MyListViewAdaptater.notifyDataSetChanged();

            }
        });*/
    }

    /** Called when the user taps the Send button */
    /*public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }*/

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
                List<Restaurant> restaurantList;
                restaurantList = response.body();

                if (restaurantList != null) {
                    for (Restaurant restaurant: restaurantList) {
                        if (restaurant != null) {
                            Log.d(TAG, "restaurant name is " + restaurant.getId());
                            restaurants.add(restaurant);
                        }
                    }
                    MyListViewAdaptater.notifyDataSetChanged();
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

    public void reset_list(){
        restaurants = new ArrayList<>();
        MyListViewAdaptater.notifyDataSetChanged();
    }

    public void getRestoByName(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        String name = editText.getText().toString();
        restaurantApi.getRestaurantByName(name).enqueue(new Callback<Restaurant>() {
            @Override
            public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {
                Log.d(TAG, "onResponse:");
                Restaurant restaurant = response.body();
                if (restaurant != null) {
                    reset_list();
                    Log.d(TAG, "onresponse:  " +restaurant.getName());
                } else {
                    Log.d(TAG, "onresponse: restaurant is empty " + response.body());
                }
            }

            @Override
            public void onFailure(Call<Restaurant> call, Throwable t) {
                Log.e(TAG, "onFailur: " + t.getMessage());
            }
        });
    }

    public void login(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
