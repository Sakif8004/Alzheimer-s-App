package com.example.alzeimier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class Patient_add_notes extends AppCompatActivity {

    EditText title,content;
    private Button add;
    ImageButton del;
    TextView pagetitle;
    String titles,contents,docId;

    boolean isEditMode=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_add_notes);
        title=findViewById(R.id.editTextText7);
        content=findViewById(R.id.editTextText8);
        add=findViewById(R.id.button17);
        del=findViewById(R.id.imageButton11);
        pagetitle=findViewById(R.id.textView10);

        titles=getIntent().getStringExtra("title");
        contents=getIntent().getStringExtra("content");
        docId=getIntent().getStringExtra("docId");
        if(docId!=null && !docId.isEmpty()){
            isEditMode=true;
        }

        title.setText(titles);
        content.setText(contents);
        if(isEditMode){
            pagetitle.setText("Edit Content");
            add.setText("Edit");
            del.setVisibility(View.VISIBLE);
        }




        add.setOnClickListener((v)->savenote());
        del.setOnClickListener((v)->deletenotefromfirebase());

    }
    void deletenotefromfirebase(){
        DocumentReference documentReference;
            documentReference=utility.getcolletionReferencenotes().document(docId);


        documentReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Patient_add_notes.this,"Delete complete",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(Patient_add_notes.this,"Failed to deleting notes",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void savenote(){
        String notetitle=title.getText().toString();
        String notecontent=content.getText().toString();
        if(notetitle==null || notetitle.isEmpty()){
            title.setError("Title Required");
            return;
        }
        note no=new note();
        no.setTitle(notetitle);
        no.setContent(notecontent);
        no.setTimestamp(Timestamp.now());
        savenotetofirebase(no);
    }
    void savenotetofirebase(note no){
        DocumentReference documentReference;
        if(isEditMode){
            documentReference=utility.getcolletionReferencenotes().document(docId);
        }
        else{
            documentReference=utility.getcolletionReferencenotes().document();
        }

        documentReference.set(no).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Patient_add_notes.this,"Save complete",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(Patient_add_notes.this,"Failed to save notes",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}