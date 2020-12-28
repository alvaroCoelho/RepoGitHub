package com.example.repogithub.domain;

import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("login")
    public String login;

    @SerializedName("avatar_url")
    public  String avatar;
}
