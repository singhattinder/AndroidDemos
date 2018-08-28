package com.developtech.androidlifecycle;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Cycle_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle_);
        Log.d("lifecycle","This is LifeCycle Create Yo!!!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "This is LifeCycle Start Yo!!!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "This is LifeCycle Resume Yo!!!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "This is LifeCycle Pause Yo!!!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "This is LifeCycle Stop Yo!!!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "This is LifeCycle Destory Yo!!!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle", "This is LifeCycle Restart Yo!!!");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("lifecycle","this is Save!!");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("lifecycle","this is restore");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d("lifecycle","this is backpress");
    }
}
