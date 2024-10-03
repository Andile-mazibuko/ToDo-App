package com.example.todo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.Date;

public class AddActiviy extends AppCompatActivity {

    String[] priority;
    AutoCompleteTextView list;
    ArrayAdapter<String> priorityAdapter;
    String item;
    private  DatabaseHelper databaseHelper;

    private TextView taskDueDate;
    EditText title;
    AutoCompleteTextView textView;
    EditText content;
    //TO BE CHANGED: date is set for testing purposes
    String taskDeadLine = new Date().toString();
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activiy);

        //populate the array with the items from the string resources
        priority = getResources().getStringArray(R.array.priority);
        taskDueDate = findViewById(R.id.taskDueDate);

        //Bind the dropdown with the current layout
        priorityAdapter = new ArrayAdapter<>(this,R.layout.priority_dropdown,priority);
        list = findViewById(R.id.list);
        list.setAdapter(priorityAdapter);

        title = findViewById(R.id.title);
        // textView = findViewById(R.id.select_prio);
        content = (EditText) findViewById(R.id.item_list);

       /*taskDueDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddActiviy.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                /*
                * i  = Year
                * i2 = Month(0-11)
                * i3 = day

                taskDeadLine = String.valueOf(i) + " / " + String.valueOf(i1+1)+ " / " + String.valueOf(i2);
            }
        },mYear,mMonth,mDay);
            }
        });*/

        databaseHelper = new DatabaseHelper(this);

        //

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString();
                // Toast.makeText(AddActiviy.this, ""+item, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void addItem(View v)
    {

        databaseHelper.addItem(title.getText().toString(),content.getText().toString(),item,taskDeadLine);
        Intent intent = new Intent(AddActiviy.this,MainActivity.class);
        startActivity(intent);
    }

   public void getTaskDueDate()
    {
        Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                /*
                * i  = Year
                * i2 = Month(0-11)
                * i3 = day
                **/
                taskDeadLine = String.valueOf(i) + " / " + String.valueOf(i1+1)+ " / " + String.valueOf(i2);
            }
        },mYear,mMonth,mDay);
        datePickerDialog.show();
    }
}