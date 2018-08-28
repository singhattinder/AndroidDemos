package com.developtech.sqliteapp.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.developtech.sqliteapp.beans.EmpBean;

import java.util.ArrayList;

/**
 * Created by Attinder on 05/04/16.
 */
public class EmpServices  {

    EmployeOpenHelper helper=null;
    SQLiteDatabase db=null;


    public EmpServices(Context con)
    {
        helper=new EmployeOpenHelper(con);
        db=helper.getWritableDatabase();
    }


    public ArrayList getAllEmployee()
    {
        ArrayList<EmpBean> lst=null;
        Cursor cursor=null;
        EmpBean objbean=null;

        try {
            lst=new ArrayList<>();
           cursor=db.query(EmployeOpenHelper.TABLE_NAME,null,null,null,null,null,null);
           while (cursor.moveToNext())
           {
               objbean=new EmpBean();
               objbean.setId(cursor.getInt(cursor.getColumnIndex("_id")));
               objbean.setName(cursor.getString(cursor.getColumnIndex("username")));
               objbean.setContact(cursor.getString(cursor.getColumnIndex("contact")));
               objbean.setDob(cursor.getString(cursor.getColumnIndex("dob")));
               objbean.setEmail(cursor.getString(cursor.getColumnIndex("email")));
               objbean.setPassword(cursor.getString(cursor.getColumnIndex("password")));
               objbean.setBr(cursor.getInt(cursor.getColumnIndex("br")));
               objbean.setProfilePic(cursor.getString(cursor.getColumnIndex("profilepic")));
               lst.add(objbean);

           }

        }

        catch (Exception e)
        {
            System.out.print(e);
        }

        finally {
            cursor.close();
        }
        return lst;
    }


    public boolean authUser(String user,String pwd)
    {
        try {
            String ar[] = new String[1];
            ar[0] = user;
            Cursor cursor=db.rawQuery("select password from empmaster where username=?", ar);
            if(cursor.moveToNext())
            {
                if (cursor.getString(cursor.getColumnIndex("password")).equals(pwd))
                {
                    return true;
                }

            }

        }
        catch (Exception e)
        {

            System.out.print(e);
        }
        finally {
            db.close();
        }

        return false;
    }

    public boolean addUser(EmpBean objbean)
    {
        ContentValues cv=null;
        try
        {
            cv=new ContentValues();
            cv.put("username",objbean.getName());
            cv.put("contact",objbean.getContact());
            cv.put("dob",objbean.getDob());
            cv.put("email", objbean.getEmail());
            Long i = db.insert(EmployeOpenHelper.TABLE_NAME,"_id",cv);
            if(i>0)
            {
                return true;
            }

        }

        catch(Exception e)
        {
            System.out.print(e);
        }

        return false;
    }

}
