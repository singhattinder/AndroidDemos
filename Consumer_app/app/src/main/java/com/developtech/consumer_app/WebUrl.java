package com.developtech.consumer_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Attinder on 22/04/16.
 */
public class WebUrl extends AppCompatActivity {


    public static final String baseUrl="http://androidap.developtechtutorial.com/androidap/FileHiderService.svc";
    public static final String GET_GETINSTALLS ="/GetInstalls";

}
