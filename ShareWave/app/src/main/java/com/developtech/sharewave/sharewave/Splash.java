package com.developtech.sharewave.sharewave;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.developtech.sharewave.sharewave.home.Home;
import com.developtech.sharewave.sharewave.signin.SignIn;

public class Splash extends AppCompatActivity {

    private static final int def=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Thread t=new Thread(){
            public void run()
            {
                try {
                    Thread.sleep(2500);

                    SharedPreferences sp=getSharedPreferences("login",MODE_PRIVATE);
                    int flag=sp.getInt("data", def);

                    if(flag==1)
                    {
                        Intent intent=new Intent(Splash.this,Home.class);
                        startActivity(intent);
                    }
                    else
                    {

                    Intent intent=new Intent(Splash.this,Home.class);
                    startActivity(intent);
                    }
                }
                catch (Exception e)
                {

                    System.out.println(String.valueOf(e));
                }
            }

        };
        t.start();




    }




}
