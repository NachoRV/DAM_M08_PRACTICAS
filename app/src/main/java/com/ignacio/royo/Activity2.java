package com.ignacio.royo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

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
}
