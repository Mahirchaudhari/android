package com.example.mahir.intent_basic;

import android.app.Activity;
import android.database.CursorJoiner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {

    Button login,submit,OTP;
    TextView username,password;
    EditText Edtusername,Edtpassword;
    Context ctx = this;
    int userid = 100;
    String address = "102,bhavnagar";



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button)findViewById(R.id.btlogin);
        submit = (Button)findViewById(R.id.btsubmit);
        OTP = (Button)findViewById(R.id.btOTP);
        username = (TextView)findViewById(R.id.txtusernmae);
        password =  (TextView)findViewById(R.id.txtpassword);
        Edtusername = (EditText)findViewById(R.id.edtusername);
        Edtpassword = (EditText)findViewById(R.id.edtpassword);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx,register.class);
                ctx.startActivity(intent);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Edtusername.getText().toString().equals("admin") && Edtpassword.getText().toString().equals("12345")){
                Intent intent = new Intent(ctx,home.class);
                    intent.putExtra("value1","Hello mahir");
                    intent.putExtra("value2","mahir id");
                ctx.startActivity(intent);
                }
            }
        });
        OTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx,otp.class);
                login.this.startActivityForResult(intent,1);
                
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == 999 && data!= null){
            String random_value = data.getStringExtra("random_value");
           OTP.setText(random_value);
        }
    }



}
