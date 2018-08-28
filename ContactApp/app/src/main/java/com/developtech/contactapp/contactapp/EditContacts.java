package com.developtech.contactapp.contactapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.developtech.contactapp.R;
import com.developtech.contactapp.beans.ContactBean;
import com.developtech.contactapp.services.ContactAppServices;

/**
 * Created by Attinder on 25/03/16.
 */
public class EditContacts extends AppCompatActivity {

    private EditText etfname,etlname,etdob,etcontact,etemail,etaddress;
    private Button btnsave,btnreset,btncancel;
    ContactBean objbean=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_add_contact);
       Bundle bundle=getIntent().getExtras();
       objbean=(ContactBean)bundle.getSerializable("bean");
        initComponents();
    }



    private void initComponents()
    {
        etfname=(EditText)findViewById(R.id.etfname);
        etcontact=(EditText)findViewById(R.id.etcontact);
        etemail=(EditText)findViewById(R.id.etemail);
        etaddress=(EditText)findViewById(R.id.etaddress);
        etdob=(EditText)findViewById(R.id.etdob);
        etlname=(EditText)findViewById(R.id.etlname);

        etfname.setText(objbean.getFirstName());
        etlname.setText(objbean.getLastName());
        etaddress.setText(objbean.getAddress());
        etcontact.setText(objbean.getContact());
        etdob.setText(objbean.getDob());
        etemail.setText(objbean.getEmailid());



        objbean.setContact(etcontact.getText().toString());
        objbean.setContact(etemail.getText().toString());
        objbean.setContact(etaddress.getText().toString());
        objbean.setContact(etdob.getText().toString());
        objbean.setContact(etlname.getText().toString());
        objbean.setContact(etfname.getText().toString());


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean flag= ContactAppServices.editContact(objbean);

                if (flag)
                {

                    Toast.makeText(EditContacts.this,"Contact Updated",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(EditContacts.this,"Sorry!!",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
