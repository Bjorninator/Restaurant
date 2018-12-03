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
    private ArrayList<String> list;
    private Callback menu;

    @Override
    public void onErrorResponse(VolleyError error) {
        menu.gotMenusError(error.getMessage());
    }

    @Override
    public void onResponse(JSONObject response) {
        try {
            JSONArray categories = response.getJSONArray("categories");
            list  = new ArrayList<String>();

            for (int i = 0; i < categories.length(); i++) {
                list.add(categories.getString(i));
            }
        }

        catch (JSONException e){
            System.out.println(e.getMessage());
        }
        menu.gotMenus(list);

    }

    public interface Callback {
        void gotMenus(ArrayList<String> categories);
        void gotMenusError(String message);
    }

    public MenuRequest(Context context){
        this.context = context;
    }
    void getMenus(Callback activity, String categories){
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("https://resto.mprog.nl/menu?category='"+categories+"'", null, this, this);
        queue.add(jsonObjectRequest);
        menu = activity;
    }
}
