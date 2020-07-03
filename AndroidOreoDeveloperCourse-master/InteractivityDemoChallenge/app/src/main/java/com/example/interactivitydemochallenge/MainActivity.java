package com.example.interactivitydemochallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view) {

        EditText nameEditText = (EditText) findViewById(R.id.nameEditText4);

        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText3);

        Log.i("Info", "It worked");
        Log.i("Name of User", nameEditText.getText().toString());
        Log.i("Password of User", passwordEditText.getText().toString());
        Toast.makeText(this, "hi there!", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
