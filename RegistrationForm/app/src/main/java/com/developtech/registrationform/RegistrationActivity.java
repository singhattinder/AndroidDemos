package com.developtech.registrationform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistrationActivity extends AppCompatActivity {

    private Button btsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
initComponents();
    }

    private void initComponents()
    {
        btsubmit=(Button)findViewById(R.id.btsubmit);

        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putString("data","Stingsending");
                b.putInt("numeric",1);

                Intent intent=new Intent(RegistrationActivity.this,Next.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });


    }
}
