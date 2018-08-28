package com.developtech.sharewave.sharewave.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.developtech.sharewave.sharewave.R;
import com.developtech.sharewave.sharewave.common.Utility;
import com.developtech.sharewave.sharewave.common.database.DatabaseServices;
import com.developtech.sharewave.sharewave.common.database.EmpBean;
import com.developtech.sharewave.sharewave.signin.SignIn;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SignUp extends AppCompatActivity {
    private EditText etusername,etpassword,etemail,etmobilenumber;
    private Button btnsignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initComponets();

    }

    private void initComponets()
    {
        etemail=(EditText)findViewById(R.id.etemail);
        etmobilenumber=(EditText)findViewById(R.id.etmobilenumber);
        etpassword=(EditText)findViewById(R.id.etpassword);
        etusername=(EditText)findViewById(R.id.etusername);

        btnsignup=(Button)findViewById(R.id.btnsignup);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmpBean empBean=new EmpBean();
                empBean.setContact(etmobilenumber.getText().toString());
                empBean.setEmail(etemail.getText().toString());
                empBean.setName(etusername.getText().toString());
                empBean.setPassword(etpassword.getText().toString());



                DatabaseServices databaseServices=new DatabaseServices(SignUp.this);
                if (databaseServices.addUser(empBean))
                {
                    Utility.showToastMessage(SignUp.this,"Record Added");

                    Intent intent=new Intent(SignUp.this, SignIn.class);
                    startActivity(intent);

                }
                else
                {
                    Utility.showToastMessage(SignUp.this,"Some Problem!!");
                }

            }
        });



    }
}
