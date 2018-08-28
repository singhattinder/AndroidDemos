package com.developtech.contactapp.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;

import com.developtech.contactapp.R;
import com.developtech.contactapp.beans.ContactBean;

import java.util.ArrayList;

/**
 * Created by Attinder on 26/03/16.
 */
public class ListViewAdpater extends ArrayAdapter<ContactBean> {

    private Context ctx;
    private ArrayList<ContactBean> alc=null;

    public ListViewAdpater(Context context,int resource,ArrayList al)
    {
        super(context,resource,al);
        ctx=context;
        alc=al;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.rowlayout_all_contents,parent,false);
        TextView txtname=(TextView)v.findViewById(R.id.txtname);
        TextView txtphone=(TextView)v.findViewById(R.id.txtphone);
        ContactBean objbean=(ContactBean)alc.get(position);
        txtname.setText(objbean.getFirstName());
        txtphone.setText(objbean.getContact());
        return v;

    }
}
