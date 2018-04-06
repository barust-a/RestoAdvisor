package com.example.alex.restoadvisor;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AvisAdapteter extends BaseAdapter {
    private Context context;
    private List<Avis> avis;

    public AvisAdapteter(Context context, List<Avis> avis) {
        this.context = context;
        this.avis = avis;
    }

    @Override
    public int getCount() {
        return avis.size();
    }

    @Override
    public Object getItem(int position) {
        return avis.get(position);
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

        Avis avis1 = avis.get(position);


        TextView textViewRestaurantName = (TextView) convertView.findViewById(R.id.menu_cont);
        TextView textViewRestaurantId = (TextView) convertView.findViewById(R.id.menu_id);

        textViewRestaurantName.setTextColor(Color.parseColor("#FFFFFF"));
        textViewRestaurantId.setTextColor(Color.parseColor("#FFFFFF"));

        textViewRestaurantName.setText(avis1.get_content());
        textViewRestaurantId.setId(avis1.get_id());

        return convertView;
    }
}
