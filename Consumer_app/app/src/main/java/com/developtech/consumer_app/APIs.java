package com.developtech.consumer_app;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Attinder on 21/04/16.
 */
public interface APIs {

    @GET(WebUrl.GET_GETINSTALLS)

    public void getInstall( Callback<JsonObject> result);

}
