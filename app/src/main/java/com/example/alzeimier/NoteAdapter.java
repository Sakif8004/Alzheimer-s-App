package com.example.alzeimier;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.api.Context;

public class NoteAdapter extends FirestoreRecyclerAdapter<note,NoteAdapter.NoteViewHolder> {
    Patient_Notes context;
    public NoteAdapter(@NonNull FirestoreRecyclerOptions<note> options, Patient_Notes context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteViewHolder holder, int position, @NonNull note note) {
        holder.titletextview.setText(note.title);
        holder.contenttextview.setText(note.content);
        holder.timetextview.setText(utility.timestampToString(note.timestamp));
        holder.itemView.setOnClickListener((v)->{
            Intent intent=new Intent(context,Patient_add_notes.class);
            intent.putExtra("title",note.title);
            intent.putExtra("content",note.content);
            String docId=this.getSnapshots().getSnapshot(position).getId();
            intent.putExtra("docId",docId);
            context.startActivity(intent);
        });
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_note_item,parent,false);
      return new NoteViewHolder(view);
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{

        TextView titletextview,contenttextview,timetextview;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            titletextview=itemView.findViewById(R.id.notetitle);
            contenttextview=itemView.findViewById(R.id.notecontent);
            timetextview=itemView.findViewById(R.id.notetime);
        }
    }
}
