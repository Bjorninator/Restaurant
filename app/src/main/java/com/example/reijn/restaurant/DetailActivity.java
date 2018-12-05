package com.example.reijn.restaurant;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String name = (String) intent.getSerializableExtra("name");
        String description = (String) intent.getSerializableExtra("description");
        String url = (String) intent.getSerializableExtra("url");
        String price = (String) intent.getSerializableExtra("price");
        System.out.println(name);
        TextView namevak = findViewById(R.id.title1);
        TextView descriptionvak = findViewById(R.id.description1);
        ImageView view = findViewById(R.id.img);
        TextView pricevak = findViewById(R.id.price1);

        namevak.setText(name);
        descriptionvak.setText(description);
        pricevak.setText(price);
        Picasso.get().load(url).resize(350,350).error(R.drawable.octodab).into(view);


    }

}
