package com.ignacio.royo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
   public static EditText action;
   public static  final String code = "sound";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        BroadcastReceiver receiver = new MyReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        this.registerReceiver(receiver, filter);
    }


    public void getAction(View view) {
        action = (EditText) findViewById(R.id.editText);
        String data = action.getText().toString();
        int in = Integer.parseInt(data);
        Intent intent = new Intent(this, MyReceiver.class);
        intent.putExtra(code, in);
        sendBroadcast(intent);
        Toast.makeText(getApplicationContext(),data , Toast.LENGTH_SHORT).show();
    }
    public void home(View view) {
        Intent intent;
        intent = new Intent(Activity3.this, MainActivity.class);
        startActivity(intent);
        finish();
    }



}
