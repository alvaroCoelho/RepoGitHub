package com.example.repogithub.ui.view;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.repogithub.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageViewAvatar;
    private TextView textViewUserNameOwner, textViewNameRepo,textViewdescription,textViewName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        imageViewAvatar = findViewById(R.id.imageViewAvatar);
        textViewUserNameOwner = findViewById(R.id.textViewUserNameOwner);
        textViewNameRepo = findViewById(R.id.textViewNameRepo);
        textViewdescription = findViewById(R.id.textViewdescription);
        textViewName = findViewById(R.id.textViewName);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {

            Picasso.get().load(bundle.getString("avatar")).into(imageViewAvatar);
            textViewUserNameOwner.setText(bundle.getString("userName"));
            textViewNameRepo.setText(bundle.getString("repo"));
            textViewdescription.setText(bundle.getString("description"));
          }
        }




}

