package com.example.alzeimier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CaregiverLogin extends AppCompatActivity {
    private Button Signin;
    private Button Signup;
    private ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caregiver_login);
        Signin= findViewById(R.id.button8);
        Signup= findViewById(R.id.button9);
        back=findViewById(R.id.imageButton4);
        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caregiverhome();
            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caregiversignup();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main();
            }
        });
    }
    public void caregiverhome(){
        Intent h= new Intent(this,Caregiverhome.class);
        startActivity(h);
    }
    public void caregiversignup(){
        Intent a= new Intent(this,CareGiverSignup.class);
        startActivity(a);
    }

    public void main(){
        Intent b= new Intent(this,MainActivity.class);
        startActivity(b);
    }
}