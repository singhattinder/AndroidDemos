package com.developtech.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class Age_Activity extends AppCompatActivity {

    private Button btnnext;
    private Button btnprevious;
    private EditText etage;
    Bundle datebundle=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_);
        datebundle=getIntent().getExtras();
        etage=(EditText)findViewById(R.id.etage);
        etage.setText(datebundle.getString("age"));
        initComponenets();
    }


    private void initComponenets()

    {
        btnnext=(Button)findViewById(R.id.btnnext);
        btnprevious=(Button)findViewById(R.id.btnprevious);
        etage=(EditText)findViewById(R.id.etage);


        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle agebundle=getIntent().getExtras();
                agebundle.putString("age", String.valueOf(etage.getText()));

                Intent intent=new Intent(Age_Activity.this,Final_Activity.class);
                intent.putExtras(agebundle);
                startActivity(intent);

            }
        });

        btnprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                datebundle.putString("UUID","age");
                Intent intent=new Intent(Age_Activity.this,Date_Activity.class);
                intent.putExtras(datebundle);
                startActivity(intent);

            }
        });

    }


}
