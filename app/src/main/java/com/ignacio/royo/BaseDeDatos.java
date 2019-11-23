package com.ignacio.royo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BaseDeDatos extends SQLiteOpenHelper {


    public BaseDeDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void onCreate( SQLiteDatabase db){
        String consulta = "CREATE TABLE minion ( id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "pelicula TEXT, year INTEGUER)";

        db.execSQL(consulta);
    }

    public void insert (String pelicula, int year, Context context){
        SQLiteDatabase insertar = getWritableDatabase();
        String i = "INSERT INTO minion (pelicula, year) VALUES (\"" + pelicula +"\" ,"+ year + ")";
        insertar.execSQL(i);
        insertar.close();
        Toast.makeText(context, "Datos insertados", Toast.LENGTH_SHORT).show();

    }

    public Cursor selectData(){
        SQLiteDatabase s = getReadableDatabase();
        String select = "SELECT * FROM minion";
        Cursor query = s.rawQuery(select,null);
        return query;

    }
}
