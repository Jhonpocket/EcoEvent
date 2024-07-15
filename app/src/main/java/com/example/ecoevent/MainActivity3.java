package com.example.ecoevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.screen_main);

            LinearLayout categoriesCard = findViewById(R.id.categories_card);
            LinearLayout statisticsCard = findViewById(R.id.statistics_card);
            LinearLayout tipsCard = findViewById(R.id.tips_card);

            categoriesCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Ir a la pantalla de categorías
                   // Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);
                    Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            statisticsCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Ir a la pantalla de estadísticas
                    //Intent intent = new Intent(MainActivity.this, StatisticsActivity.class);
                    Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            tipsCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Ir a la pantalla de consejos
                    //Intent intent = new Intent(MainActivity.this, TipsActivity.class);
                    Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }

}
