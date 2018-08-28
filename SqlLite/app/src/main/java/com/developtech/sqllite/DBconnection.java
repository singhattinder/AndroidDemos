package com.developtech.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Attinder on 04/04/16.
 */
public class DBconnection extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="sqlite.db";
    public static final int DATABASE_VERSION=2;
    public static final String TABLE_NAME="ems";
    public static final String VARIABLE_NAME="name";
    public static final String VARIABLE_SALARY="sal";
    public static final String VARIABLE_ID="id";
    public static final String CREATE_TABLE="create table ems(id int,name string,sal string)";
    Context con=null;

    //int,text,String,blob

    public DBconnection(Context context)
    {

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        con=context;
        Utility.showMessage(con,"constructor");


    }
    
    
    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            db.execSQL(CREATE_TABLE);
        }
        catch (Exception e)
        {
            Log.d("test",String.valueOf(e));
        }

        Utility.showMessage(con,"on create");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Utility.showMessage(con,"on upgrade");
    }
}
