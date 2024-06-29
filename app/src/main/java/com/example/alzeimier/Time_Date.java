package com.example.alzeimier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time_Date extends AppCompatActivity {
    private ImageButton ext;
    AnalogClock analogClock;
    TextView month,date,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_date);
        ext=findViewById(R.id.imageButton8);
        month=findViewById(R.id.textView33);
        date=findViewById(R.id.textView32);
        year=findViewById(R.id.textView34);

        analogClock=findViewById(R.id.analogclock);


        Date currenttime= Calendar.getInstance().getTime();
        String formatdate= DateFormat.getDateInstance(DateFormat.FULL).format(currenttime);

        String[] splitDate=formatdate.split(",");


        Log.d("myLOG", formatdate);
        Log.d("myLOG", currenttime.toString());
        month.setText(splitDate[1]);
        date.setText(splitDate[0]);
        year.setText(splitDate[2]);
        Log.d("myLOG", splitDate[0].trim());
        Log.d("myLOG", splitDate[1].trim());
        Log.d("myLOG", splitDate[2].trim());

        ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit();
            }
        });

    }
    public void exit(){
        Intent b= new Intent(this,PatientHomePage.class);
        startActivity(b);
    }
}