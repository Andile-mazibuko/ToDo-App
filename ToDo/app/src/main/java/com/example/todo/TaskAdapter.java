package com.example.todo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
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



        /* if(tasks.get(position).getPriority().equalsIgnoreCase("Low Priority"))
        {
            holder.btn.setBackgroundColor(Color.GREEN);
        }else if(tasks.get(position).getPriority().equalsIgnoreCase("Medium Priority"))
        {
            holder.btn.setBackgroundColor(Color.YELLOW);
        }
        else
        {
            holder.btn.setBackgroundColor(Color.RED);
        }*/
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView title,date;
       Button btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_holder);
            date = itemView.findViewById(R.id.task_date);
            btn = itemView.findViewById(R.id.priority_color);

        }
    }
}
