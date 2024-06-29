package com.example.alzeimier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Patient_Location extends AppCompatActivity {
    private ImageButton exts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_location);
        exts=findViewById(R.id.imageButton3);
        exts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitss();
            }
        });
    }
    public void exitss(){
        Intent b= new Intent(this,PatientHomePage.class);
        startActivity(b);
    }
}