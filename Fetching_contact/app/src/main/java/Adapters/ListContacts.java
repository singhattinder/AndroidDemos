package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import com.developtech.fetching_contact.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Beans.EmpBean;

/**
 * Created by Attinder on 19/04/16.
 */
public class ListContacts extends ArrayAdapter<ArrayList> {


    private Context ctx;
    private ArrayList<EmpBean> alc=null;

    public ListContacts(Context context, int resource, ArrayList al)
    {
        super(context,resource,al);
        ctx=context;
        alc=al;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.row_layout,parent,false);
        TextView txtname=(TextView)v.findViewById(R.id.txtname);
        TextView txtphone=(TextView)v.findViewById(R.id.txtphone);
        TextView txtemail=(TextView)v.findViewById(R.id.txtemail);
        EmpBean objbean=alc.get(position);

        txtname.setText(objbean.getName());
        txtphone.setText(objbean.getNumber());
        txtemail.setText(objbean.getEmail());
        return v;

    }
}
