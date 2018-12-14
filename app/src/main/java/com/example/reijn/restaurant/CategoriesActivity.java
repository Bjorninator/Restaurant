package com.example.reijn.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity implements CategoriesRequest.Callback {
     CategorieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        CategoriesRequest x = new CategoriesRequest(this);
        x.getCategories(this);
        Toast.makeText(this,"started", Toast.LENGTH_SHORT).show();

    }
    @Override
    public void gotCategories(ArrayList<String> categories) {
        adapter = new CategorieAdapter(this,R.layout.categorie_row, categories);
        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new OnItemClickListener());

    }

    @Override
    public void gotCategoriesError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public class OnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String categorie = (String) parent.getItemAtPosition(position);
            Intent intent = new Intent(CategoriesActivity.this, MenuActivity.class);
            intent.putExtra("categorie", categorie);
            startActivity(intent);
        }
    }

}
