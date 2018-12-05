package com.example.reijn.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements MenuRequest.Callback{
    MenuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        String categorie = (String) intent.getSerializableExtra("categorie");
        MenuRequest x = new MenuRequest(this);
        x.getMenus(this,categorie);

    }

    @Override
    public void gotMenus(ArrayList<MenuItem> categories) {
        adapter = new MenuAdapter(this, categories);
        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new OnItemClickListener());
    }

    @Override
    public void gotMenusError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public class OnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            MenuItem categorie = (MenuItem) parent.getItemAtPosition(position);
            Intent intent = new Intent(MenuActivity.this, DetailActivity.class);
            intent.putExtra("name", categorie.getName());
            intent.putExtra("description", categorie.getDescription());
            intent.putExtra("url", categorie.getImageurl());
            intent.putExtra("price", categorie.getPrice());
            startActivity(intent);
        }
    }
}
