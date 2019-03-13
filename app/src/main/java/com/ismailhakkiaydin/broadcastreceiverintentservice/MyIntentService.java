package com.ismailhakkiaydin.broadcastreceiverintentservice;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {

    private static final String TAG = MyIntentService.class.getSimpleName();


    public MyIntentService() {
        super("MyWorkerThread");
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "oncreate methodu " + Thread.currentThread().getName() + " threadi üzerinden cagrildi");
        super.onCreate();
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Log.i(TAG, "onHandleIntent methodu " + Thread.currentThread().getName() + " threadi üzerinden cagrildi");

        int sleepTime = intent.getIntExtra("sleepTime", 1);


        int kontrol = 1;

        while (kontrol <= sleepTime) {
            try {
                Thread.sleep(1000);
                Intent intent1 = new Intent("my.action");
                intent1.putExtra("veri", kontrol);
                sendBroadcast(intent1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            kontrol++;
        }


    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy methodu " + Thread.currentThread().getName() + " threadi üzerinden cagrildi");
        super.onDestroy();
    }
}