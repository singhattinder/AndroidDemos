package com.developtech.contactapp.contactapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.developtech.contactapp.R;
import com.developtech.contactapp.beans.ContactBean;
import com.developtech.contactapp.services.ContactAppServices;

import java.util.ArrayList;

/**
 * Created by Attinder on 25/03/16.
 */
public class AddContactActivity extends AppCompatActivity {


    private Button save;
    private EditText firstname;
    private EditText lastname;
    private EditText contact;
    private EditText email;
    private EditText address;
    private EditText dob;
    boolean flag=false;
    ContactBean objbean=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_add_contact);
        initComponents();
    }

    private void initComponents()
    {
        save=(Button)findViewById(R.id.btnsave);
        firstname=(EditText)findViewById(R.id.etfname);
        lastname=(EditText)findViewById(R.id.etlname);
        contact=(EditText)findViewById(R.id.etcontact);
        email=(EditText)findViewById(R.id.etemail);
        address=(EditText)findViewById(R.id.etaddress);
        dob=(EditText)findViewById(R.id.etdob);



       save.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               objbean=new ContactBean();
               objbean.setFirstName(String.valueOf(firstname.getText()));
               objbean.setLastname(String.valueOf(lastname.getText()));
               objbean.setEmailid(String.valueOf(email.getText()));
               objbean.setDob(String.valueOf(dob.getText()));
               objbean.setContact(String.valueOf(contact.getText()));
               objbean.setAddress(String.valueOf(address.getText()));


               flag= ContactAppServices.addContact(objbean);
               if(flag)
               {
                   Toast.makeText(AddContactActivity.this,"Contact Added",Toast.LENGTH_SHORT).show();
                   Intent intent=new Intent(AddContactActivity.this,ListContacts.class);
                   startActivity(intent);
               }
               else
               {
                   Toast.makeText(AddContactActivity.this,"Try again",Toast.LENGTH_SHORT).show();
               }

           }
       });

    }


}
