package com.example.alex.restoadvisor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment {
    @SerializedName("comment") @Expose
    private String comment;

    @SerializedName("rate") @Expose
    private Integer rate;
}
