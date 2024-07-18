package com.example.ecoevent;



import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity3 extends AppCompatActivity {

    private static final String SELECTED_ITEM_ID = "SELECTED_ITEM_ID";
    private int selectedItemId = R.id.menu_home;

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
                    Intent intent = new Intent(MainActivity3.this, StatisticsActivity.class);
                    //Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            tipsCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Ir a la pantalla de consejos
                    Intent intent = new Intent(MainActivity3.this, TipsActivity.class);
                    //Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
            bottomNavigationView.setSelectedItemId(selectedItemId);

            bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    selectedItemId = item.getItemId();
                    Class<?> targetActivity = null;

                    if (selectedItemId == R.id.menu_home) {
                        targetActivity = MainActivity3.class;
                    } else if (selectedItemId == R.id.menu_categories) {
                        targetActivity = CategoriesActivity.class;
                    } else if (selectedItemId == R.id.menu_register) {
                        targetActivity = RegisterActivity.class;
                    } else if (selectedItemId == R.id.menu_stadistic) {
                        targetActivity = StatisticsActivity.class;
                    } else if (selectedItemId == R.id.menu_about) {
                        targetActivity = TipsActivity.class;
                    }

                    if (targetActivity != null) {
                        startActivity(new Intent(MainActivity3.this, targetActivity));
                        return true;
                    } else {
                        return false;
                    }
                }
            });


        }

}
