package com.developtech.registrationform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Attinder on 18/03/16.
 */
public class Next extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Bundle b=getIntent().getExtras();
        String data=b.getString("data");
        int numeric=b.getInt("numeric");
        Toast.makeText(Next.this,data,Toast.LENGTH_SHORT).show();
        Toast.makeText(Next.this,String.valueOf(numeric),Toast.LENGTH_SHORT).show();
    }
}
