package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggle;
    private TextView solution;
    private Spinner spin;
    private CheckBox choice;
    private CheckBox choice2;
    private ImageView picture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        solution = findViewById(R.id.textView5);
        toggle = findViewById(R.id.toggleButton);
        spin = findViewById(R.id.spinner);
        picture = findViewById(R.id.imageView);
        choice = findViewById(R.id.checkBox);
        choice2 = findViewById(R.id.checkBox2);

    }

    public void mentalHealth(View view) {
        EditText name = findViewById(R.id.editText);
        String nameValue = name.getText().toString();
        ImageView pic = findViewById(R.id.imageView);
        pic.setImageResource(R.drawable.noun_mental_health_66159);
        //toggle button
        boolean location = toggle.isChecked();

        //spinner
        String emo = String.valueOf(spin.getSelectedItem());

        //check boxes
        Boolean family = choice.isChecked();
        Boolean friend = choice2.isChecked();


        String finalresult;

        //keep count
        int trackermood = 0;


        //spinner

        if (!location) {
            trackermood = trackermood - 1;
        } else {
            trackermood = trackermood +1;
        }

        switch (emo) {
            case "angry":
                trackermood = trackermood + 1;

                break;
            case "tired":
                trackermood = trackermood + 2;
                Context context = getApplicationContext();
                CharSequence text = "One need 8 hours of sleep";
                int another = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, another);
                toast.show();

                break;
            case "stressed":
                trackermood = trackermood + 3;

                break;
            default:
                trackermood = trackermood + 0;

        }

        if(!family && !friend)
        {
            trackermood = trackermood + 3;
            //toast
            Context context = getApplicationContext();
            CharSequence text = "Please consider reaching out to a crisis hotline";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else if(family || friend){
            trackermood = trackermood + 1;
        }
        else {
            trackermood = trackermood - 1;
        }

        if (trackermood >= 3 && trackermood <=6 ) { //3 4 5 6
            finalresult = "I strongly recommend you take a day off.";
        } else if (trackermood > 6) { //7
            finalresult = "I strongly recommend you reach out to someone for help.";
        } else { //0 1 2
            finalresult = "just keep eating and sleeping. You are doing great!";
        }
       // System.out.println(trackermood);


            //text view

        solution.setText(nameValue+" "+finalresult + " Good luck with everything!");

    }
}


