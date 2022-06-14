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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<Data> list;
    private Context context;
    RecyclerView recyclerView;

    public Adapter(List<Data> list, Context context) {

        this.list = list;
        this.context= context;



    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater .from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data data = list.get(position);
        holder.userid.setText(String.valueOf(data.getUserId()));
        holder.id.setText(String.valueOf(data.getId()));
        holder.title.setText(data.getTitle());
        holder.body.setText(data.getBody());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userid, id, title, body;
 private Button commt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userid = itemView.findViewById(R.id.teuserid);
            id = itemView.findViewById(R.id.teid);
            title = itemView.findViewById(R.id.tetitle);
            body = itemView.findViewById(R.id.textbody);
            commt=itemView.findViewById(R.id.button2);



            commt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context,commentsActivity.class);
                    intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });







            itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(context,Album_screen.class);
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);





    }
});





        }
    }
}