package com.developtech.sharewave.sharewave.manageprofile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ViewUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.developtech.sharewave.sharewave.R;
import com.developtech.sharewave.sharewave.about.About;
import com.developtech.sharewave.sharewave.common.Utility;
import com.developtech.sharewave.sharewave.icon.Icon;

/**
 * Created by Attinder on 22/04/16.
 */
public class ManageProfile extends AppCompatActivity {

    private Button btnselect_icon,btnsave_manage_profile;
    private EditText etusername_mp,etcurrentpassword_mp,etnewpassword_mp,etemail_mp,etphonenumber_mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initComponents();

    }

    private void initComponents()

    {
        btnsave_manage_profile=(Button)findViewById(R.id.btnsave_manage_profile);
        etcurrentpassword_mp=(EditText)findViewById(R.id.etcurrentpassword_mp);
        etemail_mp=(EditText)findViewById(R.id.etemail_mp);
        etnewpassword_mp=(EditText)findViewById(R.id.etnewpassword_mp);
        etphonenumber_mp=(EditText)findViewById(R.id.etphonenumber_mp);
        etusername_mp=(EditText)findViewById(R.id.etusername_mp);

btnselect_icon=(Button)findViewById(R.id.btnselect_icon);
        btnselect_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ManageProfile.this, Icon.class);
                startActivity(intent);
            }
        });


        btnsave_manage_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etusername_mp.getText().toString().isEmpty())
                {
                    Toast.makeText(ManageProfile.this,"Enter User Name",Toast.LENGTH_SHORT).show();
                }

               else if(etcurrentpassword_mp.getText().toString().isEmpty())
                {
                    Toast.makeText(ManageProfile.this,"Enter Current Password",Toast.LENGTH_SHORT).show();
                }

                else if(etnewpassword_mp.getText().toString().isEmpty())
                {
                    Toast.makeText(ManageProfile.this,"Enter New Password",Toast.LENGTH_SHORT).show();
                }

                else if(etemail_mp.getText().toString().isEmpty())
                {
                    Toast.makeText(ManageProfile.this,"Enter Email ID",Toast.LENGTH_SHORT).show();
                }

                else if(etphonenumber_mp.getText().toString().isEmpty())
                {
                    Toast.makeText(ManageProfile.this,"Enter Phone Number",Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(ManageProfile.this,"Everything is fine",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
