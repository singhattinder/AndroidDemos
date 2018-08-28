package com.developtech.contactapp.contactapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.developtech.contactapp.R;
import com.developtech.contactapp.beans.ContactBean;

public class activity_view extends AppCompatActivity {

    ContactBean objbean=null;
    Bundle bundle=null;
    private FloatingActionButton fab;
    private ImageButton imgbtncall,imgbtnchat,imgbtnemail;

    private TextView txtphone,txtemail,txtfname,txtlname,txtdob,txtaddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        bundle=getIntent().getExtras();

        objbean=(ContactBean)bundle.getSerializable("bean");

        initComponenets();



    }


    public void  initComponenets()
    {

        txtphone=(TextView)findViewById(R.id.txtphone);
        txtaddress=(TextView)findViewById(R.id.txtaddress);
        txtdob=(TextView)findViewById(R.id.txtdob);
        txtfname=(TextView)findViewById(R.id.txtfname);
        txtlname=(TextView)findViewById(R.id.txtlname);
        txtemail=(TextView)findViewById(R.id.txtemail);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        imgbtncall=(ImageButton)findViewById(R.id.imgbtncall);
        imgbtnchat=(ImageButton)findViewById(R.id.imgbtnchat);
        imgbtnemail=(ImageButton)findViewById(R.id.imgbtnemail);


        txtemail.setText(objbean.getEmailid());
        txtfname.setText(objbean.getFirstName());
        txtlname.setText(objbean.getLastName());
        txtdob.setText(objbean.getDob());
        txtaddress.setText(objbean.getAddress());
        txtphone.setText(objbean.getContact());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle.putSerializable("bean",objbean);
                Intent intent = new Intent(activity_view.this, EditContacts.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        imgbtncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_DIAL);


                intent.setData(Uri.parse("tel:"+objbean.getContact()));
                startActivity(intent);
            }
        });

        imgbtnchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:"+objbean.getContact()));
                startActivity(intent);
            }
        });
        imgbtnemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{objbean.getEmailid()});
                email.putExtra(Intent.EXTRA_SUBJECT, "subject");
                email.putExtra(Intent.EXTRA_TEXT,"message");


                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });


    }


}
