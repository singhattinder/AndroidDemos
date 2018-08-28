package com.developtech.sharedpreferencedemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.microedition.khronos.egl.EGLDisplay;

public class shared_activity extends AppCompatActivity implements View.OnClickListener {

    private EditText etusername,etpassword;
    private Button btnsave,btnnext;
    private static final boolean def=true;
    private static final String  def1="nothing";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_activity);

        SharedPreferences sp=getSharedPreferences("exit",MODE_PRIVATE);
        Boolean flag=sp.getBoolean("data",def);


        if(flag)
        {
            etusername=(EditText)findViewById(R.id.etusername);
            etpassword=(EditText)findViewById(R.id.etpassword);

            String un=sp.getString("username",def1);
            String pass=sp.getString("password",def1);

            etusername.setText(un);
            etpassword.setText(pass);

            Intent intent=new Intent(shared_activity.this,view_activity_class.class);
            startActivity(intent);
            finish();

        }


        initComponenets();
    }


    private void initComponenets()
    {
        etusername=(EditText)findViewById(R.id.etusername);
        etpassword=(EditText)findViewById(R.id.etpassword);
        btnnext=(Button)findViewById(R.id.btnnext);
        btnsave=(Button)findViewById(R.id.btnsave);
        btnsave.setOnClickListener(this);
        btnnext.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnsave:
            {
                SharedPreferences sp=getSharedPreferences("spdemo", MODE_PRIVATE);
                SharedPreferences.Editor e=sp.edit();

                if(etpassword.getText().toString().isEmpty()||etusername.getText().toString().isEmpty()) {

                    Toast.makeText(shared_activity.this,"Enter Data",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    e.putString("username", etusername.getText().toString());
                    e.putString("password", etpassword.getText().toString());
                    e.commit(); //to save data

                Toast.makeText(shared_activity.this,"Data saved",Toast.LENGTH_SHORT).show();}
                break;
            }
            case  R.id.btnnext:
            {
                Intent intent=new Intent(shared_activity.this,view_activity_class.class);
                startActivity(intent);
                finish();
                break;
            }

            default:
            {
                break;
            }

        }
    }
}
