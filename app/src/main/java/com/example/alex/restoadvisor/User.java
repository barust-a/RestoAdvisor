package com.example.alex.restoadvisor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("name") @Expose
    public String name;

    @SerializedName("email") @Expose
    public String email;

    @SerializedName("token") @Expose
    public String token;

    @SerializedName("id") @Expose
    public Integer id;
}
