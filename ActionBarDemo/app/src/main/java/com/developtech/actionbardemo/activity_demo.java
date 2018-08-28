package com.developtech.actionbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class activity_demo extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_demo);

        btn1=(Button)findViewById(R.id.btn1);

    }


}
