package com.example.alzeimier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Patient_Word extends AppCompatActivity {

    private ImageButton ext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_word);
        ext=findViewById(R.id.imageButton5);
        ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et();
            }
        });
    }
    public void et(){
        Intent a= new Intent(this, PatientHomePage.class);
        startActivity(a);
    }
}