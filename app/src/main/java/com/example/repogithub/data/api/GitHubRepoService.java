package com.example.repogithub.data.api;

import com.example.repogithub.domain.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GitHubRepoService {

@GET("/repositories")
    Call<List<GitHubRepo>> getRepos();


}
