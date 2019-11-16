package com.ignacio.royo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {

    private MediaPlayer player;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (player != null && player.isPlaying()) {
            player.stop();
        }
        player = MediaPlayer.create(this, R.raw.minion);
        player.setLooping(true);
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (player != null){
            player.release();
        }
        stopSelf();
    }
}
