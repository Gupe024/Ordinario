package com.example.jugueteriaapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    ImageView imagenProducto;
    TextView contenido;
    TextView precios;
    EditText contadorProducto;
    Button buttonComprar;
    Button buttonPagar;
    Button Anterior = findViewById(R.id.i_anterior);

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
            "Caja registradora de color rosado con sonido, tiene escáner de precios y una mini pantalla con teclado numérico. Incluye tarjeta de crédito para pasar por el lector de la caja registradora.",
            "Patines con cuatro ruedas iluminadas y freno frontal. Diseño llamativo con colores aguamarina, rosado, azul, blanco, amarillo y metálicos.",
            "Mueble de muñecas con 3 armarios pequeños, bañera, cuna con móvil, comedero y lavabo. Colores rosados claros y morados.",
            "Carro de Rayo McQueen en color rojo con diseños de relámpagos. Control remoto incluido, baterías no incluidas.",
            "Paquete de cuatro carritos Hot Wheels: dorado, azul, blanco y rojo.",
            "Pista de carreras con circuito y dinosaurio que atrapa los autos que pasan. Colores naranja, azul, plateado, amarillo y negro.",
            "Gusano musical morado con antenas amarillas. Patitas con letras del abecedario que suenan al presionarlas. Incluye cuerda para pasear.",
            "Sonajeros de diferentes formas: ratón, micrófono, círculo y otros con partes sonoras. Colores pastel.",
            "Xilófono en forma de carrito con piezas de diferentes colores que suenan distinto al golpearlas con el palito amarillo."
    };

    double[] preciosProductos = {
            1000, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900
    };

    int productoActual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);

        // Inicializar las referencias de las vistas
        imagenProducto = findViewById(R.id.Viewproducto);
        contenido = findViewById(R.id.contenido);
        precios = findViewById(R.id.precios);
        contadorProducto = findViewById(R.id.contador_producto);
        buttonComprar = findViewById(R.id.buttoncomprar);
        buttonPagar = findViewById(R.id.buttonpagar);

        // Verifica que las referencias no sean null antes de utilizarlas
        if (imagenProducto != null && contenido != null && precios != null && contadorProducto != null) {
            mostrarProducto(productoActual);
        }

        // Establecer listeners para los botones
        if (buttonComprar != null) {
            buttonComprar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comprarProducto();
                }
            });
        }

        if (buttonPagar != null) {
            buttonPagar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pagarProducto();
                }
            });
        }

        if (Anterior != null) {
            Anterior.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish(); // Regresa a la actividad anterior
                }
            });
        }
    }

    public void mostrarProducto(int indice) {
        if (imagenProducto != null) {
            imagenProducto.setImageResource(imagenesProductos[indice]);
        }
        if (contenido != null) {
            contenido.setText(descripcionesProductos[indice]);
        }
        if (precios != null) {
            precios.setText("Precio: $" + preciosProductos[indice]);
        }
        if (contadorProducto != null) {
            contadorProducto.setText("1");
        }
    }

    public void comprarProducto() {
        int cantidad = Integer.parseInt(contadorProducto.getText().toString());
        double precio = preciosProductos[productoActual];
        SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasCompra", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("cantidadProducto", cantidad);
        editor.putFloat("precioProducto", (float) precio);
        editor.apply();

        Toast.makeText(this, "Producto agregado al carrito", Toast.LENGTH_SHORT).show();
    }

    public void pagarProducto() {
        SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasCompra", Context.MODE_PRIVATE);
        int cantidadProducto = sharedPreferences.getInt("cantidadProducto", 0);
        float precioProducto = sharedPreferences.getFloat("precioProducto", 0.0f);

        double totalPagar = cantidadProducto * precioProducto;

        Toast.makeText(this, "Total a pagar: $" + totalPagar, Toast.LENGTH_SHORT).show();
    }
}

