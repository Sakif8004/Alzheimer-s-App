package com.example.alzeimier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CareGiverSignup extends AppCompatActivity {

    private Button signin;
    private ImageButton ext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_giver_signup);
        signin=findViewById(R.id.button13);
        ext=findViewById(R.id.imageButton7);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sngin();
            }
        });
        ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xt();
            }
        });

    }
    public void sngin(){
        Intent a= new Intent(this,Caregiverhome.class);
        startActivity(a);
    }
    public void xt(){
        Intent a= new Intent(this,CaregiverLogin.class);
        startActivity(a);
    }
}