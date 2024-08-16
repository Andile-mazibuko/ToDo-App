package com.example.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ItemActivity extends AppCompatActivity {

    Intent intent;
    String title,content,date,priority;
    TextView contentDisplay,titleDisplay,dateDisplay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item);

        contentDisplay = findViewById(R.id.content_display);
        titleDisplay = findViewById(R.id.title_display);
        dateDisplay = findViewById(R.id.date_display);

        intent = getIntent();
        title = intent.getStringExtra("title");
        content = intent.getStringExtra("content");
        date = intent.getStringExtra("date");

        contentDisplay.setText(content);
        titleDisplay.setText(title);
        dateDisplay.setText(date);



    }

    public void backButtonClicked(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}