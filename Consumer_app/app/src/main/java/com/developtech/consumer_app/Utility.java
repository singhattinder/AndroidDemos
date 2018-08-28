package com.developtech.consumer_app;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

/**
 * Created by Attinder on 22/04/16.
 */
public class Utility {

    public static boolean isNetworkAvail(Context ctx)
    {

        ConnectivityManager connectivityManager= ((ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE));

        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

        if(networkInfo!=null)
        {
            return networkInfo.isConnected();

        }
        return false;
    }
}
