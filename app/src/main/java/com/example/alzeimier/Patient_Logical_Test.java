package com.example.alzeimier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Patient_Logical_Test extends AppCompatActivity {
    private ImageButton ext;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_logical_test);
        ext=findViewById(R.id.imageButton6);
        submit=findViewById(R.id.button18);
        ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eit();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sbmit();
            }
        });

    }
    public void eit(){
        Intent b= new Intent(this,PatientHomePage.class);
        startActivity(b);
    }
    public void sbmit(){
        Intent b= new Intent(this,PatientHomePage.class);
        startActivity(b);
    }
}