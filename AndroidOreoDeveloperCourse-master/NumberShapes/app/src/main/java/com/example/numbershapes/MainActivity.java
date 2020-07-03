package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    Button button;

    class Number {
        int number;
        public boolean isTriangular() {
            int x = 0;
            int triangularNumber = 0;
            while(triangularNumber < number) {
                x++;
                triangularNumber = triangularNumber + x;
            }
            if(triangularNumber == number) {
                return true;
            } else {
                return false;
            }
        }
        public boolean isSquare() {
            double squareRoot = Math.sqrt(number);
            if(squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }
        }
    }


    public void onClick(View view) {
            EditText editText = (EditText) findViewById(R.id.editText);
            String message;

            if (editText.getText().toString().isEmpty()) {
                message = "please enter a number";
            } else {
                Number myNumber = new Number();
                myNumber.number = Integer.parseInt(editText.getText().toString());
                message = editText.getText().toString();
                if (myNumber.isSquare() && myNumber.isTriangular()) {
                    message = message + " is square and triangular";
                } else if (myNumber.isSquare()) {
                    message = message + " is square but not triangular";
                } else if (myNumber.isTriangular()) {
                    message = message + " is triangular but not square";
                } else {
                    message = message + " is not triangular nor square";
                }
            }
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        /*if(number == 0) {
            Toast.makeText(this, "Neither Triangular and Square", Toast.LENGTH_LONG).show();
        } if(number%3 == 0 && number%2 == 0) {
            Toast.makeText(this, "Triangular and Square", Toast.LENGTH_LONG).show();
        } else if(number%2 == 0) {
            Toast.makeText(this, "Square", Toast.LENGTH_LONG).show();
        } else if(number%3 == 0) {
            Toast.makeText(this, "Triangular", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Neither Triangular or Square", Toast.LENGTH_LONG).show();
        }*/

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        button = (Button) findViewById(R.id.button);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("button is clicke");
//            }
//        });
    }
}
