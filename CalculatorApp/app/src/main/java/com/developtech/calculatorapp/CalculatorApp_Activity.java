package com.developtech.calculatorapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorApp_Activity extends Activity  {

    private EditText etFirstNo,etSecondNo;
    private Button btnadd;
    private Button btndiv;
    private  Button btnsub;
    private Button btnmul;
    private TextView tvresult;





    private void initComponents()
    {
        etFirstNo=(EditText)findViewById(R.id.etfirstnumber);
        etSecondNo=(EditText)findViewById(R.id.etsecondnumber);
        btnadd=(Button)findViewById(R.id.btnadd);
        btndiv=(Button)findViewById(R.id.btndiv);
        btnmul=(Button)findViewById(R.id.btnmul);
        btnsub=(Button)findViewById(R.id.btnsub);
        tvresult=(TextView)findViewById(R.id.tvresult);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etFirstNo.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(CalculatorApp_Activity.this,"Enter First number",Toast.LENGTH_SHORT).show();

                }
                else if(etSecondNo.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(CalculatorApp_Activity.this,"Enter Second Number",Toast.LENGTH_SHORT).show();

                }

                else {

                    int num1 = Integer.parseInt(etFirstNo.getText().toString().trim());
                    int num2 = Integer.parseInt(etSecondNo.getText().toString().trim());
                    tvresult.setText(String.valueOf(num1 + num2));
                }
            }
        }
        );


        btnsub.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          if(etFirstNo.getText().toString().trim().isEmpty())
                                          {
                                              Toast.makeText(CalculatorApp_Activity.this,"Enter First number",Toast.LENGTH_SHORT).show();

                                          }
                                          else if(etSecondNo.getText().toString().trim().isEmpty())
                                          {
                                              Toast.makeText(CalculatorApp_Activity.this,"Enter Second Number",Toast.LENGTH_SHORT).show();

                                          }

                                          else {

                                              int num1 = Integer.parseInt(etFirstNo.getText().toString().trim());
                                              int num2 = Integer.parseInt(etSecondNo.getText().toString().trim());
                                              tvresult.setText(String.valueOf(num1 - num2));
                                          }
                                      }
                                  }
        );


        btnmul.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          if(etFirstNo.getText().toString().trim().isEmpty())
                                          {
                                              Toast.makeText(CalculatorApp_Activity.this,"Enter First number",Toast.LENGTH_SHORT).show();

                                          }
                                          else if(etSecondNo.getText().toString().trim().isEmpty())
                                          {
                                              Toast.makeText(CalculatorApp_Activity.this,"Enter Second Number",Toast.LENGTH_SHORT).show();

                                          }

                                          else {

                                              int num1 = Integer.parseInt(etFirstNo.getText().toString().trim());
                                              int num2 = Integer.parseInt(etSecondNo.getText().toString().trim());
                                              tvresult.setText(String.valueOf(num1 * num2));
                                          }
                                      }
                                  }
        );


        btndiv.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          if(etFirstNo.getText().toString().trim().isEmpty())
                                          {
                                              Toast.makeText(CalculatorApp_Activity.this,"Enter First number",Toast.LENGTH_SHORT).show();

                                          }
                                          else if(etSecondNo.getText().toString().trim().isEmpty())
                                          {
                                              Toast.makeText(CalculatorApp_Activity.this,"Enter Second Number",Toast.LENGTH_SHORT).show();

                                          }

                                          else {

                                              int num1 = Integer.parseInt(etFirstNo.getText().toString().trim());
                                              int num2 = Integer.parseInt(etSecondNo.getText().toString().trim());
                                              tvresult.setText(String.valueOf(num1 / num2));
                                          }
                                      }
                                  }
        );

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatorapp);
initComponents();
    }
}
