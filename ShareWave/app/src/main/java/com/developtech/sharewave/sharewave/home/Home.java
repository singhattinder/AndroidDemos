package com.developtech.sharewave.sharewave.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.developtech.sharewave.sharewave.R;
import com.developtech.sharewave.sharewave.about.About;
import com.developtech.sharewave.sharewave.faq.Faq;
import com.developtech.sharewave.sharewave.feedback.Feedback;
import com.developtech.sharewave.sharewave.manageprofile.ManageProfile;
import com.developtech.sharewave.sharewave.send.Sender;
import com.developtech.sharewave.sharewave.sendreceive.KryoReceiver;

import java.util.ArrayList;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button btnsend_navigation,btnreceive_navigation;
    private ListView listView=null;
    private ImageView btndelete;
    private LinearLayout mRevealView;
    boolean hidden = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initComponents();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    private void initComponents()
    {
        listView=(ListView)findViewById(R.id.listView);
        btnsend_navigation=(Button)findViewById(R.id.btnsend_navigation);
        btnreceive_navigation=(Button)findViewById(R.id.btnreceive_navigation);
        btndelete=(ImageView)findViewById(R.id.btndelete);





        btnsend_navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Home.this,Sender.class);
                startActivity(intent);
            }
        });
        btnreceive_navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KryoReceiver k=new KryoReceiver();
                Toast.makeText(Home.this,"Receiving data",Toast.LENGTH_SHORT).show();


            }
        });

        ServiceSendReceive objbean=new ServiceSendReceive();
        ArrayList<EmpBeanSendReceive> arl=ServiceSendReceive.getSentList();
        System.out.println(arl.size());
        AdapterSendReceive asr=new AdapterSendReceive(Home.this,R.layout.row_layout_send,arl);
        listView.setAdapter(asr);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_manage_profile) {
            Intent intent=new Intent(Home.this, ManageProfile.class);
            startActivity(intent);

        } else if (id == R.id.nav_feedback) {
            Intent intent=new Intent(Home.this, Feedback.class);
            startActivity(intent);

        } else if (id == R.id.nav_about) {
            Intent intent=new Intent(Home.this, About.class);
            startActivity(intent);

        } else if (id == R.id.nav_faq) {

            Intent intent=new Intent(Home.this, Faq.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
