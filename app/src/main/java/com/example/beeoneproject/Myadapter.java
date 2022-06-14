package com.example.beeoneproject;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {

    LayoutInflater inflater;
    List<Album> list;
    private Context context;

    public Myadapter( List<Album> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public Myadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater .from(context).inflate(R.layout.item2, parent, false);
        return new Myadapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = list.get(position);

        holder.userid.setText(String.valueOf(album.getUserId()));
        holder.id.setText(String.valueOf(album.getId()));
        holder.title.setText(album.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userid, id, title;
        private Button album;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            userid = itemView.findViewById(R.id.teuserid);
            id = itemView.findViewById(R.id.teid);
            title = itemView.findViewById(R.id.tetitle);
             album=itemView.findViewById(R.id.Album);



             album.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     Intent intent=new Intent(context,AlbumActivity.class);
                     intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                     context.startActivity(intent);
                 }
             });

        }
    }
    }

