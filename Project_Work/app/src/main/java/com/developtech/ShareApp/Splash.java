package com.developtech.ShareApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread t=new Thread(){
            public void run()
            {
                try {
                    Thread.sleep(2500);
                    Intent intent=new Intent(Splash.this,Home.class);
                    startActivity(intent);
                }
                catch (Exception e)
                {

                }
            }

        };
        t.start();




    }




}
