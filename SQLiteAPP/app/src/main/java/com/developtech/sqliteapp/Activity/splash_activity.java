package com.developtech.sqliteapp.Activity;

import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.developtech.sqliteapp.R;

public class splash_activity extends AppCompatActivity {
    private static final int def=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        getSupportActionBar().hide();
        initComponents();

    }

    public void  initComponents()
    {

        Thread t=new Thread()
        {
            public void run()
            {
                try{
                Thread.sleep(2000);

                    SharedPreferences sp=getSharedPreferences("exit", MODE_PRIVATE);
                    int flag=sp.getInt("data",def);
                    if(flag!=1){
                        Intent intent=new Intent(splash_activity.this,Login_activity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Intent intent=new Intent(splash_activity.this,ViewActivity.class);
                        startActivity(intent);
                    }

                    }
                catch (Exception e)
                {

                }
                finally {
                    splash_activity.this.finish();
                }
            }
        };
        t.start();



    }
}
