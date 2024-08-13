package com.example.todo;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasks = new ArrayList<>();
        //tasks.add()
        databaseHelper = new DatabaseHelper(this);
        cursor = databaseHelper.getAllItems();
        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext())
        {

            tasks.add(new Task(1,cursor.getString(1), cursor.getString(3),"hIGH" ));


            buffer.append("ID :"+ cursor.getString(1) +"\n");

            buffer.append("Title: "+ cursor.getString(2) +"\n");
            buffer.append("Content" + cursor.getString(3) +"\n");


        }

        TaskAdapter adapter = new TaskAdapter(this,tasks);
        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);



        //RE



        //



        /*
        databaseHelper = new DatabaseHelper(this);


        //Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        recyclerview.setText(buffer.toString());
        */

    }
    public void openAddItemActivity(View v)
    {
        Intent intent = new Intent(this,AddActiviy.class);
        startActivity(intent);

    }

}