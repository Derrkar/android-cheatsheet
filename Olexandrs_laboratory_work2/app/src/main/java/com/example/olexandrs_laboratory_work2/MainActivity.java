package com.example.olexandrs_laboratory_work2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = (TextView) findViewById(R.id.textView2);
        etInput = (EditText) findViewById(R.id.editText2);
        bControl = (Button) findViewById(R.id.button);
        guess = (int) (Math.random() * 100);
        gameFinished = false;

    }

    public void onClick(View view) {

        if (gameFinished) {
            guess = (int) (Math.random() * 100);
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        } else {
            String text = etInput.getText().toString();
            if (text.length() == 0) {
                return;
            }
            int inp = Integer.parseInt(text);
            if (inp > guess) {
                tvInfo.setText(getResources().getString(R.string.ahead));
            }
            if (inp < guess) {
                tvInfo.setText(getResources().getString(R.string.behind));
            }
            if (inp == guess) {
                tvInfo.setText(getResources().getString(R.string.hit));
                bControl.setText(getResources().getString(R.string.play_more));
                gameFinished = true;
            }
        }
        etInput.setText("");

    }
}
        /*String text = etInput.getText().toString();
       if (text.length() == 0) {
            return;
        }
        int inp = Integer.parseInt(text);
        if (!gameFinished) {
            if (inp > guess) {
                tvInfo.setText(getResources().getString(R.string.ahead));
            }
            if (inp < guess) {
                tvInfo.setText(getResources().getString(R.string.behind));
            }
            if (inp == guess) {
                tvInfo.setText(getResources().getString(R.string.hit));
                bControl.setText(getResources().getString(R.string.play_more));
                gameFinished = true;
            }
        } else {
            guess = (int) (Math.random() * 100);
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        }*/


