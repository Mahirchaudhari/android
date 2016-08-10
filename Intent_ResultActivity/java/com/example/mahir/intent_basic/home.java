package com.example.mahir.intent_basic;

import android.app.Activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class home extends Activity {
    TextView uid,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        uid = (TextView)findViewById(R.id.tvuserid);
        add = (TextView)findViewById(R.id.tvaddress);

        Bundle b = this.getIntent().getExtras();
        String value1 = b.getString("value1");
        String value2 = b.getString("value2");
        uid.setText(value1);
        add.setText(value2);
        Toast.makeText(getApplicationContext(),"Values are:\n First value: "+value1+
                "\n Second Value: "+value2,Toast.LENGTH_LONG).show();


    }
}
