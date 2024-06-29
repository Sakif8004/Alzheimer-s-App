package com.example.alzeimier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Time_Date extends AppCompatActivity {
    private ImageButton ext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_date);
        ext=findViewById(R.id.imageButton8);
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