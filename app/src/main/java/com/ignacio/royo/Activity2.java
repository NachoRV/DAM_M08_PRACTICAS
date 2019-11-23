package com.ignacio.royo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;



public class Activity2 extends AppCompatActivity {

    BaseDeDatos bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Toast.makeText(getApplicationContext(),"Activity 2", Toast.LENGTH_SHORT).show();
    }
    public void home(View view) {
        Intent intent;
        intent = new Intent(Activity2.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void crearTabla(View view) {
        this.bd = new BaseDeDatos(this, "peliculas", null,1);

    }

    public void insertarDatos(View view) {
        this.bd.insert("Los Minions", 2015, this);
        bd.insert("Gru 2 Mi villano favorito" , 2013, this);
    }

    public void consulTarDatos(View view) {
        Cursor c = this.bd.selectData();
        TextView textView = (TextView) findViewById(R.id.textView2);


        if(c.moveToFirst()){
            do {
                String id = c.getString(0);
                String pelicula = c.getString(1);
                String year = c.getString(2);
                textView.append(pelicula + " - " + year +"\n");

            }while (c.moveToNext());


        }

    }
}
