package com.example.ecoevent;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ecoevent.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tips);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final int MENU_HOME = R.id.menu_home;
        final int MENU_CATEGORIES = R.id.menu_categories;
        final int MENU_REGISTER = R.id.menu_register;
        final int MENU_STATISTIC = R.id.menu_stadistic;
        final int MENU_ABOUT = R.id.menu_about;

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
    }
}