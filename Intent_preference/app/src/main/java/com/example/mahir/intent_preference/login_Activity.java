package com.example.mahir.intent_preference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mahir.intent_preference.mylib.DataStorage;

public class login_Activity extends Activity {
    TextView tvuser,tvpass;
    EditText edtuser,edtpass;
    Button btlogin,btregister;
    Context ctx;
    DataStorage storage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        allocation();
        Log.d("TAG","hello");

        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtuser.getText().toString().equals("admin") && edtpass.getText().toString().equals("123123")){
                    String username = edtuser.getText().toString();
                    Intent intent = new Intent(ctx,home.class);
                    storage.write("username",username);
                    storage.write("userid",1);
                    storage.write("login_status",true);
                    ctx.startActivity(intent);
                    login_Activity.this.finish();
                }
            }
        });
        btregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx,register.class);
                ctx.startActivity(intent);

            }
        });

    }
    private void allocation() {
        ctx = this;
        storage = new DataStorage("easylearn",ctx);
        Log.d("TAG","helloin allocation");
        Boolean register_status = Boolean.parseBoolean(storage.read("register_status",DataStorage.BOOLEAN).toString());
        Boolean login_status = Boolean.parseBoolean(storage.read("login_status",DataStorage.BOOLEAN).toString());
        if (register_status == false){
            Log.d("TAG","helloregister");
            Intent intent = new Intent(ctx,register.class);
            ctx.startActivity(intent);
            login_Activity.this.finish();

        }
        else if (login_status == true){
            Intent intent = new Intent(ctx,home.class);
            ctx.startActivity(intent);
            login_Activity.this.finish();

        }

        tvuser = (TextView) this.findViewById(R.id.tvuser);
        tvpass = (TextView) this.findViewById(R.id.tvpass);
        edtuser = (EditText) this.findViewById(R.id.edtuser);
        edtpass = (EditText) this.findViewById(R.id.edtpass);
        btlogin = (Button) this.findViewById(R.id.btlogin);
        btregister = (Button) this.findViewById(R.id.btregister);

    }
}
