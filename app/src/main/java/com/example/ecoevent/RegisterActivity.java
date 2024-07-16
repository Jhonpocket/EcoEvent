package com.example.ecoevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class RegisterActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText correo;
    private EditText celular;
    private EditText contraseña;
    private Button inscribirse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nombre = findViewById(R.id.editTextText3);
        correo = findViewById(R.id.editTextText4);
        celular = findViewById(R.id.editTextText6);
        contraseña = findViewById(R.id.editTextText7);
        inscribirse = findViewById(R.id.button3);

        inscribirse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreUsuario = nombre.getText().toString().trim();
                Toast.makeText(RegisterActivity.this, "Usuario registrado, bienvenido " + nombreUsuario, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegisterActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}