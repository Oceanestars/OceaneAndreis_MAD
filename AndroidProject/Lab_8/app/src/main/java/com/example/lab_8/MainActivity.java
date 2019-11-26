package com.example.lab_8;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Spinner crowdSpinner;
    private Website newWebsite = new Website();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crowdSpinner=findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        //create listener
        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findEntertainment(v);
            }
        };
        //add listener to button
        button.setOnClickListener(onclick);
    }

    private void findEntertainment(View view){
        Integer crowd = crowdSpinner.getSelectedItemPosition();
        newWebsite.setEntertainmentName(crowd);
        String EntertainmentActivity = newWebsite.getEntertainmentName();
        String EntertainmentActURL = newWebsite.getEntertainmentURL();
        Log.i("entertainment suggested", EntertainmentActivity);
        Log.i("url suggested", EntertainmentActURL);

        Intent intent = new Intent(this,Main2_Activity.class);
        intent.putExtra("EntertainmentName", EntertainmentActivity);
        intent.putExtra("EntertainmentURL", EntertainmentActURL);
        startActivity(intent);
    }
}
