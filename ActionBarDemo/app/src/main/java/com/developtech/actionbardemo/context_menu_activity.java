package com.developtech.actionbardemo;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class context_menu_activity extends AppCompatActivity {

    private Button btn1;
    ProgressDialog dialog=null;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.sunday:
            {
                Toast.makeText(context_menu_activity.this,"Its sunday bro",Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.monday:
            {

                break;
            }
            case R.id.tuesday:
            {

               break;
            }


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_activity);

        btn1=(Button)findViewById(R.id.btn1);
        //btn1.setVisibility(View.GONE);
        registerForContextMenu(btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContextMenu(v);
                 dialog=new ProgressDialog(context_menu_activity.this);
                dialog.setTitle("Sunday is delayed bro");
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.show();

                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();

                    }
                },1000);




            }


        });


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {

            case R.id.sunday:
            {
                Toast.makeText(context_menu_activity.this,"Its sunday bro",Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.monday:
            {


                break;
            }
            case R.id.tuesday:
            {

                break;
            }

        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.main,menu);
    }
}
