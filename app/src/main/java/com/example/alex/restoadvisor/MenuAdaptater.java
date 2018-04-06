package com.example.alex.restoadvisor;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MenuAdaptater extends BaseAdapter {
    private Context context;
    private List<Menu> menus;

    public MenuAdaptater(Context context, List<Menu> menus) {
        this.context = context;
        this.menus = menus;
    }

    @Override
    public int getCount() {
        return menus.size();
    }

    @Override
    public Object getItem(int position) {
        return menus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.menu_row, null);
        }

        Menu menu = menus.get(position);


        TextView textViewRestaurantName = (TextView) convertView.findViewById(R.id.menu_cont);
        TextView textViewRestaurantId = (TextView) convertView.findViewById(R.id.menu_id);

        textViewRestaurantName.setTextColor(Color.parseColor("#FFFFFF"));
        textViewRestaurantId.setTextColor(Color.parseColor("#FFFFFF"));

        textViewRestaurantName.setText(menu.get_content());
        textViewRestaurantId.setId(menu.get_id());

        return convertView;
    }
}
