package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saySushi(View view) {
        TextView sushText = findViewById(R.id.textView);
        EditText name = findViewById(R.id.editText);
        String nameValue = name.getText().toString();
        sushText.setText("Eat some sushi " + nameValue + "!");
        ImageView sush = findViewById(R.id.imageView);
        sush.setImageResource(R.drawable.sush);
    }
}
