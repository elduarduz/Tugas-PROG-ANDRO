package com.example.helloworld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class BroadcastTestReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){
            Toast.makeText(context, "Boot Completed", Toast.LENGTH_SHORT).show();
        }

        int wifiganti = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);

        switch (wifiganti){
            case WifiManager.WIFI_STATE_ENABLED:
                Toast.makeText(context, "WIFI IDUP", Toast.LENGTH_SHORT).show();
                break;
            case WifiManager.WIFI_STATE_DISABLED:
                Toast.makeText(context, "WIFI MATI", Toast.LENGTH_SHORT).show();
                break;
        }
    }


}

