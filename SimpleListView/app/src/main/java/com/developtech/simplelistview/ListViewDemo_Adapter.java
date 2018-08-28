package com.developtech.simplelistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Attinder on 25/03/16.
 */
public class ListViewDemo_Adapter extends ArrayAdapter<String> {

    public Context ctx;
    public String[] data1;
    public ListViewDemo_Adapter(Context context,int resource,String[] data){
        super(context,resource,data);
        ctx=context;
        data1=data;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflator=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View v= inflator.inflate(R.layout.rowlayout_activity_simple_list, parent,false);
        TextView txt1=(TextView)v.findViewById(R.id.txt1);
        txt1.setText(data1[position]);


        return v;
    }
}
