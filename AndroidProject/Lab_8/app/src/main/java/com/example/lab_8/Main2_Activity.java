
package com.example.lab_8;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import android.content.Intent;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Main2_Activity extends AppCompatActivity {
    private String EntertainmentName;
    private String EntertainmentURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebSite(view);
            }
        });

        Intent intent = getIntent();
        EntertainmentName = intent.getStringExtra("EntertainmentName");
        EntertainmentURL = intent.getStringExtra("EntertainmentURL");
        Log.i("entertainment received", EntertainmentName);
        Log.i("url received", EntertainmentURL);

        //update text view
        TextView messageView = findViewById(R.id.textView2);
        messageView.setText("You should check out " + EntertainmentName);
    }

    private void loadWebSite(View view){
        Intent intent = new Intent((Intent.ACTION_VIEW));
        intent.setData(Uri.parse(EntertainmentURL));
        startActivity(intent);
    }

}
