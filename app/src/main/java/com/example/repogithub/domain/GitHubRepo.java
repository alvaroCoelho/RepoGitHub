package com.example.repogithub.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GitHubRepo {

    @SerializedName("name")
     public String name;

    @SerializedName("owner")
    public Owner owner;

    @SerializedName("description")
    public String description;


}
