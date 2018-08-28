package com.developtech.internalstoragedemo1;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.developtech.internalstoragedemo1.R;

import java.io.File;
import java.io.FileOutputStream;

import javax.microedition.khronos.egl.EGLDisplay;

public class shared_activity1 extends AppCompatActivity implements View.OnClickListener {

    private EditText etusername,etpassword;
    private Button btnsave,btnnext;
    private static final boolean def=true;
    private static final String  def1="nothing";
    File f=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_activity1);

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
                FileOutputStream fos=null;
                try {
                    f=getFilesDir();
                    fos = openFileOutput("abc.txt", MODE_PRIVATE);
                    String un = etusername.getText().toString().trim();
                    String pass = etpassword.getText().toString().trim();
                    un=un+" ";
                    fos.write(un.getBytes());
                    fos.write(pass.getBytes());
                    Toast.makeText(shared_activity1.this,String.valueOf(f),Toast.LENGTH_SHORT).show();
                }

                catch (Exception e)
                {

                    Log.d("exception",e.toString());
                }

                finally {
                    try {

                        fos.close();


                    } catch (Exception e)
                    {
                        Log.d("exception",e.toString());
                    }
                }
                break;
            }
            case  R.id.btnnext:
            {
                Intent intent=new Intent(shared_activity1.this,view.class);
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
