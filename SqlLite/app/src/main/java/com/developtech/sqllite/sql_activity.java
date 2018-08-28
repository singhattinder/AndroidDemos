package com.developtech.sqllite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class sql_activity extends AppCompatActivity   {
    private SQLiteDatabase db=null;
    private SQLiteOpenHelper helper=null;
    private EditText txtname,txtid,txtsal;
    private Button btnadd,btnedit,btncancel,btnshow;
    EmpBean objbean=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_activity);

        initComponents();

    }

    private void initComponents()
    {

        objbean=new EmpBean();
        txtid=(EditText)findViewById(R.id.txtid);
        txtname=(EditText)findViewById(R.id.txtname);
        txtsal=(EditText)findViewById(R.id.txtsal);
        btnadd=(Button)findViewById(R.id.btnadd);
        btncancel=(Button)findViewById(R.id.btncancel);
        btnedit=(Button)findViewById(R.id.btnedit);
        btnshow=(Button)findViewById(R.id.btnshow);





        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                objbean.setSal(txtsal.getText().toString());
                objbean.setName(txtname.getText().toString());
                int id=Integer.parseInt(String.valueOf(txtid.getText()));
                objbean.setId(id);
                DBServices dbServices=new DBServices(sql_activity.this);
                boolean flag= dbServices.addEmployee(objbean);
                if (flag)
                {
                    Utility.showMessage(sql_activity.this,"added");
                }
                else {

                    Utility.showMessage(sql_activity.this,"not added");
                }

            }
        });

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });





    }
}
