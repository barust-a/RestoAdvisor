package com.example.alex.restoadvisor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Restaurant {
    @SerializedName("name") @Expose
    private String name;

    @SerializedName("id") @Expose
    private Integer id;

    @SerializedName("description") @Expose
    private String description;

    @SerializedName("localisation") @Expose
    private String localisation;

    @SerializedName("rate") @Expose
    private String rate;

    @SerializedName("phone") @Expose
    private String phone;

    @SerializedName("openTime") @Expose
    private String openTime;

    @SerializedName("closeTime") @Expose
    private String closeTime;

    public String getName() {return name;}

    public String getCloseTime() {
        return closeTime;
    }

    public String getDescription() {
        return description;
    }

    public String getLocalisation() {
        return localisation;
    }

    public String getOpenTime() {
        return openTime;
    }

    public String getPhone() {
        return phone;
    }

    public String getRate() {
        return rate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
