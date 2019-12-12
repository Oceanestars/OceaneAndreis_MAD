package com.example.logos;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

//https://weeklycoding.com/mpandroidchart-documentation/getting-started/
//https://stackoverflow.com/questions/16769654/how-to-use-onsaveinstancestate-and-onrestoreinstancestate
//https://stackoverflow.com/questions/6290531/check-if-edittext-is-empty


public class MainActivity extends AppCompatActivity {

    private Button button2;
    private Button button;
    private MoneyChoice newWebsite = new MoneyChoice();
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;
    private EditText editText7;
    private String value_container;
    private String value_container2;
    private String value_container3;
    private String value_container4;
    private String value_container5;
    private String value_container6;
    private String value_container7;
    private String text, text2, text3, text4, text5, text6, text7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("1");
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        editText1=findViewById(R.id.edittext1);
        editText2=findViewById(R.id.edittext2);
        editText3=findViewById(R.id.editText3);
        editText4=findViewById(R.id.editText4);
        editText5=findViewById(R.id.editText5);
        editText6=findViewById(R.id.editText6);
        editText7=findViewById(R.id.editText7);

        //This needs to be here for the scenario where the user wants
        //to rotate the device without having entered anything
        text = editText1.getText().toString();
        text2 = editText2.getText().toString();
        text3 = editText3.getText().toString();
        text4 = editText4.getText().toString();
        text5 = editText5.getText().toString();
        text6 = editText6.getText().toString();
        text7 = editText7.getText().toString();

        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("2");

                //This needs to be here otherwise the app crashes in certain scenarios
                // This is to avoid the empty string error
                text = editText1.getText().toString();
                text2 = editText2.getText().toString();
                text3 = editText3.getText().toString();
                text4 = editText4.getText().toString();
                text5 = editText5.getText().toString();
                text6 = editText6.getText().toString();
                text7 = editText7.getText().toString();

                //don't need text 7 in this if statement since text 7 is independent from the pie chart value
                if(text.matches("") || text2.matches("") || text3.matches("") || text4.matches("") || text5.matches("") || text6.matches("") ){
                    //toast
                    Context context = getApplicationContext();
                    CharSequence textSequence = "Please enter an input";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, textSequence, duration);
                    toast.show();

                }
                else{
                    System.out.println("3");
                    PieChartFunc();
                }

            }
        };
        //add listener to button
        button.setOnClickListener(onclick);

        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BudgetManager(v);
            }
        };
        //add listener to button
        button2.setOnClickListener(onClick);

        if (savedInstanceState != null) {
            System.out.println("4");

            //This if statement was require because if the user didn't input anything in the
            // edit text and tried to rotate it the app would crash.
            //I assumed it crashed because it tried to save nothing
            // So I just created a condition where it wouldn't save anything

            if(text.matches("") || text2.matches("") || text3.matches("") || text4.matches("") || text5.matches("") || text6.matches("") || text7.matches("")) {

                System.out.println("Everything is empty");
            }
           else {
                value_container = savedInstanceState.getString("input1");
                editText1.setText(value_container);

                value_container2 = savedInstanceState.getString("input2");
                editText2.setText(value_container2);

                value_container3 = savedInstanceState.getString("input3");
                editText3.setText(value_container3);

                value_container4 = savedInstanceState.getString("input4");
                editText4.setText(value_container4);

                value_container5 = savedInstanceState.getString("input5");
                editText5.setText(value_container5);

                value_container6 = savedInstanceState.getString("input6");
                editText6.setText(value_container6);

                value_container7 = savedInstanceState.getString("input7");
                editText7.setText(value_container7);
                PieChartFunc();
            }

        }


    }

    //https://weeklycoding.com/mpandroidchart-documentation/getting-started/
    private void PieChartFunc(){
        //If this isn't here it'll crash when I tried to call piechartfunc in onsavedinstance
        text = editText1.getText().toString();
        text2 = editText2.getText().toString();
        text3 = editText3.getText().toString();
        text4 = editText4.getText().toString();
        text5 = editText5.getText().toString();
        text6 = editText6.getText().toString();
        text7 = editText7.getText().toString();
//        System.out.println("Inside Pie chart 5");
//        System.out.println("Inside Pie chart 5:"+ text);
//        System.out.println("Inside Pie chart 5:"+ text2);
//        System.out.println("Inside Pie chart 5:"+ text3);
//        System.out.println("Inside Pie chart 5:"+ text4);

        //initialize our empty arrays
        String[] dataHolder= new String[3] ;
        float[] money = new float[3];

        //grab the values from the user

        value_container= text;
        value_container2=text2;
        value_container3=text3;
        value_container4=text4;
        value_container5=text5;
        value_container6=text6;

        int number = Integer.parseInt(editText2.getText().toString());

        int number2 = Integer.parseInt(editText4.getText().toString());

        int number3 = Integer.parseInt(editText6.getText().toString());


        //Populate our arrays
        dataHolder[0]=text;
        dataHolder[1]=text3;
        dataHolder[2]=text5;

        money[0]= number;
        money[1]= number2;
        money[2]= number3;


        List<PieEntry> pieEntries = new ArrayList<>();
        for (int i = 0; i<dataHolder.length;i++){
            pieEntries.add(new PieEntry(money[i],dataHolder[i]));
        }

        PieDataSet dataSet = new PieDataSet(pieEntries, "$");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData(dataSet);
        //get chart
        PieChart chart = (PieChart) findViewById(R.id.chart);
        chart.setData(data);
        chart.getDescription().setText("Logos");
        chart.animateY(1000);
        chart.invalidate();
    }


    private void BudgetManager(View view){

        //This needs to be here otherwise the app crashes in certain scenarios
        // This is to avoid the empty string error
        //Budget Manager is called when I open the new activity

        text = editText1.getText().toString();
        text2 = editText2.getText().toString();
        text3 = editText3.getText().toString();
        text4 = editText4.getText().toString();
        text5 = editText5.getText().toString();
        text6 = editText6.getText().toString();
        text7 = editText7.getText().toString();
        System.out.println("Inside Budget Manager:"+ text7);
        int choice = 0;

        int first_spending = Integer.parseInt(text2);
        int second_spending = Integer.parseInt(text4);
        int third_spending = Integer.parseInt(text6);
        int ideal_budget = Integer.parseInt(text7);

        int sum = first_spending+second_spending+third_spending;
        if(sum>ideal_budget) //over budget
        {
            choice=1;
        }
        else if(sum == ideal_budget) {
            choice=2;

        }
        else { //under budget
            choice=3;
        }


        newWebsite.setName(choice);

        String WebActivity = newWebsite.getName();
        String WebUrl = newWebsite.getURL();


        Intent intent = new Intent(this,Main4Activity.class);
        intent.putExtra("EntertainmentName", WebActivity);
        intent.putExtra("EntertainmentURL", WebUrl);
        startActivity(intent);
    }

   // https://stackoverflow.com/questions/16769654/how-to-use-onsaveinstancestate-and-onrestoreinstancestate

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        System.out.println("Saved instance 6");
        outState.putString("input1",value_container);
        outState.putString("input2",value_container2);
        outState.putString("input3",value_container3);
        outState.putString("input4",value_container4);
        outState.putString("input5",value_container5);
        outState.putString("input6",value_container6);
        outState.putString("input7",value_container7);




    }
}


