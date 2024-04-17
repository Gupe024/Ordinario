package com.example.jugueteriaapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText user;
    EditText pass;
    Button buttoniniciar;
    Button registrobutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.usuario);
        pass = findViewById(R.id.password);
        buttoniniciar = findViewById(R.id.iniciar);
        registrobutton = findViewById(R.id.registro2);

        buttoniniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                iniciarSesion();
                startActivity(intent);
            }

        });

        registrobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }

    private void iniciarSesion() {
        String usuario = user.getText().toString();
        String password = pass.getText().toString();

        if(verificarCredenciales(usuario, password)){
            Toast.makeText(this, "Bienvenid@"+usuario+",¿Qué te llevaras a tú casa este día?", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Usuario y contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean verificarCredenciales(String usuario, String password) {

        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);

        String usuarioAlmacenado = sharedPreferences.getString("usuario", null);
        String passAlmacenado = sharedPreferences.getString("password", null);

        if (usuarioAlmacenado == null || passAlmacenado == null) {
            Toast.makeText(this, "Error: No se encontraron credenciales almacenadas", Toast.LENGTH_SHORT).show();
            return false;
        }

        return usuario.equals(usuarioAlmacenado) && password.equals(passAlmacenado);
    }
}