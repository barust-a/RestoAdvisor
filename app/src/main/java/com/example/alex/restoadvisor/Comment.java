package com.example.alex.restoadvisor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment {
    @SerializedName("comment") @Expose
    private String comment;

    @SerializedName("rate") @Expose
    private Integer rate;

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getComment() {

        return comment;
    }

    public Integer getRate() {
        return rate;
    }
}
