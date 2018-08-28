package com.developtech.login_web_services;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Attinder on 22/04/16.
 */
public interface APIs {


   @POST(WebUrl.GET_GETINSTALLS)

    public void authuser(@Body JsonObject objJson, Callback<String> result);

}