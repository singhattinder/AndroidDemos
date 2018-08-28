package com.developtech.sharewave.sharewave.signin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.developtech.sharewave.sharewave.R;
import com.developtech.sharewave.sharewave.common.Utility;
import com.developtech.sharewave.sharewave.common.database.DatabaseServices;
import com.developtech.sharewave.sharewave.forgotpassword.ForgotPassword;
import com.developtech.sharewave.sharewave.home.Home;
import com.developtech.sharewave.sharewave.signup.SignUp;


/**
 * Created by Attinder on 22/04/16.
 */
public class SignIn extends AppCompatActivity {

    private TextView forgotpassword,registernow;
    private Button btnsignin;
    private EditText etpassword,etmobilenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initComponents();

    }

    private void initComponents()
    {
        forgotpassword=(TextView)findViewById(R.id.tvforgotpassword);
        registernow=(TextView)findViewById(R.id.tvregisternow);
        btnsignin=(Button)findViewById(R.id.btnsignin);
        etmobilenumber=(EditText)findViewById(R.id.etmobilenumber);
        etpassword=(EditText)findViewById(R.id.etpassword);


        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignIn.this, ForgotPassword.class);
               startActivity(intent);
            }
        });


        registernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
            }
        });

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if(Utility.isNetworkAvailable(SignIn.this))
//                {
//                    Utility.showToastMessage(SignIn.this,"Network is not available");
//
//                }
//                else
                {
                    DatabaseServices databaseServices=new DatabaseServices(SignIn.this);
                    boolean flag= databaseServices.authUser(etmobilenumber.getText().toString(),etpassword.getText().toString());
                    if (flag)
                    {

                        SharedPreferences sp=getSharedPreferences("login",MODE_PRIVATE);
                        SharedPreferences.Editor e=sp.edit();
                        e.putInt("data",1);
                        e.commit();



                        Intent intent=new Intent(SignIn.this,Home.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Utility.showToastMessage(SignIn.this,"Login Failed!");
                    }
                }


            }
        });
    }
}
