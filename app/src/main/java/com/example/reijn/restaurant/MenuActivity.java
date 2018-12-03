package com.example.reijn.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements MenuRequest.Callback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        String categorie = (String) intent.getSerializableExtra("categorie");

    }

    @Override
    public void gotMenus(ArrayList<String> categories) {

    }

    @Override
    public void gotMenusError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
