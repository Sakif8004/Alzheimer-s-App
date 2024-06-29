package com.example.alzeimier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class PatientLogin extends AppCompatActivity {
    private Button Signin;
    private Button Signup;
    private ImageButton back;

    EditText email,pass;
    Dialog dialog;
    Button yes,no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);
        Signin= findViewById(R.id.button3);
        Signup= findViewById(R.id.button4);
        back=findViewById(R.id.imageButton2);
        email=findViewById(R.id.editTextTextEmailAddress3);
        pass=findViewById(R.id.editTextTextPassword);

        dialog=new Dialog(PatientLogin.this);
        dialog.setContentView(R.layout.dialoguebox);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialoguebox_bg));
        dialog.setCancelable(false);

        yes=dialog.findViewById(R.id.button10);
        no=dialog.findViewById(R.id.button11);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                patienthome();
            }
        });

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eil=email.getText().toString();
                String password=pass.getText().toString();
                boolean isvalid=validatedata(eil,password);
                if(!isvalid){
                    return;
                }
                loginAccountInFirebase(eil,password);

            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patientsignup();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main();
            }
        });


    }

    void loginAccountInFirebase(String eil, String password){
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(eil,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    if(firebaseAuth.getCurrentUser().isEmailVerified()){
                    }
                    else{
                        Toast.makeText(PatientLogin.this,"Email not verified",Toast.LENGTH_SHORT).show();
                    }
                    dialog.show();
                    Toast.makeText(PatientLogin.this,"Valid Account",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(PatientLogin.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    boolean validatedata(String eil,String password){
        if(!Patterns.EMAIL_ADDRESS.matcher(eil).matches()){
            email.setError("Email Invalid");
            return false;
        }
        if(password.length()<6){
            pass.setError("Password Short");
            return false;
        }
        return true;
    }
    public void patienthome(){
        Intent h= new Intent(this,PatientHomePage.class);
        startActivity(h);
    }
    public void patientsignup(){
        Intent a= new Intent(this,PatientSignUpPage.class);
        startActivity(a);
    }
    public void main(){
        Intent a= new Intent(this,MainActivity.class);
        startActivity(a);
    }
}