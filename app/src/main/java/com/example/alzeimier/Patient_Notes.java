package com.example.alzeimier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.ImageButton;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.Query;

public class Patient_Notes extends AppCompatActivity {

    private ImageButton ext,menu;
    FloatingActionButton add;
    RecyclerView recyclerView;
    NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_notes);
        ext=findViewById(R.id.imageButton9);
        add=findViewById(R.id.floatingActionButton2);
        recyclerView=findViewById(R.id.recyclerview);
        menu=findViewById(R.id.imageButton9);
        add.setOnClickListener((v)-> startActivity(new Intent(Patient_Notes.this,Patient_add_notes.class)));
        menu.setOnClickListener((v)->showmenu());
        setuprecyclerview();
        ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bairhou();
            }
        });
    }
    void setuprecyclerview(){
        Query query=utility.getcolletionReferencenotes().orderBy("timestamp", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<note>options=new FirestoreRecyclerOptions.Builder<note>()
                .setQuery(query,note.class).build();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter = new NoteAdapter(options,this);
        recyclerView.setAdapter(noteAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        noteAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        noteAdapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        noteAdapter.notifyDataSetChanged();
    }

    void showmenu(){

    }
    public void bairhou(){
        Intent f= new Intent(this, PatientHomePage.class);
        startActivity(f);
    }
}