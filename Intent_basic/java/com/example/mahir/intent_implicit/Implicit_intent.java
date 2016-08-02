package com.example.mahir.intent_implicit;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Implicit_intent extends AppCompatActivity {
    EditText num1, num2;
    Button call, url, location, dial ,camera;
    Context ctx = this;
    String lat, lng, loca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
        call = (Button) findViewById(R.id.btcall);
        url = (Button) findViewById(R.id.bturl);
        location = (Button) findViewById(R.id.btlocation);
        camera = (Button)findViewById(R.id.btcamera);
        dial = (Button) findViewById(R.id.btdial);
        num1 = (EditText) findViewById(R.id.edt1);
        num2 = (EditText) findViewById(R.id.edt2);

        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("" + num1.getText().toString()));
                ctx.startActivity(intent);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ num1.getText()));
                ctx.startActivity(intent);
            }
        });
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+num1.getText().toString()));
                ctx.startActivity(intent);
            }
        });
        location.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            lat = num1.getText().toString();
            lng = num2.getText().toString();
            loca =lat+","+lng;
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:"+loca));
                ctx.startActivity(intent);
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx,camera_bg.class);
                ctx.startActivity(intent);
            }
        });
    }
}
