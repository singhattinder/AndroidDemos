package com.developtech.implicitintent_demo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Intent_activity extends AppCompatActivity {


    private ImageButton imgbtncall, imgbtnemail, imgbtnchat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_activity);
        initComponents();
    }


    public void initComponents() {

        imgbtncall = (ImageButton) findViewById(R.id.imgbtncall);
        imgbtnchat = (ImageButton) findViewById(R.id.imgbtnchat);
        imgbtnemail = (ImageButton) findViewById(R.id.imgbtnemail);

        imgbtncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:9876543210"));

                if (ActivityCompat.checkSelfPermission(Intent_activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });

        imgbtnchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:9876543210"));
                intent.putExtra("sms_body","hello world");
                startActivity(intent);
            }
        });


    }
}
