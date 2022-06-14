package com.example.beeoneproject;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Madapter extends RecyclerView.Adapter<Madapter.ViewHolder> {

    List<Commnt> list;
    private Context context;

    public Madapter(List<Commnt> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item4, parent, false);
        return new Madapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Commnt commnt = list.get(position);

        holder.postid.setText(commnt.getPostId().toString());
        holder.id.setText(commnt.getId().toString());
        holder.name.setText(commnt.getName());
        holder.email.setText(commnt.getEmail());
        holder.body.setText(commnt.getBody());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView postid, id, name, email, body;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            postid = itemView.findViewById(R.id.postid);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            body = itemView.findViewById(R.id.body);


    }
    }

}