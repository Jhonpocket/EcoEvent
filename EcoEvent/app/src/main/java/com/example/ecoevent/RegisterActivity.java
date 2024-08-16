package com.example.ecoevent;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
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

    //Clase para los datos del usuario

    private UserManager userManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nombre = findViewById(R.id.editTextText3);
        correo = findViewById(R.id.editTextText4);
        celular = findViewById(R.id.editTextText6);
        contraseña = findViewById(R.id.editTextText7);
        inscribirse = findViewById(R.id.button3);

        //iniciar el UserManager

        userManager= new UserManager(this);

        //Boton de registro

        inscribirse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = correo.getText().toString().trim();
                String password = contraseña.getText().toString().trim();

                //Validaciones
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(RegisterActivity.this, "Ingrese un correo electrónico", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(email)) {
                    Toast.makeText(RegisterActivity.this, "Ingrese un correo electrónico válido", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(RegisterActivity.this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    registrarUsuario(email, password);
                }

            }
        });
    }
    private boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
    private void registrarUsuario(String email, String password) {
        String nombreUsuario = nombre.getText().toString().trim();
        userManager.registerUser(email, password);
        Toast.makeText(RegisterActivity.this, "Usuario registrado, bienvenido " + nombreUsuario, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(RegisterActivity.this, MainActivity3.class);
        startActivity(intent);
    }
}