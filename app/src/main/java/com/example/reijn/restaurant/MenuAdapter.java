package com.example.reijn.restaurant;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MenuAdapter extends ArrayAdapter<MenuItem>{
    private ArrayList<MenuItem> menu;
    ImageView image;

    public MenuAdapter(@NonNull Context context, @NonNull ArrayList<MenuItem> objects) {
        super(context, R.layout.activity_menu, objects);
        this.menu = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_row, parent, false);
        }

        TextView name = convertView.findViewById(R.id.desciption);
        image = convertView.findViewById(R.id.imageView2);
        TextView price = convertView.findViewById(R.id.price);

        MenuItem menuItem = menu.get(position);
        String nametext= menuItem.getName();
        String pricetext = menuItem.getPrice();
        String urltext = menuItem.getImageurl();

        name.setText(nametext);
        price.setText("$" + pricetext);

        Picasso.get()
                .load(urltext).resize(350,350)
                .error(R.drawable.octodab)
                .into(image);

        return convertView;

    }
}