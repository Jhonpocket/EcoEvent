package com.example.ecoevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class RegistrosActivity extends AppCompatActivity {

    private static final String SELECTED_ITEM_ID = "SELECTED_ITEM_ID";
    private int selectedItemId = R.id.menu_register;

    private String[] tiposPlasticos = {
            "PET (Tereftalato de Polietileno)",
            "HDPE (Polietileno de alta densidad)",
            "PVC (Polivinilo)",
            "LDPE (Polietileno de baja densidad)",
            "PP (Polipropileno)",
            "PS (Poliestireno)"
    };
    private String[] decoraciones = {
            "Globos",
            "Banderines",
            "Centros de mesa",
            "Luces",
            "Confeti",
            "Guirnaldas"
    };


    private String[] meses = new String[12];
    private int mesActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registros);
        Spinner spinnerTipo = findViewById(R.id.spinner_tipo);
        Spinner spinnerMes = findViewById(R.id.spinner_mes);
        Button btnSave = findViewById(R.id.buttonSave);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Obtener la selección de la pantalla anterior
        Intent intent = getIntent();
        String selectedItem = intent.getStringExtra("selectedItem");

        // Mostrar la lista correspondiente según la selección
        if ("Bebidas".equals(selectedItem) || "Alimentos".equals(selectedItem)  || selectedItem == null  || selectedItem.isEmpty()  || "Seleccione".equals(selectedItem)) {
            ArrayAdapter<String> adapterTipo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tiposPlasticos);
            adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerTipo.setAdapter(adapterTipo);
        } else if ("Decoraciones".equals(selectedItem)) {
            ArrayAdapter<String> adapterTipo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, decoraciones);
            adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerTipo.setAdapter(adapterTipo);
        }

        // Inicializar meses
        Calendar calendar = Calendar.getInstance();
        mesActual = calendar.get(Calendar.MONTH);
        for (int i = 0; i < 12; i++) {
            meses[i] = getMonthName(i);
        }

        ArrayAdapter<String> adapterMes = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, meses);
        adapterMes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMes.setAdapter(adapterMes);
        spinnerMes.setSelection(mesActual);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Código para guardar el registro aquí
                // Mostrar mensaje de registro guardado
                Toast.makeText(RegistrosActivity.this, "Registro guardado!", Toast.LENGTH_SHORT).show();
            }
        });

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
                    startActivity(new Intent(RegistrosActivity.this, targetActivity));
                    return true;
                } else {
                    return false;
                }
            }
        });
    }
    private String getMonthName(int month) {
        String[] monthNames = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        return monthNames[month];
    }
}