package com.example.andreisfinal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private String ActivityName;
    private String ActivityURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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

        TextView messageView = findViewById(R.id.textView3);
        messageView.setText("You should check out " + ActivityName);
        ImageView picture = findViewById(R.id.imageView);

        picture.setImageResource(R.drawable.burrito);
    }


    private void loadWebSite(View view){
        Intent intent = new Intent((Intent.ACTION_VIEW));
        intent.setData(Uri.parse(ActivityURL));
        startActivity(intent);
    }

}
