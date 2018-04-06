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

public class Affiche extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.restoadvisor.MESSAGE";
    public static RestaurantAPI restaurantApi;
    public static Retrofit retrofit;
    private List<Menu> menus;
    private List<Avis> avis;
    private final String TAG = "MainActivity";
    public ListView ListMenu1;
    public ListView ListCom;
    public MenuAdaptater menuAdaptater;
    public AvisAdapteter avisAdapteter;
    private EditText editText;
    private Button button;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resto_affiche);

        ListMenu1 = (ListView) findViewById(R.id.list_menu);
        ListCom = (ListView) findViewById(R.id.list_avis);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        menus = new ArrayList<>();
        avis = new ArrayList<>();

        this.menuAdaptater = new MenuAdaptater(getApplicationContext(), menus);
        this.ListMenu1.setAdapter(menuAdaptater);
        this.avisAdapteter = new AvisAdapteter(getApplicationContext(), avis);
        this.ListCom.setAdapter(avisAdapteter);
    }

/**    public static void configureRetrofit() {
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
    }*/
}
