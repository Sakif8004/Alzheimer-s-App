package com.example.alzeimier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Patient;
    private Button Caregiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Patient= findViewById(R.id.button);
        Caregiver= findViewById(R.id.button2);

        Patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patientloginpage();
            }
        });
        Caregiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caregiverloginpage();
            }
        });

    }
    public void patientloginpage(){
        Intent h= new Intent(this,PatientLogin.class);
        startActivity(h);
    }
    public void caregiverloginpage(){
        Intent a= new Intent(this,CaregiverLogin.class);
        startActivity(a);
    }
}