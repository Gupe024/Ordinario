package com.example.jugueteriaapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    // Definir variables para las vistas
    ImageView imagenProducto;
    TextView contenido;
    TextView precios;
    EditText contadorProducto;
    Button buttonComprar;
    Button buttonPagar;
    Button Anterior;

    // Datos de los productos de juguetería
    int[] imagenesProductos = {
            R.drawable.caja_registradora,
            R.drawable.patines,
            R.drawable.mueble_para_mu_ecas,
            R.drawable.carro_de_a_control_remoto,
            R.drawable.carros,
            R.drawable.pista_de_carreras,
            R.drawable.gusano,
            R.drawable.sonajero,
            R.drawable.xilofono
    };

    String[] descripcionesProductos = {
            "Caja registradora de color rosado con sonido, tiene escáner de precios y una mini pantalla con teclado numérico.",
            "Patines con cuatro ruedas iluminadas y freno frontal. Diseño llamativo con colores variados.",
            "Mueble de muñecas con 3 armarios pequeños, bañera, cuna, comedero y lavabo.",
            "Carro de control remoto de color rojo con diseños de relámpagos. Control remoto incluido.",
            "Paquete de carritos de juguete de diferentes colores y modelos.",
            "Pista de carreras con circuito y dinosaurio que atrapa los autos que pasan.",
            "Gusano musical morado con antenas amarillas y partes interactivas.",
            "Sonajeros de diferentes formas y colores para bebés.",
            "Xilófono en forma de carrito con piezas de colores."
    };

    double[] preciosProductos = {
            1000, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900
    };

    int productoActual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // Inicializar vistas
        imagenProducto = findViewById(R.id.Viewproducto);
        contenido = findViewById(R.id.contenido);
        precios = findViewById(R.id.precios);
        contadorProducto = findViewById(R.id.contador_producto);
        buttonComprar = findViewById(R.id.buttoncomprar);
        buttonPagar = findViewById(R.id.buttonpagar);
        Anterior = findViewById(R.id.i_anterior);

        // Recuperar el índice del producto seleccionado de SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasProducto", Context.MODE_PRIVATE);
        productoActual = sharedPreferences.getInt("productoSeleccionado", 0);

        // Mostrar datos del producto seleccionado
        mostrarDatosProducto();

        // Asignar listeners a los botones
        buttonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Realizar la compra
                realizarCompra();
            }
        });

        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Realizar el pago
                realizarPago();
            }
        });

        Anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Volver a MainActivity4
                finish();
            }
        });
    }

    private void mostrarDatosProducto() {
        // Asigna la imagen, descripción y precio del producto seleccionado
        imagenProducto.setImageResource(imagenesProductos[productoActual]);
        contenido.setText(descripcionesProductos[productoActual]);
        precios.setText(String.format("$%.2f", preciosProductos[productoActual]));
    }

    private void realizarCompra() {
        // Lógica para realizar la compra del producto
        Toast.makeText(MainActivity5.this, "Producto comprado", Toast.LENGTH_SHORT).show();
    }

    private void realizarPago() {
        // Lógica para realizar el pago de los productos comprados
        Toast.makeText(MainActivity5.this, "Pago realizado", Toast.LENGTH_SHORT).show();
    }
}



