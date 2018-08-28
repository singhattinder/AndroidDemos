package com.developtech.primeevenodd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Prime_Activity extends AppCompatActivity {

    private RadioGroup rg;

    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);
        initComponents();
    }

    private void initComponents()
    {
        rb1=(RadioButton)findViewById(R.id.rb1);
        rb2=(RadioButton)findViewById(R.id.rb2);
        rb3=(RadioButton)findViewById(R.id.rb3);
        rg=(RadioGroup)findViewById(R.id.rg);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {



                switch (checkedId)
                {
                    case R.id.rb1:
                        Toast.makeText(Prime_Activity.this,"Even is Selected",Toast.LENGTH_SHORT).show();

                        break;

                    case R.id.rb2:
                        Toast.makeText(Prime_Activity.this,"Odd is Selected",Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.rb3:
                        Toast.makeText(Prime_Activity.this,"Prime is Selected",Toast.LENGTH_SHORT).show();

                        break;



                }

            }
        });


    }
}
