package com.example.showhide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewThing;

    public void show(View view) {
        textViewThing.setVisibility(View.VISIBLE);
    }

    public void hide(View view) {
        textViewThing.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewThing = findViewById(R.id.textViewThing);
    }
}
