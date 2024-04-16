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

public class MainActivity2 extends AppCompatActivity {

    EditText Editnombre;
    EditText Editusuario;
    EditText Editpassword;
    EditText Edittelefono;
    EditText Editcorreo;
    EditText Editdireccion;
    Button Registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        Editnombre = findViewById(R.id.nombre);
        Editusuario = findViewById(R.id.usuario);
        Editpassword = findViewById(R.id.password);
        Edittelefono = findViewById(R.id.telefono);
        Editcorreo = findViewById(R.id.correo);
        Editdireccion = findViewById(R.id.direccion);
        Registro = findViewById(R.id.registro);

        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registroUsuario(
                    Editnombre.getText().toString(),
                    Editusuario.getText().toString(),
                    Editpassword.getText().toString(),
                    Edittelefono.getText().toString(),
                    Editcorreo.getText().toString(),
                    Editdireccion.getText().toString()
                );

            }
        });
    }

    private void registroUsuario(String nombre, String usuario, String password, String telefono, String correo, String direccion) {
        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("nombre", nombre);
        editor.putString("usuario", usuario);
        editor.putString("password", password);
        editor.putString("telefono", telefono);
        editor.putString("correo", correo);
        editor.putString("direccion", direccion);

        editor.apply();

        Toast.makeText(this, "¡Usuario registrado correctamente!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
    }


}