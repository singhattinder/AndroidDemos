package com.developtech.sharewave.sharewave.common.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Attinder on 04/05/16.
 */
public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="user.db";

    public static final String  TABLE_NAME="userdata";

    private static final int DATABASE_VERSION=1;

    private static final String CREATE_TABLE="create table userdata(_id integer primary key AUTOINCREMENT,username text,contact text,email text,password text,profilepic text)";



    public DatabaseOpenHelper(Context context)
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
