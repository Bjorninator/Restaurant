package com.example.reijn.restaurant;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MenuRequest implements Response.Listener<JSONObject>, Response.ErrorListener {
    private Context context;
    private ArrayList<MenuItem> list;
    private Callback menu;

    @Override
    public void onErrorResponse(VolleyError error) {
        menu.gotMenusError(error.getMessage());
    }

    @Override
    public void onResponse(JSONObject response) {
        try {
            JSONArray categories = response.getJSONArray("items");
            list  = new ArrayList<MenuItem>();

            for (int i = 0; i < categories.length(); i++) {
                JSONObject object = categories.getJSONObject(i);
                MenuItem item = new MenuItem(object.getString("price"),object.getString("name"),
                        object.getString("description"),object.getString("image_url"),object.getString("category"));
                System.out.println(item.getName());
                list.add(item);
            }
        }

        catch (JSONException e){
            System.out.println(e.getMessage());
        }
        menu.gotMenus(list);
    }

    public interface Callback {
        void gotMenus(ArrayList<MenuItem> categories);
        void gotMenusError(String message);
    }

    public MenuRequest(Context context){
        this.context = context;

    }
    void getMenus(Callback activity, String categories){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://resto.mprog.nl/menu?category=" + categories;
        System.out.println(url);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);
        menu = activity;
    }
}
