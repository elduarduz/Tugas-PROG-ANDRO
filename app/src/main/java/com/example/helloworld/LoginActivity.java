package com.example.helloworld;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Switch wifiSwitch;
    private WifiManager wifiManager;
    EditText textViewEmail;
    EditText textViewPassword;
    private Button button;
    TextView signin;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiSwitch = findViewById(R.id.wifi_switch);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    wifiManager.setWifiEnabled(true);
                    wifiSwitch.setText("WIFI IDUP");
                }else {
                    wifiManager.setWifiEnabled(false);
                    wifiSwitch.setText("WIFI MATI");
                }
            }
        });



        textViewEmail = findViewById(R.id.edit1);
        textViewPassword = findViewById(R.id.edit2);
        button = (Button) findViewById(R.id.login);
        signin = (TextView) findViewById(R.id.view2);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegis();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
//        textView.setText("Hellow Bro!!!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiStateReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiStateReceiver);
    }

    private BroadcastReceiver wifiStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int wifiganti = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);

            switch (wifiganti){
                case WifiManager.WIFI_STATE_ENABLED:
                    wifiSwitch.setChecked(true);
                    wifiSwitch.setText("WIFI IDUP");
                    Toast.makeText(context, "WIFI IDUP", Toast.LENGTH_SHORT).show();
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    wifiSwitch.setChecked(false);
                    wifiSwitch.setText("WIFI MATI");
                    Toast.makeText(context, "WIFI MATI", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private void openRegis() {
        Intent intent = new Intent(this, REGIS.class);
        startActivity(intent);

        Toast.makeText(LoginActivity.this, "welcome", Toast.LENGTH_LONG).show();
    }



    public void openHome(){
        if (textViewEmail.getText().toString().equals("edo") && textViewPassword.getText().toString().equals("12345")){
            Intent intent =  new Intent(this, HOME.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(LoginActivity.this, "Email atau Password salah gan!", Toast.LENGTH_LONG).show();
        }
    }

//    protected void onStart(){
//        super.onStart();
//    }
//
//    protected void onResume(){
//        super.onResume();
//    }
//
//    protected void onPause(){
//        super.onPause();
//    }
//
//    protected void onStop(){
//        super.onStop();
//    }
}
