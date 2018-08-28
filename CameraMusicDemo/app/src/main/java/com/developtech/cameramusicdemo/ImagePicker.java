package com.developtech.cameramusicdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class ImagePicker extends AppCompatActivity {

    private Button btnpick,btncapture,btnnext,btnany;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        initComponents();
    }

    public void initComponents()
    {
        img=(ImageView)findViewById(R.id.img);
        btnpick=(Button)findViewById(R.id.btnpick);
        btncapture=(Button)findViewById(R.id.btncapture);
        btnany=(Button)findViewById(R.id.btnany);

        btnany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("file/*");
                startActivityForResult(intent, 3);
            }
        });

        btnpick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,1);
            }
        });
        btncapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,2);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&& resultCode ==RESULT_OK)
        {
            Uri u= data.getData();
            Log.d("test", String.valueOf(u));
            img.setImageURI(u);



        }
        else if(requestCode==2 && resultCode==RESULT_OK)
        {
            Bitmap bm=(Bitmap)data.getExtras().get("dara");
            img.setImageBitmap(bm);
        }
        else if(requestCode==3 && resultCode==RESULT_OK)
        {

            Toast.makeText(ImagePicker.this,"this worked",Toast.LENGTH_SHORT).show();

        }

    }

}
