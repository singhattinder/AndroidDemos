package com.developtech.sharewave.sharewave.common;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

/**
 * Created by Attinder on 28/04/16.
 */
public class Utility {

    //alert box,toast,current date time, image pick,keyboard hide etc.

    //methos keyboardHide,

    public static void hideKeyboard(Activity activity) {


        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void showToastMessage(Context ct,String str)
    {

        Toast.makeText(ct,str,Toast.LENGTH_SHORT).show();


    }

    public static void showAlertBox()
    {


    }

    public static void showAlertMessage()
    {


    }

    public static boolean isNetworkAvailable(Context con)
    {

        ConnectivityManager cm =(ConnectivityManager)con.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();

    }
}
