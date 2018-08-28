package com.developtech.sharewave.sharewave.forgotpassword;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.developtech.sharewave.sharewave.R;



/**
 * Created by Attinder on 22/04/16.
 */
public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
