package com.example.jugueteriaapp;

import static com.example.jugueteriaapp.R.id.Registro2;
import static com.example.jugueteriaapp.R.id.password;

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
    Button buttonregistrarse = findViewById(R.id.Registro2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.usuario);
        pass = findViewById(R.id.password);
        buttoniniciar = findViewById(R.id.iniciar);

        buttoniniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion();
            }
        });

        buttonregistrarse.setOnClickListener(new View.OnClickListener() {
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

        if(verificarcredenciales(usuario, password)){
            Toast.makeText(this, "Bienvenid@"+usuario+",¿Qué te podemos llevar a tú casa este día? Por favor selecciona:", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Usuario y contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean verificarcredenciales(String usuario, String password) {
        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);

        String UsuarioAlmacenado = sharedPreferences.getString("Usuario", "");
        String passAlmacenado = sharedPreferences.getString("Password","");

        return usuario.equals(UsuarioAlmacenado) && password.equals(passAlmacenado);
    }
}