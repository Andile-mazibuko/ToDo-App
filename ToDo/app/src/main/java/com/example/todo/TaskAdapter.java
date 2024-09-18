package com.example.todo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private List<Task> tasks;
    private Context context;


    public TaskAdapter(Context context, List<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }



    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.task_row,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {

        holder.title.setText(tasks.get(position).getTitle());
        holder.date.setText(tasks.get(position).getDate());
        holder.btn.setBackgroundColor(tasks.get(position).getColor());

        //To remove an error/warning about not treating position as a fixed value
        int pos = position;
        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,ItemActivity.class);

                    intent.putExtra("title",tasks.get(pos).getTitle());

                    intent.putExtra("content",tasks.get(pos).getContent());
                    Log.d("CONTENT",tasks.get(pos).getContent());

                    intent.putExtra("priority",tasks.get(pos).getPriority());
                    Log.d("PRIORITY",tasks.get(pos).getContent());

                    intent.putExtra("date",tasks.get(pos).getDate());
                    
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView title,date;
       Button btn;
        CardView cardView;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_holder);
            date = itemView.findViewById(R.id.task_date);
            btn = itemView.findViewById(R.id.priority_color);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
