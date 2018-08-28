package com.developtech.sqliteapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.developtech.sqliteapp.R;
import com.developtech.sqliteapp.services.EmpServices;

public class Login_activity extends AppCompatActivity implements View.OnClickListener {

    private EditText etname,etpassword;
    private Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        initComponents();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fablogin = (FloatingActionButton) findViewById(R.id.fablogin);

        fablogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login_activity.this,AddActivity.class);
                startActivity(intent);
            }
        });
    }


    public void initComponents()
    {
        etname=(EditText)findViewById(R.id.etname);
        etpassword=(EditText)findViewById(R.id.etpassword);
        btnlogin=(Button)findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnlogin:
            {
                EmpServices emp=new EmpServices(Login_activity.this);
                if(emp.authUser(etname.getText().toString(),etpassword.getText().toString()))
                {
                    Toast.makeText(Login_activity.this,"LOGGED IN",Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(Login_activity.this,ViewActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Login_activity.this,"NOT LOGGED IN",Toast.LENGTH_SHORT).show();
                }
                break;
            }

            default:
            {
                Toast.makeText(Login_activity.this,"Something is wrong",Toast.LENGTH_SHORT).show();
            }


        }
    }
}
