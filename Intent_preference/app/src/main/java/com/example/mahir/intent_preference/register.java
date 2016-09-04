package com.example.mahir.intent_preference;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mahir.intent_preference.mylib.DataStorage;

public class register extends Activity {
    DataStorage storage;
    Button btsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        btsubmit = (Button) this.findViewById(R.id.btsubmit);
        storage = new DataStorage("easylearn",this);

        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storage.write("register_status",true);
                Intent intent = new Intent(register.this,login_Activity.class);
                register.this.startActivity(intent);
                register.this.finish();
            }
        });

    }
}
