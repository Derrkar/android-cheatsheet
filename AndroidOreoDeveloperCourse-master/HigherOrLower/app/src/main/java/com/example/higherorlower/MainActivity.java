package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    String message;

    public void generateRandomNumber() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(20) +1;
    }

    public void onClick(View view) {

        EditText editText = (EditText) findViewById(R.id.editText2);
        int guessValue = Integer.parseInt(editText.getText().toString());

        if(guessValue > randomNumber) {
            message = "Lower!";
        } else if(guessValue < randomNumber) {
            message = "Higher!";
        } else{
            message = "U got it!";
            generateRandomNumber();
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNumber();
    }
}
