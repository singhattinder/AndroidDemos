package com.developtech.login_web_services;

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
public class WebUrl  {


    public static final String baseUrl="http://192.168.2.5:8080/Login_webservice/webresources/com";
    public static final String GET_GETINSTALLS ="/authuser";

}
