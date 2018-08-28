package com.developtech.sharewave.sharewave.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;

import com.developtech.sharewave.sharewave.R;

import java.util.ArrayList;

/**
 * Created by Attinder on 01/05/16.
 */
public class AdapterSendReceive extends ArrayAdapter<ArrayList> {

    private Context ctx;
    private ArrayList<EmpBeanSendReceive> al;

    public AdapterSendReceive(Context context,int resource,ArrayList data) {
        super(context, resource,data);
        ctx=context;
        al=data;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflator=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v= inflator.inflate(R.layout.row_layout_send, parent,false);
      ImageView  btndelete=(ImageView)v.findViewById(R.id.btndelete);
        ScrollView btnscrollview=(ScrollView)v.findViewById(R.id.btnscrollView);
        TextView filesize=(TextView)v.findViewById(R.id.tvfilesizerowlayout);
        TextView sentdata=(TextView)v.findViewById(R.id.tvsentdatarowlayout);
        TextView name=(TextView)v.findViewById(R.id.tvnamerowlayout);
        ImageView imageView=(ImageView)v.findViewById(R.id.imgvrowlayout);
        EmpBeanSendReceive objbean=al.get(position);


        final int pos=position;

        btndelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                al.remove(pos);
                //or some other task
                notifyDataSetChanged();
            }
        });



        if(objbean.getType().equals("audio")){

        filesize.setText("Total Size: "+String.valueOf(objbean.getFilesize())+" MB");
        sentdata.setText("Sent Data: "+String.valueOf(objbean.getSentdata())+" MB");
            imageView.setImageResource(R.mipmap.music);
        name.setText(String.valueOf(objbean.getName()));}
        else if(objbean.getType().equals("image"))
        {
            filesize.setText("Total Size: "+String.valueOf(objbean.getFilesize())+" MB");
            sentdata.setText("Sent Data: "+String.valueOf(objbean.getSentdata())+" MB");
                imageView.setImageResource(R.mipmap.camera);
            name.setText(String.valueOf(objbean.getName()));
        }

        else if(objbean.getType().equals("video"))
        {
            filesize.setText("Total Size: "+String.valueOf(objbean.getFilesize())+" MB");
            sentdata.setText("Sent Data: "+String.valueOf(objbean.getSentdata())+" MB");
            imageView.setImageResource(R.mipmap.video);
            name.setText(String.valueOf(objbean.getName()));
        }
        return v;
    }
}
