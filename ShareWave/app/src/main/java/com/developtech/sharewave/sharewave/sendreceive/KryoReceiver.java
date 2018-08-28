package com.developtech.sharewave.sharewave.sendreceive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.developtech.sharewave.sharewave.R;


public class KryoReceiver  {


   public KryoReceiver()
   {
       Log.i("app","client called");
       new ClientAsync().execute();
   }

   }
