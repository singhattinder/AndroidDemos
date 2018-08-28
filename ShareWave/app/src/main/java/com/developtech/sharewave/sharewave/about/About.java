package com.developtech.sharewave.sharewave.about;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.developtech.sharewave.sharewave.R;

/**
 * Created by Attinder on 22/04/16.
 */
public class About extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

    }
}
