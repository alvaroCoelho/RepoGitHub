package com.example.repogithub.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.repogithub.R;
import com.example.repogithub.domain.GitHubRepo;
import com.example.repogithub.ui.viewmodel.GitHubRepoViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GitHubRepoViewModel gitHubRepoViewModel;
    private EditText editTextSearch;
    private Button buttonSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSearch = findViewById(R.id.editTextSearch);
        buttonSearch = findViewById(R.id.buttonSearch);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        gitHubRepoViewModel = new GitHubRepoViewModel();
        gitHubRepoViewModel.getAll();


        gitHubRepoViewModel.repos.observe(this,gitHubRepos -> {
            recyclerView.setAdapter(new GitHubAdapter(gitHubRepos));

        });

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gitHubRepoViewModel.searchByName(editTextSearch.getText().toString());



            }
        });




    }
}