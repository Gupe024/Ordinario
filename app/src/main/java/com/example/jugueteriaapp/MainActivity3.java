package com.example.jugueteriaapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    private ImageButton buttongirls;
    private ImageButton buttonboys;
    private ImageButton buttonbaby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        buttongirls = findViewById(R.id.nina);
        buttonboys = findViewById(R.id.nino);
        buttonbaby = findViewById(R.id.bebe);

        configurarOyentesDeClic();
    }

    private void configurarOyentesDeClic() {
        buttongirls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarCategoriaYMostrarMensaje("Juguetes de niñas", "Juguetes para niñas");
            }
        });

        buttonboys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarCategoriaYMostrarMensaje("Juguetes de niños", "Juguetes para niños");
            }
        });

        buttonbaby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarCategoriaYMostrarMensaje("Juguetes de bebés", "Juguetes para bebés");
            }
        });
    }

    private void guardarCategoriaYMostrarMensaje(String categoria, String mensaje) {
        guardarCategoria(categoria);
        mostrarMensaje(mensaje);
        iniciarMainActivity4();
    }

    private void guardarCategoria(String categoria) {
        SharedPreferences sharedPreferences = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("categoriaSeleccionada", categoria);
        editor.apply();
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(MainActivity3.this, mensaje, Toast.LENGTH_SHORT).show();
    }

    private void iniciarMainActivity4() {
        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
        startActivity(intent);
    }
}
