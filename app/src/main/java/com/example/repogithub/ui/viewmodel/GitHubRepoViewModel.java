package com.example.repogithub.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.example.repogithub.data.api.Client;
import com.example.repogithub.data.api.GitHubRepoService;
import com.example.repogithub.domain.GitHubRepo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitHubRepoViewModel {


    public MutableLiveData<List<GitHubRepo>> repos = new MutableLiveData<List<GitHubRepo>>();
    private Client client = new Client();;

    public void getAll() {

        try {

            GitHubRepoService apiGitHubRepoService = client.getClient().create(GitHubRepoService.class);
            Call<List<GitHubRepo>> call = apiGitHubRepoService.getRepos();
            call.enqueue(new Callback<List<GitHubRepo>>() {
                @Override
                public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                    if (response.isSuccessful()) {

                        repos.setValue(response.body());


                    }

                }

                @Override
                public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

                }


            });

        } catch (Exception e) {

        }


    }

 public void searchByName(String name){

     try {

         GitHubRepoService apiGitHubRepoService = client.getClient().create(GitHubRepoService.class);
         Call<List<GitHubRepo>> call = apiGitHubRepoService.getRepos();
         call.enqueue(new Callback<List<GitHubRepo>>() {
             @Override
             public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                 if (response.isSuccessful()) {

                     for (int i = 0; i < response.body().size(); i++){
                         if(response.body().get(i).name.contains(name)){
                             List<GitHubRepo> list = new ArrayList<GitHubRepo>();
                             list.add(response.body().get(i));
                             repos.setValue(list);
                         }

                     }




                 }

             }

             @Override
             public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

             }


         });

     } catch (Exception e) {

     }


 }

}


