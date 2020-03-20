package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;


import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class HOME extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    public static final long INTERVAL = 3000;
    private Handler mHandler = new Handler();
    private Timer mTimer = null;


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

    public void ChangeFragment(View view) {
        Fragment fragment;

        if (view == findViewById(R.id.button)) {
            fragment = new PROFILE();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
        } else if (view == findViewById(R.id.button2)) {
            fragment = new CHAT();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
        } else if (view == findViewById(R.id.button3)) {
            fragment = new SETTINGS();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
        }
    }

    public void scheduleJob(View v) {
        ComponentName componentName = new ComponentName(this, MyJobService.class);
        JobInfo info = new JobInfo.Builder(123, componentName)
                .setPersisted(true)
                .setPeriodic(15 * 60 * 1000)
                .build();

        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        int resultCode = scheduler.schedule(info);
        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.d(TAG, "Job scheduled");
        } else {
            Log.d(TAG, "Job scheduling failed");
        }
        if (mTimer != null) {
            mTimer.cancel();
        } else
            mTimer = new Timer();

        mTimer.scheduleAtFixedRate(new TimeDisplayToast(), 0, INTERVAL);
    }

    private class TimeDisplayToast extends TimerTask {

        @Override
        public void run() {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "3 Detik !", Toast.LENGTH_SHORT).show();

                }

            });
        }
    }
}
