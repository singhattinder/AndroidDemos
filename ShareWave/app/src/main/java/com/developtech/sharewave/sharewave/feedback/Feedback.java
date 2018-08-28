package com.developtech.sharewave.sharewave.feedback;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.developtech.sharewave.sharewave.R;

/**
 * Created by Attinder on 22/04/16.
 */
public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
