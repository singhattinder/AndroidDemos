package com.developtech.sqllite;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Attinder on 04/04/16.
 */
public class Utility {

    public static void showMessage(Context context,String message)
    {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
