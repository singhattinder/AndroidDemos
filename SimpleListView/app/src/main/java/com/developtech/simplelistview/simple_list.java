package com.developtech.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

public class simple_list extends AppCompatActivity {

    private ListView listView;
    private String[] s={"Monday","Tuesday","Wednesday","Thursday","Friday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);

        initComponents();
    }

    private void initComponents()
    {
        listView=(ListView)findViewById(R.id.listView);


        ListViewDemo_Adapter lva=new ListViewDemo_Adapter(simple_list.this,android.R.layout.simple_list_item_1,s);
        listView.setAdapter(lva);

    }
}
