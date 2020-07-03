package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convert(View view) {
        EditText amountEditText = (EditText) findViewById(R.id.amountEditText);
        String amountInPounds = amountEditText.getText().toString();
        double dollar = Double.parseDouble(amountInPounds);
        dollar = dollar * 1.3;
        String amountInDollars = String.format("%.2f", dollar);
        Toast.makeText(this, "£" + amountInPounds + " is $" + amountInDollars, Toast.LENGTH_LONG).show();;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
