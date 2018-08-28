package com.developtech.sqliteapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.developtech.sqliteapp.Adapters.ListView_Adapter;
import com.developtech.sqliteapp.R;
import com.developtech.sqliteapp.beans.EmpBean;
import com.developtech.sqliteapp.services.EmpServices;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

private ListView listView=null;
    private ArrayList<EmpBean> al=null;
    private FloatingActionButton fab=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EmpServices emp=new EmpServices(ViewActivity.this);
        al=emp.getAllEmployee();
        initComponents();

        fab=(FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ViewActivity.this,AddActivity.class);
                startActivity(intent);
            }
        });


    }


    private void initComponents()
    {
        listView=(ListView)findViewById(R.id.listView);
        ListView_Adapter lva=new ListView_Adapter(ViewActivity.this,R.layout.rowlayout_view,al);
        listView.setAdapter(lva);

        SharedPreferences sp=getSharedPreferences("exit", MODE_PRIVATE);
        SharedPreferences.Editor e=sp.edit();
        e.putInt("data",1);
        e.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.logout:
            {
                SharedPreferences sp=getSharedPreferences("exit", MODE_PRIVATE);
                SharedPreferences.Editor e=sp.edit();
                e.putInt("data", 0);
                e.commit();
                Intent intent=new Intent(ViewActivity.this,Login_activity.class);
                startActivity(intent);
                break;

            }




            case R.id.about:
            {
                Toast.makeText(ViewActivity.this,"ABOUT",Toast.LENGTH_SHORT).show();
            }

        }

        return super.onOptionsItemSelected(item);
    }
}
