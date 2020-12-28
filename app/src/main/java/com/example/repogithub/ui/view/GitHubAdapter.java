package com.example.repogithub.ui.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repogithub.R;
import com.example.repogithub.domain.GitHubRepo;

import java.util.List;

public class GitHubAdapter extends RecyclerView.Adapter<GitHubAdapter.ListReposViewHolder> {

    public GitHubAdapter(List<GitHubRepo> gitHubRepoList) {
        this.gitHubRepoList = gitHubRepoList;
    }

    private List<GitHubRepo> gitHubRepoList;
    private GitHubRepo gitHubRepo;

    @NonNull
    @Override
    public ListReposViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo, parent, false);
        return new ListReposViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListReposViewHolder holder, int position) {
            holder.textViewNameRepo.setText(gitHubRepoList.get(position).name);
            holder.textViewUserNameOwner.setText(gitHubRepoList.get(position).owner.login);
            holder.gitHubRepo = gitHubRepoList.get(position);


           }

    @Override
    public int getItemCount() {
        return (gitHubRepoList != null && gitHubRepoList.size() > 0) ? gitHubRepoList.size() : 0;
    }

    static class ListReposViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewNameRepo;
        private TextView textViewUserNameOwner;
        private GitHubRepo gitHubRepo;



        public ListReposViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNameRepo = itemView.findViewById(R.id.textViewNameRepo);
            textViewUserNameOwner = itemView.findViewById(R.id.textViewUserNameOwner);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    intent.putExtra("avatar",gitHubRepo.owner.avatar);
                    intent.putExtra("userName",gitHubRepo.owner.login);
                    intent.putExtra("repo",gitHubRepo.name);
                    intent.putExtra("description",gitHubRepo.description);
                    v.getContext().startActivity(intent);


                }
            });


        }



    }



}
