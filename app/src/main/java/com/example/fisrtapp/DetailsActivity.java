package com.example.fisrtapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView Name, Description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle bundle = getIntent().getExtras();


        Name = findViewById(R.id.textTitle);
        Description = findViewById(R.id.description);
        imageView = findViewById(R.id.image);


        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
//        int images = getIntent().getIntExtra("image", 0);

        if (bundle != null) {
            String image = bundle.getString("image");
            Glide.with(DetailsActivity.this)
                    .load(image)
                    .placeholder(R.drawable.pic1)
                    .into(imageView);
        }

        Name.setText(title);
        Description.setText(description);
//            imageView.setImageResource(images);


    }
}
