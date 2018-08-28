package com.developtech.contactapp.services;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.developtech.contactapp.beans.ContactBean;
import com.developtech.contactapp.contactapp.ListContacts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Attinder on 25/03/16.
 */
public class ContactAppServices {

    static private ArrayList<ContactBean> al=null;
    static private int id=0;
    static
    {
        Log.d("key","test");

        File f = new File("abc.txt");
        if(!f.exists())
        {
            al=new ArrayList<ContactBean>();
        }
        else {
            try {

           /* ContactBean objbean=new ContactBean();
            objbean.setContact_id(id);
            objbean.setContact("9888");
            objbean.setAddress("asdsdasd");
            objbean.setEmailid("email");
            objbean.setDob("3/1/11");
            objbean.setFirstName("Attinder");
            al.add(objbean);

*/


                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                al = (ArrayList<ContactBean>) (ois.readObject());
            } catch (Exception e) {

            }
        }

    }

    static public boolean  onExit(Context ctx)
    {
        FileOutputStream fos=null;

        try{


            fos=ctx.openFileOutput("abc.txt",Context.MODE_PRIVATE);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(al);
            oos.flush();
            return true;
        }
        catch (Exception e)
        {

        }

return false;
    }

    static public boolean addContact(ContactBean objbean)
    {

        id++;
        objbean.setContact_id(id);
        al.add(objbean);
        return true;

    }

    static public ArrayList getAll()
    {

        return al;

    }



    static  public ArrayList searchByName(String name) {

        ArrayList<ContactBean> alnew=new ArrayList<>();

        for (int i = 0; i <= al.size(); i++)
        {
            ContactBean objbean=al.get(i);
            if(objbean.getFirstName().toLowerCase().contains(name))
            {
                alnew.add(objbean);
            }
        }

        return alnew;
    }

    static public boolean deleteById(int id)
    {
        ContactBean objbean= al.get(id);
        int iddelete=al.indexOf(objbean);
        al.remove(iddelete);
        return  true;

    }

    static public ContactBean getById(int id)
    {
        ContactBean objbean=al.get(id);
        return objbean;


    }

    static public boolean editContact(ContactBean objbean)
    {
        for(int i=0;i<al.size();i++)
        {
            ContactBean obj=al.get(i);
            if(obj.getContact_id()==objbean.getContact_id())
            {
                al.indexOf(obj);
                al.remove(obj);
                al.add(objbean);
                return true;
            }


        }


        return false;

    }
}
