package com.ignacio.royo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class MyReceiver extends BroadcastReceiver {

    private static final String headset = "android.intent.action.HEADSET_PLUG";
    private static final String state_headset = "state";
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent in = new Intent(context, MyService.class);
        if ( intent.getAction() != null ){
            if (intent.getAction().equals(headset)){
                Bundle b = intent.getExtras();
                assert b != null;
                Log.d("MyReveiver", "State: " + b.getInt(state_headset));
                switch (b.getInt(state_headset)){
                    case 0:
                        context.stopService(in);
                        break;
                    case 1:
                        context.startService(in);
                        break;
                }
            }

        }else {
            if(intent.hasExtra(Activity3.code)){
                Bundle b = intent.getExtras();

                if (b != null){
                    int code = b.getInt(Activity3.code);
                    switch (code){
                        case 0:
                            context.startService(in);
                            break;
                        case 1:
                            context.stopService(in);
                            break;
                        case 3:
                            try {
                                Thread.sleep(150000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        default:
                            //Toast.makeText(getApplicationContext(),"Activity 2", Toast.LENGTH_SHORT).show();
                            break;
                    }

                }
            }

        }

    }
}
