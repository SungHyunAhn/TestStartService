package com.example.dellvenue11pro.testserviceactivity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class TestStartService extends Service {

    String str = "Service onDestory";
    Timer time = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            str = str + " and Service stopSelf 10sec";
            stopSelf();
        }
    };

    public void onCreate(){
        super.onCreate();
        Toast.makeText(TestStartService.this, "Service onCreate", Toast.LENGTH_SHORT).show();

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId){

        time.schedule(task, 10000);

        Toast.makeText(TestStartService.this, "Service onStartCommand", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }


    public void onDestroy(){
        super.onDestroy();
        time.cancel();
        Toast.makeText(TestStartService.this, str, Toast.LENGTH_SHORT).show();
    }
}
