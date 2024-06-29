package com.example.alzeimier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PatientHomePage extends AppCompatActivity {

    private Button logut,timedate,loc,log,words,note;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home_page);
        logut=findViewById(R.id.button6);
        timedate=findViewById(R.id.button16);
        loc=findViewById(R.id.button7);
        log=findViewById(R.id.button12);
        words=findViewById(R.id.button14);
        note=findViewById(R.id.button15);
        logut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
        timedate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tmedte();
            }
        });
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                location();
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logic();
            }
        });
        words.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                word();
            }
        });
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notes();
            }
        });
    }
    public void logout(){
        Intent a= new Intent(this,PatientLogin.class);
        startActivity(a);
    }
    public void tmedte(){
        Intent b= new Intent(this,Time_Date.class);
        startActivity(b);
    }
    public void location(){
        Intent c= new Intent(this,Patient_Location.class);
        startActivity(c);
    }
    public void logic(){
        Intent d= new Intent(this, Patient_Logical_Test.class);
        startActivity(d);
    }
    public void word(){
        Intent e= new Intent(this, Patient_Word.class);
        startActivity(e);
    }
    public void notes(){
        Intent f= new Intent(this, Patient_Notes.class);
        startActivity(f);
    }
}