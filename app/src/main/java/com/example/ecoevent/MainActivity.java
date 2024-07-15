package com.example.ecoevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the button view by ID
        Button button = findViewById(R.id.btn_go_to_main3);

        // Set a click listener for the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start MainActivity3
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);

                // Start the new activity
                startActivity(intent);
            }
        });
    }
}