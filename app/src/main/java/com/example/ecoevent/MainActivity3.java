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

            final int MENU_HOME = R.id.menu_home;
            final int MENU_CATEGORIES = R.id.menu_categories;
            final int MENU_REGISTER = R.id.menu_register;
            final int MENU_STATISTIC = R.id.menu_stadistic;
            final int MENU_ABOUT = R.id.menu_about;

            BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

         /*   bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.menu_home:
                            item.setChecked(true);
                            return true;
                        case R.id.menu_categories:
                            startActivity(new Intent(MainActivity3.this, CategoriesActivity.class));
                            return true;
                        case R.id.menu_register:
                            startActivity(new Intent(MainActivity3.this, RegisterActivity.class));
                            return true;
                        case R.id.menu_stadistic:
                            startActivity(new Intent(MainActivity3.this, StatisticsActivity.class));
                            return true;
                        case R.id.menu_about:
                            startActivity(new Intent(MainActivity3.this, AboutActivity.class));
                            return true;
                    }
                    return false;
                }
            });*/
        }

}
