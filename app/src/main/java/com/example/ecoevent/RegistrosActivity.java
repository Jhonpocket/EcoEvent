package com.example.ecoevent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
    private EditText et_cantidad, et_costo;
    private Spinner spinner_tipo,spinner_mes;
    private String selectedItem;

    private String[] tiposPlasticos = {
            "Botellas",
            "Vasos",
            "Bolsas",
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
        setContentView(R.layout.activity_registros);

        et_cantidad = findViewById(R.id.et_cantidad);
        et_costo = findViewById(R.id.et_costo);
        spinner_tipo = findViewById(R.id.spinner_tipo);
        spinner_mes = findViewById(R.id.spinner_mes);
        Button btnSave = findViewById(R.id.buttonSave);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Inicia la actividad SavedData
        btnSave.setOnClickListener(v -> SavedData());

        // Obtener la selección de la pantalla anterior
        Intent intent = getIntent();
        selectedItem = intent.getStringExtra("selectedItem");

        // Mostrar la lista correspondiente según la selección
        if ("Bebidas".equals(selectedItem) || "Alimentos".equals(selectedItem)  || selectedItem == null  || selectedItem.isEmpty()  || "Seleccione".equals(selectedItem)) {
            ArrayAdapter<String> adapterTipo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tiposPlasticos);
            adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_tipo.setAdapter(adapterTipo);
        } else if ("Decoraciones".equals(selectedItem)) {
            ArrayAdapter<String> adapterTipo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, decoraciones);
            adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_tipo.setAdapter(adapterTipo);
        }

        // Inicializar meses
        Calendar calendar = Calendar.getInstance();
        mesActual = calendar.get(Calendar.MONTH);
        for (int i = 0; i < 12; i++) {
            meses[i] = getMonthName(i);
        }

        ArrayAdapter<String> adapterMes = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, meses);
        adapterMes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_mes.setAdapter(adapterMes);
        spinner_mes.setSelection(mesActual);

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
        ImageButton logoutButton = findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementar la lógica para cerrar sesión aquí
                logout();
            }
        });
    }
    private String getMonthName(int month) {
        String[] monthNames = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        return monthNames[month];
    }
    private void SavedData() {
        String tipo = spinner_tipo.getSelectedItem().toString();
        String cantidad = et_cantidad.getText().toString();
        String costo = et_costo.getText().toString();
        String mes = spinner_mes.getSelectedItem().toString();

        // error si estan vacios
        if (tipo.isEmpty() || cantidad.isEmpty() || costo.isEmpty() || mes.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese los datos", Toast.LENGTH_SHORT).show();
            return;
        }

        //Guardar los datos en SharePreference
        SharedPreferences preferences = getSharedPreferences("QData", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        //Inicia el arreglo en 0
        int index = preferences.getInt("index", 0);

        editor.putString("tipo" + index, tipo);
        editor.putString("cantidad" + index, cantidad);
        editor.putString("costo" + index, costo);
        editor.putString("mes" + index, mes);
        editor.putString("Categoria" + index, selectedItem);

        //sube el arreglo uno a uno
        editor.putInt("index", index + 1);
        editor.apply();

        //mensaje de exito
        Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void logout() {
        // Implementa la lógica para cerrar sesión (por ejemplo, limpiar sesión y redirigir a la pantalla de inicio de sesión)
        Toast.makeText(this, "Cerrar sesión", Toast.LENGTH_SHORT).show();
        // Redirige al usuario a la pantalla de inicio de sesión
        Intent intent = new Intent(RegistrosActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Opcional: cerrar la actividad actual
    }

}