package com.example.ecoevent;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class RegisterActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText correo;
    private EditText celular;
    private EditText contraseña;
    private EditText confirmar_contraseña;
    private Button inscribirse;
    private ImageButton visibilityButton;
    private ImageButton visibilityButton2;
    private boolean passwordVisible = false;
    private boolean passwordVisibleConfirm = false;
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
        confirmar_contraseña = findViewById(R.id.editTextText8);
        inscribirse = findViewById(R.id.button3);
        visibilityButton = findViewById(R.id.visibility_button);
        visibilityButton2 = findViewById(R.id.visibility_button2);


        //iniciar el UserManager

        userManager= new UserManager(this);

        //Boton de registro

        inscribirse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = correo.getText().toString().trim();
                String password = contraseña.getText().toString().trim();
                String confirmPassword = confirmar_contraseña.getText().toString().trim();

                //Validaciones
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(RegisterActivity.this, "Ingrese un correo electrónico", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(email)) {
                    Toast.makeText(RegisterActivity.this, "Ingrese un correo electrónico válido", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(RegisterActivity.this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "Ingrese Confirmación de contraseña", Toast.LENGTH_SHORT).show();
                } else if (!confirmPassword.equals(password)) {
                    Toast.makeText(RegisterActivity.this, "La Contraseña no coincide", Toast.LENGTH_SHORT).show();
                } else {
                    registrarUsuario(email, password);
                }

            }
        });

        // Listener para el botón de visibilidad de la contraseña
        visibilityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility();
            }
        });
        // Listener para el botón de visibilidad de la contraseña
        visibilityButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility2();
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
    // Método para alternar la visibilidad de la contraseña
    private void togglePasswordVisibility() {
        if (passwordVisible) {
            // Ocultar la contraseña
            contraseña.setTransformationMethod(PasswordTransformationMethod.getInstance());
            visibilityButton.setImageResource(R.drawable.ic_visibility_off);
        } else {
            // Mostrar la contraseña
            contraseña.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            visibilityButton.setImageResource(R.drawable.ic_visibility);
        }
        passwordVisible = !passwordVisible;
        // Mover el cursor al final del texto
        contraseña.setSelection(contraseña.getText().length());
    }
    // Método para alternar la visibilidad de la contraseña
    private void togglePasswordVisibility2() {
        if (passwordVisibleConfirm) {
            // Ocultar la contraseña
            confirmar_contraseña.setTransformationMethod(PasswordTransformationMethod.getInstance());
            visibilityButton2.setImageResource(R.drawable.ic_visibility_off);
        } else {
            // Mostrar la contraseña
            confirmar_contraseña.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            visibilityButton2.setImageResource(R.drawable.ic_visibility);
        }
        passwordVisibleConfirm = !passwordVisibleConfirm;
        // Mover el cursor al final del texto
        confirmar_contraseña.setSelection(confirmar_contraseña.getText().length());
    }
}