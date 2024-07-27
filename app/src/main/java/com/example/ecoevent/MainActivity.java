package com.example.ecoevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button Ingresar;
    private Button Registrate;
    private EditText ingresarCorreo;
    private EditText ingresarContraseña;
    private ImageButton visibilityButton;
    private boolean passwordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa los elementos de la interfaz de usuario
        initializeUIElements();

        // Configura los listeners
        setupListeners();
    }

    // Método para inicializar los elementos de la interfaz de usuario
    private void initializeUIElements() {
        Ingresar = findViewById(R.id.button);
        Registrate = findViewById(R.id.button2);
        ingresarCorreo = findViewById(R.id.editTextText);
        ingresarContraseña = findViewById(R.id.editTextTextPassword2);
        visibilityButton = findViewById(R.id.visibility_button);
    }

    // Método para configurar los listeners de los botones y otros elementos interactivos
    private void setupListeners() {
        // Listener para el botón de visibilidad de la contraseña
        visibilityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility();
            }
        });

        // Listener para el botón Ingresar
        Ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleLogin();
            }
        });

        // Listener para el botón Registrate
        Registrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToRegister();
            }
        });

        // Listener para el TextView forgot_password
        TextView forgotPassword = findViewById(R.id.forgot_password);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToForgotPassword();
            }
        });
    }

    // Método para alternar la visibilidad de la contraseña
    private void togglePasswordVisibility() {
        if (passwordVisible) {
            // Ocultar la contraseña
            ingresarContraseña.setTransformationMethod(PasswordTransformationMethod.getInstance());
            visibilityButton.setImageResource(R.drawable.ic_visibility_off);
        } else {
            // Mostrar la contraseña
            ingresarContraseña.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            visibilityButton.setImageResource(R.drawable.ic_visibility);
        }
        passwordVisible = !passwordVisible;
        // Mover el cursor al final del texto
        ingresarContraseña.setSelection(ingresarContraseña.getText().length());
    }

    // Método para manejar el proceso de inicio de sesión
    private void handleLogin() {
        String email = ingresarCorreo.getText().toString();
        String password = ingresarContraseña.getText().toString();

        if (validateCredentials(email, password)) {
            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Usuario/Contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    // Método para navegar a la actividad de registro
    private void navigateToRegister() {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    // Método para navegar a la actividad de recuperación de contraseña
    private void navigateToForgotPassword() {
        Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
        startActivity(intent);
    }

    // Método de validación de credenciales
    private boolean validateCredentials(String email, String password) {
        // Credenciales predeterminadas
        String defaultEmail = "jair.cabra@gmail.com";
        String defaultPassword = "1234";

        return email.equals(defaultEmail) && password.equals(defaultPassword);
    }
}
