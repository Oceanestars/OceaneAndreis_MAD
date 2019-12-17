package com.example.logos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    private String ActivityName;
    private String ActivityURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
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
        ActivityName = intent.getStringExtra("ActivityName");
        ActivityURL = intent.getStringExtra("ActivityURL");
//        Log.i("entertainment received", ActivityName);
//        Log.i("url received", ActivityURL);

    //update text view
    TextView messageView = findViewById(R.id.textView10);
    messageView.setText("You should check out " + ActivityName);
}

    private void loadWebSite(View view){
        Intent intent = new Intent((Intent.ACTION_VIEW));
        intent.setData(Uri.parse(ActivityURL));
        startActivity(intent);
    }
}