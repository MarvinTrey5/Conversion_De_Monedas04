package com.example.conversindemonedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Definimos los objetos
    EditText BTC;
    // Definimos el Spinner
    Spinner Monedas;
    // Definimos el botón
    Button Conversion;
    // El unico textView
    TextView Mostrar;
    // Aqui se añaden los datos al spinner
    String [] ListaMarvin = {"Dólares", "Lempiras", "Quetzales", "Córdobas", "Cólones Costarricenses"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Referencias de los objetos
        BTC = findViewById(R.id.EditBTC);
        Conversion = findViewById(R.id.btnConversion);
        Monedas = findViewById(R.id.ListaConver);
        Mostrar = findViewById(R.id.txMostrar);
        // Creamos nuestro spinner que nos almacenará datos tipo string
        ArrayAdapter<String> Base = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, ListaMarvin);
        Monedas.setAdapter(Base);
        // Función del boton
        Conversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Se Llama el método
                Convertir();
            }
        });

    }
    public void Convertir(){
        // Tipos Double que nos almacenan el resultado
        // y la conversion
        double numBTC, Conver;
        // Tipos Double porque utilizan decimales
        double Dolar = 0.13;
        double Lempiras = 24.50;
        double Quetzal = 7.83;
        double Cordoba = 36.08;
        double Colones = 580.35;
        // Creamos una variable tipo string
        String op;
        // lo que el usuario ingrese hay que convertirlo a Double
        numBTC = Double.parseDouble(BTC.getText().toString());
        // Le decimos aqui que la variable tipo string nos permita
        // obtener las monedas y monedas almacena los item del spinner
        op = Monedas.getSelectedItem().toString();
        // Le establecemos condiciones al usuario al escoger las condiciones
        // Le decimos en las condiciones si la variable op tipo string que si
        // hay un tipo de dato llamado  Dólares si se cumple la condición
        if(op.equals("Dólares")){
            // Se realiza la conversión
            Conver = numBTC * Dolar;
            // Muestra en el textView
            Mostrar.setText("$ "+ Conver);
            // Siguiente condición
        } else if (op.equals("Lempiras")) {
            Conver = numBTC * Lempiras;
            Mostrar.setText("¢ " + Conver);
            // Siguiente condición
        } else if (op.equals("Quetzales")) {
            Conver = numBTC * Quetzal;
            Mostrar.setText("Q " + Conver);
            // Siguiente condición
        } else if (op.equals("Córdobas")) {
            Conver = numBTC * Cordoba;
            Mostrar.setText("C$ " + Conver);
            // Siguiente condición
        } else if (op.equals("Cólones Costarricenses")) {
            Conver = numBTC * Colones;
            Mostrar.setText("₡ "+ Conver);
        }
    }
}