package com.example.alex.restoadvisor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface RestaurantAPI {

    //requete restos
    @GET("restos")
    Call<List<Restaurant>> getRestaurants();

    @GET("restos/{id}")
    Call<List<Restaurant>> getRestaurantById(@Path("id") Integer id);

    @GET("restoName/{name}")
    Call<Restaurant> getRestaurantByName(@Path("name") String name);

    //requetes menu
    @GET("menuResto/{id}")
    Call<Restaurant> getMenuRestaurant(@Path("id") Integer id);


    //requetes user
    @FormUrlEncoded
    @POST("login")
    Call<User> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<User> register(@Field("email") String email, @Field("password") String password, @Field("name") String name, @Field("c_password") String c_password);

    //requete avis
    @FormUrlEncoded
    @POST("postcomment/{id}")
    Call<Comment> postcomment(@Path("id") String id, @Field("comment") String comment, @Field("rate") Integer rate, @Header("Authorization") String token);






    @DELETE("/delete-resto/{id}")
    Call<List<Restaurant>> DeleteRestaurantById(@Path("id") Integer id);

    @FormUrlEncoded
    @POST("newresto")
    Call<User> newresto(@Field("name") String name, @Field("description") String description, @Field("localisation") String localisation, @Field("rate") String rate, @Field("phone") String phone, @Field("openTime") String openTime, @Field("closeTime") String closeTime);

    @FormUrlEncoded
    @POST("upresto/{id}")
    Call<User> upresto(@Path("id") Integer id, @Field("name") String name, @Field("description") String description, @Field("localisation") String localisation, @Field("rate") String rate, @Field("phone") String phone, @Field("openTime") String openTime, @Field("closeTime") String closeTime);

}
