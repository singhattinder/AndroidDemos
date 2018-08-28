package com.developtech.sqliteapp.Adapters;

import android.content.Context;
import android.content.Loader;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.developtech.sqliteapp.R;
import com.developtech.sqliteapp.beans.EmpBean;

import java.util.ArrayList;

/**
 * Created by Attinder on 06/04/16.
 */
public class ListView_Adapter extends ArrayAdapter<EmpBean> {

    public Context ctx;
    private ArrayList<EmpBean> alc=null;
    public ListView_Adapter(Context context,int resource,ArrayList al){
        super(context,resource,al);
        ctx=context;
        alc=al;

    }

    private Bitmap StringToBitMap(String encodedString){
        try{
            byte [] encodeByte= Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflator=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v= inflator.inflate(R.layout.rowlayout_view, parent,false);
        TextView name=(TextView)v.findViewById(R.id.txtname);
        TextView phone=(TextView)v.findViewById(R.id.txtphone);
        ImageView img=(ImageView)v.findViewById(R.id.imgrow);
        EmpBean objbean=(EmpBean)alc.get(position);
        Bitmap bm=StringToBitMap(objbean.getProfilePic());
        img.setImageBitmap(bm);
        name.setText(objbean.getName());
        phone.setText(objbean.getContact());
        return v;
    }
}
