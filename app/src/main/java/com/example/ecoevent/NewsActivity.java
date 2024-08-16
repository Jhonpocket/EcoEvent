package com.example.ecoevent;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class NewsActivity extends AppCompatActivity {

    private static final String SELECTED_ITEM_ID = "SELECTED_ITEM_ID";
    private TextView textNews;
    private String selectedView;
    private int selectedItemId = R.id.menu_about;

    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        textNews = findViewById(R.id.newsText);
        imageView = findViewById(R.id.banner);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Obtener la selección de la pantalla anterior
        Intent intent = getIntent();
        selectedView = intent.getStringExtra("selectedId");

        //textos
        String text = "";

        if ("reduce".equals(selectedView)) {
            text = getString(R.string.reduce_text);
            imageView.setImageResource(R.drawable.reduce);
        } else if ("limpio".equals(selectedView)){
            text = getString(R.string.limpio_text);
            imageView.setImageResource(R.drawable.limpio);
        } else if ("recicla".equals(selectedView)){
            text = getString(R.string.recicla_text);
            imageView.setImageResource(R.drawable.recicla);
        }else {
            textNews.setText("No funciona");
        }
        textNews.setText(Html.fromHtml(text));

        //Logout button

        ImageButton logoutButton = findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementar la lógica para cerrar sesión aquí
                logout();
            }
        });

        //Navegation bar

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
                    startActivity(new Intent(NewsActivity.this, targetActivity));
                    return true;
                } else {
                    return false;
                }
            }
        });

    }
    private void logout() {
        // Implementa la lógica para cerrar sesión (por ejemplo, limpiar sesión y redirigir a la pantalla de inicio de sesión)
        Toast.makeText(this, "Cerrar sesión", Toast.LENGTH_SHORT).show();
        // Redirige al usuario a la pantalla de inicio de sesión
        Intent intent = new Intent(NewsActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Opcional: cerrar la actividad actual
    }
}