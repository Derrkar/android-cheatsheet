package com.example.zappycode.whatstheweather;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;



public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView resultTextView;

    public void getWeather(View view) {
        try {
        DownloadTask task = new DownloadTask();
        task.execute("http://api.weatherstack.com/current?access_key=19fb2fb179010b099907dbab0b747464&query=" + editText.getText().toString());
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "You lost your internet connection!!!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        resultTextView = findViewById(R.id.resultTextView);
    }



    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
                return result;

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "City doesn't exist, try again!", Toast.LENGTH_SHORT).show();
                return "empty";
            }

//            } catch (MalformedURLException e) {
//                Toast.makeText(getApplicationContext(), "You lost your internet connection!!!", Toast.LENGTH_LONG).show();
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                Toast.makeText(getApplicationContext(), "You lost your internet connection!!!", Toast.LENGTH_LONG).show();
//                return null;
//            }

//            } catch (IOException e) {
//                Toast.makeText(getApplicationContext(), "You lost your internet connection!!!", Toast.LENGTH_LONG).show();
//                e.printStackTrace();
//                return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);

                String weatherInfo = jsonObject.getString("current");
                String location = jsonObject.getString("location");
                JSONObject weatherInfoJson = new JSONObject(weatherInfo);
                JSONObject locationJson = new JSONObject(location);
                String message = "";
                String observation_time = weatherInfoJson.getString("observation_time");
                String temperature = weatherInfoJson.getString("temperature");
                String weather_descriptions = weatherInfoJson.getString("weather_descriptions");
                String localtime = locationJson.getString("localtime");
                String region = locationJson.getString("region");
                String country = locationJson.getString("country");
                String timezone_id = locationJson.getString("timezone_id");

                if (!temperature.equals("") && !weather_descriptions.equals("")) {
                    message += "timezone_id: " + timezone_id + "\r\n" + "country: " + country + "\r\n" + "region: " + region + "\r\n" + "localtime: " + localtime + "\r\n" + "temperature: " + temperature + "\r\n" + "weather_descriptions: " + weather_descriptions + "\r\n" + "observation_time: " + observation_time;
                }

                if (!message.equals("")) {
                    resultTextView.setText(message);
                } else {
                    Toast.makeText(getApplicationContext(), "City doesn't exist, try again!", Toast.LENGTH_SHORT).show();
                }

            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "City doesn't exist, try again!", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }

}
