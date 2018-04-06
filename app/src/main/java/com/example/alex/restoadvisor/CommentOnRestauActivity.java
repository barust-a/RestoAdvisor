package com.example.alex.restoadvisor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.alex.restoadvisor.MainActivity.restaurantApi;

public class CommentOnRestauActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.restoadvisor.MESSAGE";
    private List<Comment> comments;
    private final String TAG = "MainActivity";
    public ListView myListView;
    public CommentAdapter MyListViewAdaptater;
    public static Integer  id;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_on_restau);
        comments = new ArrayList<>();
        myListView = (ListView) findViewById(R.id.ComView);
        this.MyListViewAdaptater = new CommentAdapter(getApplicationContext(), comments);
        this.myListView.setAdapter(MyListViewAdaptater);
        getAvisViaAPI();
    }

    private void getAvisViaAPI() {
        String idresto = getIntent().getStringExtra("id");
        id = Integer.parseInt(idresto);
        restaurantApi.getAvisByResto(id).enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                Log.d(TAG, "onResponse:");
                List<Comment> commentList;
                commentList = response.body();

                if (commentList != null) {
                    for (Comment comment: commentList) {
                        if (comment != null) {
                            Log.e(TAG, "restaurant name is " + comment.getComment());
                            comments.add(comment);
                        }
                    }
                    MyListViewAdaptater.notifyDataSetChanged();
                } else {
                    Log.d(TAG, "onresponse: restaurant is empty " + response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Log.e(TAG, "onfailure: " + t.getMessage());
            }
        });
    }
}
