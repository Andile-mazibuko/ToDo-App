package com.example.todo;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    DatabaseHelper databaseHelper;
    Cursor cursor;
    List<Task> tasks;
    TextView taskDueDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasks = new ArrayList<>();
        //tasks.add()
        databaseHelper = new DatabaseHelper(this);
        cursor = databaseHelper.getAllItems();

        Task task;
        String title,priority,content, date;
        int btnColor;
        while(cursor.moveToNext())
        {
            title = cursor.getString(1);
            priority = cursor.getString(2);
            content = cursor.getString(3);
            date = cursor.getString(4);
            if(priority.equalsIgnoreCase("Low Priority"))
            {
                btnColor = Color.GREEN;
            }else if(priority.equalsIgnoreCase("Medium Priority"))
            {
                btnColor =  Color.YELLOW;
            }
            else
            {
                btnColor = Color.RED;            
            }

            tasks.add(new Task(btnColor,title, date,priority,content));



            /*buffer.append("ID :"+ cursor.getString(1) +"\n");

            buffer.append("Title: "+ cursor.getString(2) +"\n");
            buffer.append("Content" + cursor.getString(3) +"\n");*/


        }

        TaskAdapter adapter = new TaskAdapter(this,tasks);
        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);



        databaseHelper = new DatabaseHelper(this);


    }
    public void openAddItemActivity(View v)
    {
        Intent intent = new Intent(this,AddActiviy.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}