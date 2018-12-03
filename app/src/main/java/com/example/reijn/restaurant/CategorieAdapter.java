package com.example.reijn.restaurant;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategorieAdapter extends ArrayAdapter<String> {

    private ArrayList<String> categorie;
    private Context context;

    public CategorieAdapter(@NonNull Context context, int resource,  ArrayList<String> objects) {
        super(context, resource, objects);
        this.categorie = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.categorie_row, parent, false);
        }
        TextView textvak = (TextView) convertView.findViewById(R.id.textView);
        String text = categorie.get(position);
        textvak.setText(text);

        return convertView;
    }
}
