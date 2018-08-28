package com.developtech.sqliteapp.services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Attinder on 05/04/16.
 */
public class EmployeOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="emp.db";

    public static final String  TABLE_NAME="empmaster";

    private static final int DATABASE_VERSION=1;

    private static final String CREATE_TABLE="create table empmaster(_id integer primary key AUTOINCREMENT,username text,contact text,dob text,br int,email text,password text,profilepic text)";

    // _ for primary key, integer for Autoincrement
    public EmployeOpenHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
