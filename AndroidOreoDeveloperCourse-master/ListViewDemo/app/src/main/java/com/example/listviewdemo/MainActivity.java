package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        final ListView myListView = (ListView) findViewById(R.id.myListView);
//        final ArrayList<String> myFamily = new ArrayList<>();
//        myFamily.add("Misha");
//        myFamily.add("Jek");
//        myFamily.add("Anna");
//        myFamily.add("Vova");
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myFamily);
//        myListView.setAdapter(arrayAdapter);
//        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Log.i( "Person selected ", myFamily.get(position));
//
//            }
//        });
        ListView myListView = (ListView) findViewById(R.id.myListView);
        final ArrayList<String> friendList = new ArrayList<>();
        friendList.add("Gora");
        friendList.add("Grisha");
        friendList.add("Vasya");
        friendList.add("Vanya");
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, friendList);
        myListView.setAdapter(myAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Selected friend name is", friendList.get(position));
                Toast.makeText(getApplicationContext(), "Selected friend name is " + friendList.get(position), Toast.LENGTH_LONG).show();

            }
        });
    }
}
