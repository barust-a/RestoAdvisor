package com.example.alex.restoadvisor;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyListViewAdaptater extends BaseAdapter {

    private Context context;
    private List<Restaurant> restaurantlist;

    public MyListViewAdaptater(Context context, List<Restaurant> restaurantlist) {
        this.context = context;
        this.restaurantlist = restaurantlist;
    }

    @Override
    public int getCount() {
        return restaurantlist.size();
    }

    @Override
    public Object getItem(int position) {
        return restaurantlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.restaurant_row, null);
        }

        Restaurant restaurant = restaurantlist.get(position);


        TextView textViewRestaurantName = (TextView) convertView.findViewById(R.id.restaurant_name);
        TextView textViewRestaurantId = (TextView) convertView.findViewById(R.id.restaurant_id);

        textViewRestaurantName.setTextColor(Color.parseColor("#FFFFFF"));
        textViewRestaurantId.setTextColor(Color.parseColor("#FFFFFF"));

        textViewRestaurantName.setText(restaurant.getName());
        textViewRestaurantId.setId(restaurant.getId());

        return convertView;
    }
}