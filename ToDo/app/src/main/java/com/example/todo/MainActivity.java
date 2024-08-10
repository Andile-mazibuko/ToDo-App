package com.example.todo;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    TextView recyclerview;
    DatabaseHelper databaseHelper;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        /*recyclerview = findViewById(R.id.recyclerview);
        databaseHelper = new DatabaseHelper(this);

        cursor = databaseHelper.getAllItems();
        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext())
        {
            buffer.append("ID :"+ cursor.getString(1) +"\n");
            buffer.append("Title: "+ cursor.getString(2) +"\n");
            buffer.append("Content" + cursor.getString(3) +"\n");

           // Log.e("ID",cursor.getString(0));
        }
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