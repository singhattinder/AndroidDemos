package com.developtech.sharedpreferencedemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Attinder on 30/03/16.
 */
public class view_activity_class extends AppCompatActivity implements View.OnClickListener {

    private EditText etvusername,etvpassword;
    private Button btnload,btnexit;
    private static final String def="nothing";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity);
        initComponents();
    }

    private void initComponents()
    {
        etvpassword=(EditText)findViewById(R.id.etvpassword);
        etvusername=(EditText)findViewById(R.id.etvusername);
        btnexit=(Button)findViewById(R.id.btnexit);
        btnload=(Button)findViewById(R.id.btnload);
        btnload.setOnClickListener(this);
        btnexit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnload:
            {
                SharedPreferences sp=getSharedPreferences("spdemo", MODE_PRIVATE);
               String un=sp.getString("username", def);
                String pass=sp.getString("password",def);

                if(un.equals(def)||(pass.equals(def)))
                {
                    Toast.makeText(view_activity_class.this,"Not saved!",Toast.LENGTH_SHORT).show();

                }

                else
                {
                    etvusername.setText(un);
                    etvpassword.setText(pass);
                }


                break;
            }
            case R.id.btnexit:
            {

                SharedPreferences sp=getSharedPreferences("exit",MODE_PRIVATE);
                SharedPreferences.Editor e=sp.edit();
                e.putBoolean("data",true);
                e.putString("username",etvpassword.getText().toString());
                e.putString("password",etvpassword.getText().toString());

                System.exit(0);

                break;
            }


        }


    }
}
