package com.developtech.login_web_services;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Login_activity extends AppCompatActivity {

    private EditText etusername,etpassword;
    private Button btnlogin;
    ProgressBar pb;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        initComponents();
    }

    private void initComponents()
    {
        etpassword=(EditText)findViewById(R.id.etpassword);
        etusername=(EditText)findViewById(R.id.etusername);
        btnlogin=(Button) findViewById(R.id.btnlogin);
        layout=(LinearLayout)findViewById(R.id.layout);
        pb=(ProgressBar)findViewById(R.id.progressBar);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layout.setVisibility(View.GONE);
                pb.setVisibility(View.VISIBLE);

                try {
                    RestClient rc = new RestClient();

                    APIs ap = rc.getClient(WebUrl.baseUrl);
                    JsonObject objJson = new JsonObject();
                    objJson.addProperty("usr", etusername.getText().toString().trim());
                    objJson.addProperty("pwd", etpassword.getText().toString().trim());
                    ap.authuser(objJson, new Callback<String>() {
                                @Override
                                public void success(String s, Response response) {


                                    Toast.makeText(Login_activity.this,s,Toast.LENGTH_SHORT).show();
                                    pb.setVisibility(View.INVISIBLE);

                                }

                                @Override
                                public void failure(RetrofitError retrofitError) {


                                    Toast.makeText(Login_activity.this,String.valueOf(retrofitError),Toast.LENGTH_SHORT).show();
                                    pb.setVisibility(View.INVISIBLE);
                                }
                            }
                    );
                }
                catch (Exception e)
                {

                }



            }
        });

    }
}
