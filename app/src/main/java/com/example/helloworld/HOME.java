package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.FragmentManager;



public class HOME extends AppCompatActivity {

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        pref = getApplicationContext().getSharedPreferences("Mypref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("KEY1", "Test Shared Preference");
        editor.commit();


    }

    public void ChangeFragment(View view){
        Fragment fragment;

        if(view == findViewById(R.id.button)){
            fragment = new PROFILE();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
        }
        else if(view ==  findViewById(R.id.button2)){
            fragment = new CHAT();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
        }
        else if(view == findViewById(R.id.button3)){
            fragment = new SETTINGS();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
        }
    }
}
