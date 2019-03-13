package com.ismailhakkiaydin.broadcastreceiverintentservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startIntentService(View view) {
        Intent intent=new Intent(MainActivity.this, MyIntentService.class);
        intent.putExtra("sleepTime", 5);
        startService(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter=new IntentFilter();
        filter.addAction("my.action");
        registerReceiver(myBroadcastReceiver, filter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myBroadcastReceiver);
    }

    private BroadcastReceiver myBroadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int donguSirasi=intent.getIntExtra("veri", 1);

            Log.e("IHA", "Döngü sırası :" + donguSirasi);
            Toast.makeText(MainActivity.this, "Döngü sırası :" + donguSirasi, Toast.LENGTH_SHORT).show();

        }
    };

}