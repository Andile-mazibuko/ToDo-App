package com.example.todo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddActiviy extends AppCompatActivity {

    String[] priority;
    AutoCompleteTextView list;
    ArrayAdapter<String> priorityAdapter;
    String item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activiy);

        //populate the array with the items from the string resources
        priority = getResources().getStringArray(R.array.priority);

        //Bind the dropdown with the current layout
        priorityAdapter = new ArrayAdapter<>(this,R.layout.priority_dropdown,priority);
        list = findViewById(R.id.list);
        list.setAdapter(priorityAdapter);




        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString();
               // Toast.makeText(AddActiviy.this, ""+item, Toast.LENGTH_SHORT).show();
            }
        });
    }
}