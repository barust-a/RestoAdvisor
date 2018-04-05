package com.example.alex.restoadvisor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("name") @Expose
    private String name;

    @SerializedName("email") @Expose
    private String email;

    @SerializedName("token") @Expose
    private String token;

    @SerializedName("id") @Expose
    private Integer id;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public Integer getId() {
        return id;
    }
}
