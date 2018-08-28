package com.developtech.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class Name_Activity extends AppCompatActivity {


    Bundle name=null;
    private Button btnnext;
    private EditText etname;
    private int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_);

        name=getIntent().getExtras();
        if(name!=null)
        {

            if(name.getString("UUID").equals("final"))
            {

                flag=1;
            }

            else if(name.getString("UUID").equals("date"))

            {
                flag=2;
            }
            etname=(EditText)findViewById(R.id.etname);
            etname.setText(name.getString("name"));
        }


        initComponents();
    }

    private void initComponents()
    {
        btnnext=(Button)findViewById(R.id.btnnext);
        etname=(EditText)findViewById(R.id.etname);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=new Bundle();
                name.putString("name", String.valueOf(etname.getText()));
                name.putString("UUID","name");


                if(flag==1)
                {
                    name=getIntent().getExtras();
                    name.putString("name",String.valueOf(etname.getText()));
                    Intent intent=new Intent(Name_Activity.this, Final_Activity.class);
                    intent.putExtras(name);
                    startActivity(intent);
                }

                else if(flag==2)  {


                    name=getIntent().getExtras();
                    name.putString("name",String.valueOf(etname.getText()));
                    Intent intent = new Intent(Name_Activity.this, Date_Activity.class);
                    intent.putExtras(name);
                    startActivity(intent);
                }

                else
                {
                    Intent intent = new Intent(Name_Activity.this, Date_Activity.class);
                    intent.putExtras(name);
                    startActivity(intent);

                }
            }
        });

    }
}
