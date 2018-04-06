package com.example.alex.restoadvisor;

import android.widget.BaseAdapter;
import android.content.Context;

import android.graphics.Color;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.BaseAdapter;

import android.widget.TextView;

import java.util.List;

public class CommentAdapter extends BaseAdapter{
    private Context context;

    private List<Comment> avis;

    public CommentAdapter(Context context, List<Comment> avis) {

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

            convertView = LayoutInflater.from(context).inflate(R.layout.comment_row, null);

        }

        Comment avis1 = avis.get(position);

        TextView textViewRestaurantName = (TextView) convertView.findViewById(R.id.comment_cont);

        TextView textViewRestaurantId = (TextView) convertView.findViewById(R.id.comment_id);

        textViewRestaurantName.setText(avis1.getComment());

        textViewRestaurantId.setId(avis1.getRate());

        return convertView;

    }
}
