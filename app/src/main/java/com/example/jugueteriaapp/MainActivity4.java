package com.example.jugueteriaapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    TextView titulos;
    ImageButton imagen1;
    TextView subtitulo1;
    ImageButton imagen2;
    TextView subtitulo2;
    ImageButton imagen3;
    TextView subtitulo3;

    Producto[] productosNinas = {
            new Producto("Caja registradora", R.drawable.caja_registradora, "Juguetes de niñas"),
            new Producto("Patines", R.drawable.patines, "Juguetes de niñas"),
            new Producto("Mueble de muñecas", R.drawable.mueble_para_mu_ecas, "Juguetes de niñas")
    };

    Producto[] productosNinos = {
            new Producto("Rayo McQueen", R.drawable.carro_de_a_control_remoto, "Juguetes de niños"),
            new Producto("Carros", R.drawable.carros, "Juguetes de niños"),
            new Producto("Pista de carreras", R.drawable.pista_de_carreras, "Juguetes de niños")
    };

    Producto[] productosBebes = {
            new Producto("Gusanito musical", R.drawable.gusano, "Juguetes de bebés"),
            new Producto("Sonajero", R.drawable.sonajero, "Juguetes de bebés"),
            new Producto("Xilófono", R.drawable.xilofono, "Juguetes de bebés")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        titulos = findViewById(R.id.Titulos);
        imagen1 = findViewById(R.id.Imagen1);
        subtitulo1 = findViewById(R.id.Subtitulo1);
        imagen2 = findViewById(R.id.Imagen2);
        subtitulo2 = findViewById(R.id.Subtitulo2);
        imagen3 = findViewById(R.id.Imagen3);
        subtitulo3 = findViewById(R.id.Subtitulo3);

        // Leer la categoría seleccionada de SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        String categoriaSeleccionada = sharedPreferences.getString("categoriaSeleccionada", "");

        // Cargar productos según la categoría seleccionada
        cargarProductosPorCategoria(categoriaSeleccionada);

        // Asignar listeners a las imágenes
        asignarListeners();
    }

    private void cargarProductosPorCategoria(String categoria) {
        if (categoria.equals("Juguetes de niñas")) {
            asignarProductos(productosNinas, categoria);
        } else if (categoria.equals("Juguetes de niños")) {
            asignarProductos(productosNinos, categoria);
        } else if (categoria.equals("Juguetes de bebés")) {
            asignarProductos(productosBebes, categoria);
        }
    }

    private void asignarProductos(Producto[] productos, String categoria) {
        titulos.setText(categoria);

        imagen1.setImageResource(productos[0].getImagen());
        subtitulo1.setText(productos[0].getNombre());

        imagen2.setImageResource(productos[1].getImagen());
        subtitulo2.setText(productos[1].getNombre());

        imagen3.setImageResource(productos[2].getImagen());
        subtitulo3.setText(productos[2].getNombre());
    }

    private void asignarListeners() {
        // Listener para imagen1
        imagen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarADetallesProducto(productosNinas[0]);
            }
        });

        // Listener para imagen2
        imagen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarADetallesProducto(productosNinas[1]);
            }
        });

        // Listener para imagen3
        imagen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarADetallesProducto(productosNinas[2]);
            }
        });
    }

    private void pasarADetallesProducto(Producto producto) {
        // Guardar los detalles del producto seleccionado en SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasProducto", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Almacenar los datos del producto seleccionado
        editor.putString("nombreProducto", producto.getNombre());
        editor.putString("categoriaProducto", producto.getNombreCategoria());
        editor.putInt("imagenProducto", producto.getImagen());
        editor.apply();

        // Iniciar MainActivity5
        Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
        startActivity(intent);
    }

    class Producto {
        private String nombre;
        private int imagen;
        private String nombreCategoria;

        public Producto(String nombre, int imagen, String nombreCategoria) {
            this.nombre = nombre;
            this.imagen = imagen;
            this.nombreCategoria = nombreCategoria;
        }

        public String getNombre() {
            return nombre;
        }

        public int getImagen() {
            return imagen;
        }

        public String getNombreCategoria() {
            return nombreCategoria;
        }
    }
}




