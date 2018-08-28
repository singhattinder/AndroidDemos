package com.developtech.filedemo;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.developtech.filedemo.R;

import java.io.FileInputStream;

public class view extends AppCompatActivity implements View.OnClickListener {
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
        switch (v.getId()) {
            case R.id.btnload: {

                try {
                    FileInputStream fis =openFileInput("abc.txt");

                    int c=0;
                    String un="";
                    while ((c=fis.read())!=-1)
                    {
                        char cr=(char)c;
                        un=un+cr;
                    }


                    String[] user=un.split(" ");

                    etvusername.setText(user[0]);
                    etvpassword.setText(user[1]);


                }
                catch (Exception e)
                {
                    Log.d("exception", e.toString());
                }


                break;
            }
            case R.id.btnexit: {


                System.exit(0);

                break;
            }


        }
    }
}
