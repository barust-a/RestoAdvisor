package com.example.alex.restoadvisor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.alex.restoadvisor.MainActivity.restaurantApi;
import static com.example.alex.restoadvisor.MainActivity.token;

public class PostCommentActivity extends AppCompatActivity {
    private final String TAG = "postcomment";
    private Comment comment = new Comment();
    private Integer rate;
    private String mycomment;

    private Integer idresto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_comment);

        setcommentrate();
    }


public void setcommentrate() {
  //  RatingBar ratebar = findViewById(R.id.rateview);

//   rate = ratebar.getNumStars();
rate = 4;

    EditText editText = (EditText) findViewById(R.id.commentview);
    mycomment = editText.getText().toString();
    Log.e("leaelihfboaiherbfresto", "ce genre d'erreur" + mycomment );


}

    void check() {
        final TextView text = (TextView) findViewById(R.id.check);
        text.setText("votre commentaire a été posté");
    }

    public void postComment(View view) {
        String sidresto = getIntent().getStringExtra("id");
        idresto = Integer.parseInt(sidresto);
        Log.e("leaelihfboaiherbfresto", "ce genre d'erreur" + idresto + mycomment + rate );
        restaurantApi.postcomment(idresto, mycomment, rate, "Bearer "  + token ).enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call, Response<Comment> response) {
                Log.d(TAG, "onResponse:");
                comment = response.body();
                if (comment != null) {
                    Log.d(TAG, "onResponse:" + comment);
                    check();
                } else {
                }
            }

            @Override
            public void onFailure(Call<Comment> call, Throwable t) {
                Log.e(TAG, "onFailur: " + t.getMessage());
            }
        });
    }

}
