package com.developtech.kryoclient;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Attinder on 24/04/16.
 */
public class ToastDisplay {

    public static void ToastD(Context ctx,String e)
    {
        Toast.makeText(ctx,e,Toast.LENGTH_SHORT).show();
    }
}
