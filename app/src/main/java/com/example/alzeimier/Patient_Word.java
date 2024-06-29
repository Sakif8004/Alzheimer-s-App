package com.example.alzeimier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Patient_Word extends AppCompatActivity {

    private ImageButton ext;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_word);
        ext=findViewById(R.id.imageButton5);
        submit=findViewById(R.id.button20);
        ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sbmit();
            }
        });
    }
    public void et(){
        Intent a= new Intent(this, PatientHomePage.class);
        startActivity(a);
    }
    public void sbmit(){
        Intent a= new Intent(this, PatientHomePage.class);
        startActivity(a);
    }
}