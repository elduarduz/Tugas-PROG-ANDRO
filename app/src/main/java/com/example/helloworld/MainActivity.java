package com.example.helloworld;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class  MainActivity extends AppCompatActivity {

    TextView textViewEmail;
    TextView textViewPassword;
    private Button button;
    TextView signin;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewEmail = findViewById(R.id.view1);
        textViewPassword = findViewById(R.id.view2);
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

    private void openRegis() {
        Intent intent = new Intent(this, regis.class);
        startActivity(intent);

        Toast.makeText(MainActivity.this, "welcome", Toast.LENGTH_LONG).show();
    }

    public void openHome(){
        Intent intent =  new Intent(this, home.class);
        startActivity(intent);
    }

    protected void onStart(){
        super.onStart();
    }

    protected void onResume(){
        super.onResume();
    }

    protected void onPause(){
        super.onPause();
    }

    protected void onStop(){
        super.onStop();
    }
}
