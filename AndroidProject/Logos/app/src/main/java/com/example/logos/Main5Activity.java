package com.example.logos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Main5Activity extends AppCompatActivity {

    private String ActivityName;
    private String ActivityURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
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
        ImageView picture = findViewById(R.id.imageView);
        System.out.println("Activity Name"+ ActivityName);

        boolean areTwoStringsEqual = ActivityName.equals("how to invest your money");
        boolean areTwoStringsEqual2 = ActivityName.equals("many ways to treat yourself");
        boolean areTwoStringsEqual3 = ActivityName.equals("how to invest your money");
        if(areTwoStringsEqual)
        {
            picture.setImageResource(R.drawable.savemoney);
        }
        else if (areTwoStringsEqual2){
            picture.setImageResource(R.drawable.spa);
            System.out.println("Yello"+ ActivityName);

        }
        else{
            picture.setImageResource(R.drawable.money);

        }
    }

    private void loadWebSite(View view){
        Intent intent = new Intent((Intent.ACTION_VIEW));
        intent.setData(Uri.parse(ActivityURL));
        startActivity(intent);
    }
}
