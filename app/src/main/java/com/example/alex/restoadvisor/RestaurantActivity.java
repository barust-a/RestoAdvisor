package com.example.alex.restoadvisor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.alex.restoadvisor.MainActivity.token;

public class RestaurantActivity extends AppCompatActivity {
    private String idresto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);


        Button postComment = (Button) findViewById(R.id.postcomment);
        if (token == null) {
            postComment.setVisibility(View.GONE);
        }

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        String id = extras.getString("id");
        String phone = extras.getString("phone");
        String opentime = extras.getString("opentime");
        String closetime = extras.getString("closetime");
        String rate = extras.getString("rate");
        String description = extras.getString("description");
        String localisation = extras.getString("localisation");
        idresto = id;


        //fillTextView
        TextView Nameview = (TextView) findViewById(R.id.nameview);
        Nameview.setText(name);
        TextView Idview = (TextView) findViewById(R.id.idview);
        Idview.setText(id);
        TextView Phoneview = (TextView) findViewById(R.id.phoneview);
        Phoneview.setText(phone);
        TextView Openview = (TextView) findViewById(R.id.opentimeview);
        Openview.setText(opentime);
        TextView closeview = (TextView) findViewById(R.id.closetimeview);
        closeview.setText(closetime);
        TextView Rateview = (TextView) findViewById(R.id.rateview);
        Rateview.setText(rate);
        TextView descview = (TextView) findViewById(R.id.descriptionview);
        descview.setText(description);
        TextView Localview = (TextView) findViewById(R.id.localisationview);
        Localview.setText(localisation);
    }

    public void PostComment(View view) {
        Intent intent = new Intent(this, PostCommentActivity.class);
        intent.putExtra("id", idresto);
        startActivity(intent);
    }
}
