package com.example.alex.restoadvisor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface RestaurantAPI {

    //requete restos
    @GET("restos")
    Call<List<Restaurant>> getRestaurants();

    @GET("restos/{id}")
    Call<List<Restaurant>> getRestaurantById(@Path("id") Integer id);

    //requetes user
    @FormUrlEncoded
    @POST("login")
    Call<User> login(@Field("email") String email, @Field("password") String password);

}
