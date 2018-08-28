package com.developtech.contactapp.contactapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.developtech.contactapp.Adapters.ListViewAdpater;
import com.developtech.contactapp.R;
import com.developtech.contactapp.beans.ContactBean;
import com.developtech.contactapp.services.ContactAppServices;

import java.util.ArrayList;


/**
 * Created by Attinder on 25/03/16.
 */
public class ListContacts extends AppCompatActivity implements  TextWatcher,AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener{


    private ListView listView;
    private EditText etsearch;
    private ArrayList<ContactBean> al=null;

    private FloatingActionButton fabadd;
    ListViewAdpater lva=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_contacts);

        al= ContactAppServices.getAll();
        initComponents();
    }


    private void initComponents()


    {

        etsearch=(EditText)findViewById(R.id.etsrch);
        etsearch.addTextChangedListener(this);


        Log.d("test", String.valueOf(al.size()));

        fabadd=(FloatingActionButton)findViewById(R.id.fabadd);
        listView=(ListView)findViewById(R.id.listview);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);

        lva=new ListViewAdpater(ListContacts.this,R.layout.rowlayout_all_contents,al);
        listView.setAdapter(lva);

        fabadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListContacts.this, AddContactActivity.class);
                startActivity(intent);
            }
        });




    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }




    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        String name=s.toString();
        al=ContactAppServices.searchByName(name);
        Log.d("test",name);
        ListViewAdpater lva=new ListViewAdpater(ListContacts.this,R.layout.rowlayout_all_contents,al);
        listView.setAdapter(lva);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        ContactBean objbean= ContactAppServices.getById(position);
        Bundle bundle=new Bundle();
        bundle.putSerializable("bean",objbean);

        Intent intent=new Intent(ListContacts.this,activity_view.class);
        intent.putExtras(bundle);
        startActivity(intent);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ContactAppServices.onExit(ListContacts.this);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

        AlertDialog.Builder alertdialog=new AlertDialog.Builder(ListContacts.this);

        alertdialog.setIcon(R.mipmap.ic_launcher);
        alertdialog.setTitle("Delete Contact");
        alertdialog.setMessage("Do you want to delete this?");
        alertdialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                boolean flag = ContactAppServices.deleteById(position);
                if (flag) {
                    Toast.makeText(ListContacts.this, "Contact deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ListContacts.this, "Error", Toast.LENGTH_SHORT).show();
                }
                lva.notifyDataSetChanged();

            }
        });


        alertdialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });

        alertdialog.show();
        return true;

    }
}
