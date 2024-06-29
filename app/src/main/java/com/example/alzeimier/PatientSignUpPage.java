package com.example.alzeimier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class PatientSignUpPage extends AppCompatActivity {
    private Button signin;
    private ImageButton back;

    EditText pname,fnum,email,emnum,nr_id,pass,cpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_sign_up_page);
        signin=findViewById(R.id.button5);
        back=findViewById(R.id.imageButton);
        pname=findViewById(R.id.editTextText2);
        fnum=findViewById(R.id.editTextPhone);
        email=findViewById(R.id.editTextTextEmailAddress2);
        emnum=findViewById(R.id.editTextPhone2);
        nr_id=findViewById(R.id.editTextText3);
        pass=findViewById(R.id.editTextTextPassword2);
        cpass=findViewById(R.id.editTextTextPassword4);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String patient_name=pname.getText().toString();
                String family_number=fnum.getText().toString();
                String eil=email.getText().toString();
                String emergency_number=emnum.getText().toString();
                String password=pass.getText().toString();
                String cpassword=cpass.getText().toString();
                boolean isvalid=validatedata(eil,password,cpassword);
                //patienthome();
                if(!isvalid){
                    return;
                }
                createAccountInFirebase(eil,password);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patientlogin();
            }
        });
    }

    void createAccountInFirebase(String eil, String password){
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(eil,password).addOnCompleteListener(PatientSignUpPage.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(PatientSignUpPage.this,"Successfull Create Account",Toast.LENGTH_SHORT).show();
                            firebaseAuth.getCurrentUser().sendEmailVerification();
                            firebaseAuth.signOut();
                            finish();
                        }
                        else{
                            Toast.makeText(PatientSignUpPage.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();

                        }

                    }
                }
        );

    }

    boolean validatedata(String eil,String password, String cpassword){
        if(!Patterns.EMAIL_ADDRESS.matcher(eil).matches()){
            email.setError("Email Invalid");
            return false;
        }
        if(password.length()<6){
            pass.setError("Password Short");
            return false;
        }
        if(!password.equals(cpassword)){
            cpass.setError("Password Not Matched");
            return false;
        }
        return true;
    }
    public void patienthome(){
        Intent h= new Intent(this,PatientHomePage.class);
        startActivity(h);
    }
    public void patientlogin(){
        Intent h= new Intent(this,PatientLogin.class);
        startActivity(h);
    }
}