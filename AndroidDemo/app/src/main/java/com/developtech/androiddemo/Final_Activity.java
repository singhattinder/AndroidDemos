package com.developtech.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Final_Activity extends AppCompatActivity {

    Bundle finalbundle=null;
    private TextView txtname;
    private TextView txtage;
    private TextView txtdate;
    private Button btnprevious;
    private Button btneditname;
    private Button btneditage;
    private Button btneditdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_);
        initComponenets();
        Bundle finalbundle=getIntent().getExtras();
        txtname.setText(finalbundle.getString("name"));
        txtdate.setText(finalbundle.getString("date"));
        txtage.setText(finalbundle.getString("age"));
    }

    private void initComponenets()
    {

        txtage=(TextView)findViewById(R.id.txtage);
        txtdate=(TextView)findViewById(R.id.txtdate);
        txtname=(TextView)findViewById(R.id.txtname);
        btneditage=(Button)findViewById(R.id.btneditage);
        btneditdate=(Button)findViewById(R.id.btneditdate);
        btneditname=(Button)findViewById(R.id.btneditname);
        btnprevious=(Button)findViewById(R.id.btnprevious);


        btnprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                 finalbundle=getIntent().getExtras();
                finalbundle.putString("UUID","final");
                Intent intent=new Intent(Final_Activity.this,Age_Activity.class);
                intent.putExtras(finalbundle);
                startActivity(intent);

            }
        });

        btneditage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                 finalbundle=getIntent().getExtras();
                finalbundle.putString("UUID","final");
                Intent intent=new Intent(Final_Activity.this,Age_Activity.class);
                intent.putExtras(finalbundle);
                startActivity(intent);

            }
        });

        btneditdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                 finalbundle=getIntent().getExtras();
                finalbundle.putString("UUID","final");
                Intent intent=new Intent(Final_Activity.this,Date_Activity.class);
                intent.putExtras(finalbundle);
                startActivity(intent);
            }
        });

        btneditname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                 finalbundle=getIntent().getExtras();
                finalbundle.putString("UUID","final");
                Intent intent=new Intent(Final_Activity.this,Name_Activity.class);
                intent.putExtras(finalbundle);
                startActivity(intent);
            }
        });

    }

}
