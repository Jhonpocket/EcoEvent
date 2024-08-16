package com.example.ecoevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TipsActivity extends AppCompatActivity {

    private static final String SELECTED_ITEM_ID = "SELECTED_ITEM_ID";
    private int selectedItemId = R.id.menu_about;
    private ImageView reduce, limpio, recicla;

    private LinearLayout tip1, tip2, tip3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        final int MENU_HOME = R.id.menu_home;
        final int MENU_CATEGORIES = R.id.menu_categories;
        final int MENU_REGISTER = R.id.menu_register;
        final int MENU_STATISTIC = R.id.menu_stadistic;
        final int MENU_ABOUT = R.id.menu_about;

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
                    targetActivity = CategoriaActivity.class;
                } else if (selectedItemId == R.id.menu_register) {
                    targetActivity = RegistrosActivity.class;
                } else if (selectedItemId == R.id.menu_stadistic) {
                    targetActivity = StatisticsActivity.class;
                } else if (selectedItemId == R.id.menu_about) {
                    targetActivity = TipsActivity.class;
                }

                if (targetActivity != null) {
                    startActivity(new Intent(TipsActivity.this, targetActivity));
                    return true;
                } else {
                    return false;
                }
            }
        });
        ImageButton logoutButton = findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementar la lógica para cerrar sesión aquí
                logout();
            }
        });

        reduce = findViewById(R.id.reduce);
        limpio = findViewById(R.id.limpio);
        recicla = findViewById(R.id.recicla);
        tip1 = findViewById(R.id.tip1);
        tip2 = findViewById(R.id.tip2);
        tip3 = findViewById(R.id.tip3);
        reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedItemId = "reduce";
                Intent intent = new Intent(TipsActivity.this, NewsActivity.class);
                intent.putExtra("selectedId", selectedItemId);
                startActivity(intent);
            }
        });
        limpio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedItemId = "limpio";
                Intent intent = new Intent(TipsActivity.this, NewsActivity.class);
                intent.putExtra("selectedId", selectedItemId);
                startActivity(intent);
            }
        });
        recicla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedItemId = "recicla";
                Intent intent = new Intent(TipsActivity.this, NewsActivity.class);
                intent.putExtra("selectedId", selectedItemId);
                startActivity(intent);
            }
        });
        tip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedItemId = "reduce";
                Intent intent = new Intent(TipsActivity.this, NewsActivity.class);
                intent.putExtra("selectedId", selectedItemId);
                startActivity(intent);
            }
        });
        tip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedItemId = "limpio";
                Intent intent = new Intent(TipsActivity.this, NewsActivity.class);
                intent.putExtra("selectedId", selectedItemId);
                startActivity(intent);
            }
        });
        tip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedItemId = "recicla";
                Intent intent = new Intent(TipsActivity.this, NewsActivity.class);
                intent.putExtra("selectedId", selectedItemId);
                startActivity(intent);
            }
        });
    }

    private void logout() {
        // Implementa la lógica para cerrar sesión (por ejemplo, limpiar sesión y redirigir a la pantalla de inicio de sesión)
        Toast.makeText(this, "Cerrar sesión", Toast.LENGTH_SHORT).show();
        // Redirige al usuario a la pantalla de inicio de sesión
        Intent intent = new Intent(TipsActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Opcional: cerrar la actividad actual
    }
}