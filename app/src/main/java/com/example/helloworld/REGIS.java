package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class REGIS extends AppCompatActivity {

    EditText regisUsername;
    EditText regisPassword;
    EditText regisKPassword;
    Button regisButton;
    TextView rgoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        regisUsername = findViewById(R.id.rEmail);
        regisPassword = findViewById(R.id.rPassword);
        regisKPassword = findViewById(R.id.rconPassword);
        regisButton = (Button) findViewById(R.id.rButton);
        rgoLogin = (TextView) findViewById(R.id.rgoLogin);

//        regisButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        rgoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
    }

    public void openLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        Toast.makeText(REGIS.this, "haii", Toast.LENGTH_LONG).show();
    }
}
