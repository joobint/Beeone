package com.example.beeoneproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Zadapter  extends RecyclerView.Adapter<Zadapter.ViewHolder> {
    LayoutInflater inflater;
    List<Album2>list1;
    Context context;

    public Zadapter( List<Album2> list1, Context context) {
        this.list1 = list1;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater .from(context).inflate(R.layout.item3, parent, false);
        return new Zadapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album2 album2 = list1.get(position);
        holder.albumId.setText(album2.getAlbumId().toString());
        holder.id.setText(album2.getId().toString());
        holder.title.setText(album2.getTitle());
        holder.url.setText(album2.getUrl());
        Picasso.with(context).load(album2.getThumbnailUrl()).into(holder.thumbnailUrl);
        Picasso.Builder builder = new Picasso.Builder(context.getApplicationContext());
        builder.listener((picasso, uri, exception) -> exception.printStackTrace());
        Picasso.with(context).load("https://via.placeholder.com/150/2f32ee").into(holder.thumbnailUrl);
        Log.i("info",album2.getThumbnailUrl());
      //  Picasso.with(context).load(android_versions.get(i).getAndroid_image_url()).resize(120, 60).into(viewHolder.img_android);
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView albumId,id,title,url;
        ImageView  thumbnailUrl;
        public ViewHolder(@NonNull View itemView) {


            super(itemView);
            albumId = itemView.findViewById(R.id.talbumId);
            id = itemView.findViewById(R.id.tid);
            title = itemView.findViewById(R.id.ttitle);
            url=itemView.findViewById(R.id.turl);
            thumbnailUrl=itemView.findViewById(R.id.tthumbnailUrl);
        }
    }
}
