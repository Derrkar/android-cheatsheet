package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view) {
        Log.i("Info", "Tapped");
        ImageView bartImageView = (ImageView) findViewById(R.id.bartImageView);
        ImageView homerImageView = (ImageView) findViewById(R.id.homerImageView);
        bartImageView.animate().translationYBy(1000).setDuration(2000);
        bartImageView.animate().translationXBy(-1000).setDuration(20000);
        bartImageView.animate().rotation(1800).alpha(0).setDuration(10000);
        bartImageView.animate().scaleX(0.5f).scaleY(0.5f).setDuration(5000);

//        if(bartImageView.getAlpha() == 1) {
//            bartImageView.animate().alpha(0).setDuration(2000);
//            homerImageView.animate().alpha(1).setDuration(2000);
//        } else { homerImageView.animate().alpha(0).setDuration(2000);
//            bartImageView.animate().alpha(1).setDuration(2000);
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView bartImageView = (ImageView) findViewById(R.id.bartImageView);
        bartImageView.animate().translationXBy(-1000);
        // the same as //
        bartImageView.setX(-1000);
        bartImageView.animate().translationXBy(1000).rotation(3600).setDuration(10000);
    }
}
