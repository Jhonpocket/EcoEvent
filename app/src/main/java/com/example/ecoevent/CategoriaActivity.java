package com.example.ecoevent;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Random;

public class CategoriaActivity extends AppCompatActivity {
    private static final String SELECTED_ITEM_ID = "SELECTED_ITEM_ID";
    private int selectedItemId = R.id.menu_categories;
    private String selectedItem;
    private TextView tipTextView;
    private ImageView tipImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        tipTextView = findViewById(R.id.tip_text_view);
        tipImageView = findViewById(R.id.tip_image_view);

        // Mostrar un consejo aleatorio
        showRandomTip();
        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, R.layout.spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = parent.getItemAtPosition(position).toString();
                // Cambiar el color del texto del ítem seleccionado
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.color_text));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Código cuando no hay selección
            }
        });
        Button buttonGoToRegistros = findViewById(R.id.buttonRegistrar);
        buttonGoToRegistros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedCategory = spinner.getSelectedItem().toString();
                Intent intent = new Intent(CategoriaActivity.this, RegistrosActivity.class);
                intent.putExtra("selectedItem", selectedItem);
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
                    targetActivity = CategoriaActivity.class;
                } else if (selectedItemId == R.id.menu_register) {
                    targetActivity = RegistrosActivity.class;
                } else if (selectedItemId == R.id.menu_stadistic) {
                    targetActivity = StatisticsActivity.class;
                } else if (selectedItemId == R.id.menu_about) {
                    targetActivity = TipsActivity.class;
                }

                if (targetActivity != null) {
                    startActivity(new Intent(CategoriaActivity.this, targetActivity));
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

    }
    private void logout() {
        // Implementa la lógica para cerrar sesión (por ejemplo, limpiar sesión y redirigir a la pantalla de inicio de sesión)
        Toast.makeText(this, "Cerrar sesión", Toast.LENGTH_SHORT).show();
        // Redirige al usuario a la pantalla de inicio de sesión
        Intent intent = new Intent(CategoriaActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Opcional: cerrar la actividad actual
    }
    private void showRandomTip() {
        Resources res = getResources();
        String[] tips = res.getStringArray(R.array.tips_array);

        // Seleccionar un índice aleatorio
        Random random = new Random();
        int index = random.nextInt(tips.length);

        // Obtener el consejo y la imagen correspondiente
        String selectedTip = tips[index];
        int imageResId = getResources().getIdentifier("tip" + (index + 1) + "_image", "drawable", getPackageName());

        // Actualizar el TextView y el ImageView
        tipTextView.setText(selectedTip);
        tipImageView.setImageResource(imageResId);
    }
}