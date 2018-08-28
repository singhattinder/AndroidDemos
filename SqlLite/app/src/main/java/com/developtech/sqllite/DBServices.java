package com.developtech.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Attinder on 04/04/16.
 */
public class DBServices  {

    private SQLiteDatabase sqldata=null;
    private DBconnection dbcon=null;
    Context con=null;

    public DBServices(Context context)
    {
     dbcon=new DBconnection(context);
       sqldata=dbcon.getWritableDatabase();
        con=context;
    }

    public boolean addEmployee(EmpBean objbean)
    {
        ContentValues cvs=null; //like prepared stmt
        try{
            cvs=new ContentValues();
            String name=objbean.getName();
            int id=objbean.getId();
            String sal=objbean.getSal();

            cvs.put(DBconnection.VARIABLE_SALARY,sal);
            cvs.put(DBconnection.VARIABLE_NAME,name);
            cvs.put(DBconnection.VARIABLE_ID,id);



           Long i= sqldata.insert(DBconnection.TABLE_NAME, null, cvs); //null is if we dont want to add specific column

            if(i>0)
            {
            return true;}

        }

        catch (Exception e)
        {

            Log.d("test",String.valueOf(e));
        }
        finally {
            dbcon.close();

        }
        return false;
    }


}
