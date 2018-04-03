package com.example.alex.restoadvisor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestaurantAPI {

    @GET("restos")
    Call<List<Restaurant>> getRestaurants();

}
