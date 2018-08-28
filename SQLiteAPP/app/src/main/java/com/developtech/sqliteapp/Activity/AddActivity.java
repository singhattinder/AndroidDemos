package com.developtech.sqliteapp.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.developtech.sqliteapp.R;
import com.developtech.sqliteapp.beans.EmpBean;
import com.developtech.sqliteapp.services.EmpServices;

import java.io.ByteArrayOutputStream;

public class AddActivity extends AppCompatActivity {

    private EditText etusername,etpassword,etdob,etphone,etemail;
    private Button btnsave,btncancel,btnupload,btncapture;
    private ImageView imgadd;
    String encodedImageString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initComponents();

    }
    public void initComponents()
    {
        etusername=(EditText)findViewById(R.id.etusesrname);
        etdob=(EditText)findViewById(R.id.etdob);
        etpassword=(EditText)findViewById(R.id.etpassword);
        etphone=(EditText)findViewById(R.id.etcontact);
        etemail=(EditText)findViewById(R.id.etemail);
        btnsave=(Button)findViewById(R.id.btnsave);
        btnupload=(Button)findViewById(R.id.btnupload);
        btncapture=(Button)findViewById(R.id.btncapture);
        imgadd=(ImageView)findViewById(R.id.imgadd);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EmpBean objbean = new EmpBean();
                objbean.setPassword(etpassword.getText().toString());
                objbean.setName(etusername.getText().toString());
                objbean.setEmail(etemail.getText().toString());
                objbean.setDob(etdob.getText().toString());
                objbean.setContact(etphone.getText().toString());
                objbean.setProfilePic(encodedImageString);
                Log.d("test",String.valueOf(encodedImageString));

                EmpServices emp = new EmpServices(AddActivity.this);

                if (emp.addUser(objbean)) {
                    Toast.makeText(AddActivity.this, "Contact Added", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddActivity.this, ViewActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(AddActivity.this, "Not Added", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btncapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 2);
            }
        });
        btnupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,1);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&& resultCode ==RESULT_OK)
        {
            Uri u= data.getData();
            imgadd.setImageURI(u);
            Bitmap bm=((BitmapDrawable)imgadd.getDrawable()).getBitmap();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
            byte[] b = baos.toByteArray();
            encodedImageString = Base64.encodeToString(b, Base64.DEFAULT);


        }
        else if(requestCode==2 && resultCode==RESULT_OK)
        {
            Bitmap bm=(Bitmap)data.getExtras().get("data");
            imgadd.setImageBitmap(bm);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
            byte[] b = baos.toByteArray();
            encodedImageString = Base64.encodeToString(b, Base64.DEFAULT);
        }

    }

}
