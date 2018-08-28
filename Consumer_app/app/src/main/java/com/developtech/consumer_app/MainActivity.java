package com.developtech.consumer_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.internal.Streams;

import org.json.JSONObject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private EditText etusername,etpassword;
    private Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents()
    {



        etusername=(EditText)findViewById(R.id.etusername);
        etpassword=(EditText)findViewById(R.id.etpassword);
        btnlogin=(Button)findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
          /*

            @Override
            public void onClick(View v) {

                if(Utility.isNetworkAvail(MainActivity.this))
                {


                    try{
                        RestClient rc=new RestClient();

                        APIs ap=rc.getClient(WebUrl.baseUrl);
                        ap.getInstall(etusername.getText().toString().trim(), etpassword.getText().toString().trim(), new Callback<JsonObject>() {
                            @Override
                            public void success(JsonObject jsonObject, Response response) {
                                Toast.makeText(MainActivity.this,String.valueOf(jsonObject),Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void failure(RetrofitError retrofitError) {
                                Toast.makeText(MainActivity.this,String.valueOf(retrofitError),Toast.LENGTH_LONG).show();

                            }
                        });}
                    catch (Exception e)
                    {

                    }

                }



                else {

                    Toast.makeText(MainActivity.this,"Internet is not connected",Toast.LENGTH_SHORT).show();
                }

            }


            }
        */



            @Override
            public void onClick(View v) {


                if(Utility.isNetworkAvail(MainActivity.this))
                {


                    try{
                        RestClient rc=new RestClient();

                        APIs ap=rc.getClient(WebUrl.baseUrl);
                        ap.getInstall( new Callback<JsonObject>() {
                            @Override
                            public void success(JsonObject jsonObject, Response response) {
                                Toast.makeText(MainActivity.this,String.valueOf(jsonObject),Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void failure(RetrofitError retrofitError) {
                                Toast.makeText(MainActivity.this,String.valueOf(retrofitError),Toast.LENGTH_LONG).show();

                            }
                        });}
                    catch (Exception e)
                    {

                    }

                }



                else {

                    Toast.makeText(MainActivity.this,"Internet is not connected",Toast.LENGTH_SHORT).show();
                }




            }
                                    }
        );}
}
