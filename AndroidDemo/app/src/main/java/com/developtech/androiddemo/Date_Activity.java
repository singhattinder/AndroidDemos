package com.developtech.androiddemo;

import android.content.Intent;
import android.net.nsd.NsdManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;

public class Date_Activity extends AppCompatActivity {


    Bundle namebundle=null;
    private EditText etdate;
    private Button btnnext;
    private Button btnprevious;
    private boolean flag=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_);

        namebundle=getIntent().getExtras();
        if(namebundle.getString("UUID").equals("age"))
        {

            etdate=(EditText)findViewById(R.id.etdate);
            etdate.setText(namebundle.getString("date"));
        }

        else if(namebundle.getString("UUID").equals("final"))

        {
            flag=true;
            etdate=(EditText)findViewById(R.id.etdate);
            etdate.setText(namebundle.getString("date"));

        }
        else
        {
            etdate=(EditText)findViewById(R.id.etdate);
            etdate.setText(namebundle.getString("date"));

        }




        initComponenets();

    }

    private void initComponenets()
    {
        etdate=(EditText)findViewById(R.id.etdate);
        btnnext=(Button)findViewById(R.id.btnnext);
        btnprevious=(Button)findViewById(R.id.btnprevious);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle datebundle=getIntent().getExtras();
                datebundle.putString("date", String.valueOf(etdate.getText()));
                datebundle.putString("UUID","date");

                if(!flag) {

                    Intent intent = new Intent(Date_Activity.this, Age_Activity.class);
                    intent.putExtras(datebundle);
                    startActivity(intent);
                }

                else
                {
                    Intent intent = new Intent(Date_Activity.this, Final_Activity.class);
                    intent.putExtras(datebundle);
                    startActivity(intent);

                }

            }
        });

        btnprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                namebundle=getIntent().getExtras();
                namebundle.putString("UUID","date");
                Intent intent=new Intent(Date_Activity.this,Name_Activity.class);
                intent.putExtras(namebundle);
                startActivity(intent);


            }
        });


    }
}
