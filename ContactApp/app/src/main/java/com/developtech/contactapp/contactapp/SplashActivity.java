package com.developtech.contactapp.contactapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.developtech.contactapp.R;

/**
 * Created by Attinder on 25/03/16.
 */
public class SplashActivity extends AppCompatActivity   {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_splash);
        Thread t=new Thread()
        {

            public void run()
            {


                try{

                    Thread.sleep(1000);
                }
                catch (Exception e)
                {

                    Log.d("error",String.valueOf(e));

                }
                finally {
                    Intent intent=new Intent(SplashActivity.this,ListContacts.class);
                    startActivity(intent);
                }

            }
        };

        t.start();

    }



}
