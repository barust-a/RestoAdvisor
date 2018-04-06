package com.example.alex.restoadvisor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Avis {

    @SerializedName("id") @Expose
    private int id;

    @SerializedName("id_user") @Expose
    private int id_user;

    @SerializedName("id_resto") @Expose
    private int id_resto;

    @SerializedName("Contain") @Expose
    private String Contain;

    public int get_id(){
        return id;
    }

    public void set_id(int id){
        this.id = id;
    }

    public int get_id_resto(){
        return id_resto;
    }

    public void set_id_resto(int id){
        this.id_resto = id;
    }

    public String get_content(){
        return Contain;
    }

    public void set_content(String Contain){
        this.Contain = Contain;
    }

    public int get_id_user(){
        return id_user;
    }

    public void set_id_user(int id){
        this.id_user = id;
    }

}
