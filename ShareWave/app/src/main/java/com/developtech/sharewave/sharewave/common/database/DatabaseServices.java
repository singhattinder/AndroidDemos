package com.developtech.sharewave.sharewave.common.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.developtech.sharewave.sharewave.common.database.DatabaseOpenHelper;

import java.util.ArrayList;

/**
 * Created by Attinder on 04/05/16.
 */
public class DatabaseServices {

    DatabaseOpenHelper helper=null;
    SQLiteDatabase db=null;


    public DatabaseServices(Context con)
    {
        helper=new DatabaseOpenHelper(con);
        db=helper.getWritableDatabase();
    }


    public ArrayList getAllEmployee()
    {
        ArrayList<EmpBean> lst=null;
        Cursor cursor=null;
        EmpBean objbean=null;

        try {
            lst=new ArrayList<>();
            cursor=db.query(DatabaseOpenHelper.TABLE_NAME,null,null,null,null,null,null);
            while (cursor.moveToNext())
            {
                objbean=new EmpBean();
                objbean.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                objbean.setName(cursor.getString(cursor.getColumnIndex("username")));
                objbean.setContact(cursor.getString(cursor.getColumnIndex("contact")));
                objbean.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                objbean.setPassword(cursor.getString(cursor.getColumnIndex("password")));
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
            Cursor cursor=db.rawQuery("select password from userdata where username=?", ar);
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
            cv.put("email", objbean.getEmail());
            cv.put("password",objbean.getPassword());


            Long i = db.insert(DatabaseOpenHelper.TABLE_NAME,"_id",cv);
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


    public EmpBean getUser(int id)
    {

        ArrayList<EmpBean> arrayList=getAllEmployee();
        for (int i=0;i<arrayList.size();i++)
        {
            EmpBean objbean=arrayList.get(i);
            if (objbean.getId()==id)
            {
                return objbean;
            }
            else
            {
                return null;
            }

        }


        return null;

    }

}
