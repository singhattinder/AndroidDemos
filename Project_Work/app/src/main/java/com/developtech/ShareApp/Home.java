package com.developtech.ShareApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.developtech.ShareApp.About.About;
import com.developtech.ShareApp.Feedback.Feedback;
import com.developtech.ShareApp.ForgotPassword.ForgotPassword;
import com.developtech.ShareApp.Icon.Icon;
import com.developtech.ShareApp.ManageProfile.ManageProfile;
import com.developtech.ShareApp.SignIn.SignIn;
import com.developtech.ShareApp.SignUp.SignUp;

public class Home extends AppCompatActivity {

    private Button btnabout,btnfeedback,btnicon,btnmp,btnsignup,btnsinin,btnfp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initComponents();
    }

    private void initComponents()
    {
        btnabout=(Button)findViewById(R.id.btnabout);
        btnfeedback=(Button)findViewById((R.id.btnfeedback));
        btnicon=(Button)findViewById(R.id.btnicon);
        btnmp=(Button)findViewById(R.id.btnmp);
        btnsignup=(Button)findViewById(R.id.btnsignup);
        btnsinin=(Button)findViewById(R.id.btnsignin);
        btnfp=(Button)findViewById(R.id.btnfp);


        btnfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,ForgotPassword.class);
                startActivity(intent);
            }
        });
        btnsinin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,SignIn.class);
                startActivity(intent);

            }
        });

        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,About.class);
                startActivity(intent);

            }
        });

        btnfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Feedback.class);
                startActivity(intent);

            }
        });

        btnmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,ManageProfile.class);
                startActivity(intent);

            }
        });

        btnicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Icon.class);
                startActivity(intent);

            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,SignUp.class);
                startActivity(intent);

            }
        });


    }
}
