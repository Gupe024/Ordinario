package com.example.jugueteriaapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    TextView titulos;
    ImageButton imagen1;
    TextView subtitulo1;
    ImageButton imagen2;
    TextView subtitulo2;
    ImageButton imagen3;
    TextView subtitulo3;

    // Define los productos
    Producto[] productosNinas = {
            new Producto("Caja   registradora", R.drawable.caja_registradora, "Juguetes de niñas"),
            new Producto("Patines", R.drawable.patines, "Juguetes de niñas"),
            new Producto("Mueble de muñecas", R.drawable.mueble_para_mu_ecas, "Juguetes de niñas")
    };

    Producto[] productosNinos = {
            new Producto("Ryo McQueen", R.drawable.carro_de_a_control_remoto, "Juguetes de niños"),
            new Producto("Carros", R.drawable.carros, "Juguetes de niños"),
            new Producto("Pista de carreras", R.drawable.pista_de_carreras, "Juguetes de niños")
    };

    Producto[] productosBebes = {
            new Producto("Gusanito musical", R.drawable.gusano, "Juguetes de bebés"),
            new Producto("Sonajero", R.drawable.sonajero, "Juguetes de bebés"),
            new Producto("Xilofono", R.drawable.xilofono, "Juguetes de bebés")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        // Inicializa elementos de la interfaz
        titulos = findViewById(R.id.Titulos);
        imagen1 = findViewById(R.id.Imagen1);
        subtitulo1 = findViewById(R.id.Subtitulo1);
        imagen2 = findViewById(R.id.Imagen2);
        subtitulo2 = findViewById(R.id.Subtitulo2);
        imagen3 = findViewById(R.id.Imagen3);
        subtitulo3 = findViewById(R.id.Subtitulo3);

        // Recupera la categoría seleccionada de SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        String categoriaSeleccionada = sharedPreferences.getString("categoriaSeleccionada", "");

        // Llama a la función para cargar los productos según la categoría seleccionada
        cargarProductosPorCategoria(categoriaSeleccionada);
    }

    // Función para cargar productos según la categoría seleccionada
    private void cargarProductosPorCategoria(String categoria) {
        // Según la categoría, carga los productos correctos
        if (categoria.equals("Juguetes de niñas")) {
            asignarProductos(productosNinas, categoria);
        } else if (categoria.equals("Juguetes de niños")) {
            asignarProductos(productosNinos, categoria);
        } else if (categoria.equals("Juguetes de bebés")) {
            asignarProductos(productosBebes, categoria);
        }
    }

    // Función para asignar productos a la interfaz
    private void asignarProductos(Producto[] productos, String categoria) {
        // Asigna el título de la categoría
        titulos.setText(categoria);

        // Asigna productos a los elementos de la interfaz
        imagen1.setImageResource(productos[0].getImagen());
        subtitulo1.setText(productos[0].getNombre());

        imagen2.setImageResource(productos[1].getImagen());
        subtitulo2.setText(productos[1].getNombre());

        imagen3.setImageResource(productos[2].getImagen());
        subtitulo3.setText(productos[2].getNombre());
    }

    // Clase Producto para almacenar información de los productos
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
