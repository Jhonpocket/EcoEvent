package com.example.ecoevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        EditText emailEditText = findViewById(R.id.emailEditText);
        Button resetPasswordButton = findViewById(R.id.resetPasswordButton);
        TextView confirmationMessageTextView = findViewById(R.id.confirmationMessageTextView);
        Button backButton = findViewById(R.id.backButton);

        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para enviar correo de recuperación de contraseña
                // ...

                // Mostrar mensaje de confirmación
                confirmationMessageTextView.setVisibility(View.VISIBLE);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Volver a la pantalla anterior
                finish();
            }
        });
    }
}
