package com.example.andreisfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button2;
    private Button button3;
    private CheckBox salsa;
    private CheckBox sourcream;
    private CheckBox cheese;
    private CheckBox guacamole;
    private ImageView picture;
    private MainChoice newWebsite = new MainChoice();
    private Spinner coolchoice;




    private RadioGroup food;

    private EditText editText1;
    //private TextView selection;

    private String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button3 = findViewById(R.id.button3); //more info
        button2 = findViewById(R.id.button2);//build
        editText1=findViewById(R.id.editText);//name input
        text = editText1.getText().toString();
        food = findViewById(R.id.radioGroup);
        picture = findViewById(R.id.imageView);
        salsa = findViewById(R.id.checkBox);
        sourcream = findViewById(R.id.checkBox2);
        cheese = findViewById(R.id.checkBox3);
        guacamole = findViewById(R.id.checkBox4);

        coolchoice = findViewById(R.id.spinner);
        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if(text.matches("")){
//                    //toast
//                    Context context = getApplicationContext();
//                    CharSequence textSequence = "Please enter an input and then click build";
//                    int duration = Toast.LENGTH_SHORT;
//
//                    Toast toast = Toast.makeText(context, textSequence, duration);
//                    toast.show();
//
//                }
//                else {
                PickRestaurant(v);
                // }
            }
        };
        //add listener to button
        button2.setOnClickListener(onClick);


        View.OnClickListener onClick2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                restchoice(v);

            }
        };
        //add listener to button
        button3.setOnClickListener(onClick2);

    }

    private void PickRestaurant(View view)
    {
        editText1=findViewById(R.id.editText);//name input
        text = editText1.getText().toString();
        TextView selection = findViewById(R.id.textView);
        int choice = food.getCheckedRadioButtonId();
        String foodholder="";
        System.out.println("Here");
        Boolean one = salsa.isChecked();
        Boolean two = sourcream.isChecked();
        Boolean three = cheese.isChecked();
        Boolean four = guacamole.isChecked();

        String toppings="";
//        String toppings2;
//        String toppings3;
//        String toppings4;


        if (choice == -1) {
            //toast
            Context context = getApplicationContext();
            CharSequence text = "Please select a cost level";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {

            if (choice == R.id.radioButton6) {
                foodholder = "Taco";
                System.out.println(foodholder);
                picture.setImageResource(R.drawable.taco);
            }
            else if(choice == R.id.radioButton7) {
                foodholder= "Burrito";
                picture.setImageResource(R.drawable.burrito);
            }

        }

//        String[]dataHolder= new String[4] ;

        if(one)
        {
            toppings ="salsa";
        }
        else if(two)
        {
//            toppings2="sour cream";
            toppings+=" sour cream";
        }
        else if(three)
        {
//            toppings3="cheese";
            toppings+=" cheese";
        }
        else{
//            toppings4="guacamole";
            toppings+=" guacamole";
        }




        selection.setText(text+" wants a "+ foodholder+"with "+ toppings);

    }


    private void restchoice(View view){

        String restType = String.valueOf(coolchoice.getSelectedItem());
        int choice;
        switch (restType) {
            case "cheap":
                choice = 1;
                break;
            case "moderate":
                choice = 2;
                break;
            case "expensive":
                choice = 3;
                break;
            default:
                choice = 0;
        }

        newWebsite.setName(choice);

        String WebActivity = newWebsite.getName();
        String WebUrl = newWebsite.getURL();


        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("ActivityName", WebActivity);
        intent.putExtra("ActivityURL", WebUrl);
        startActivity(intent);
    }
}
