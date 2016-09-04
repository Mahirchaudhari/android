package com.example.mahir.intent_preference;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mahir.intent_preference.mylib.DataStorage;

import org.w3c.dom.Text;

public class home extends Activity {
TextView tvid,tvadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        tvid = (TextView) this.findViewById(R.id.tvid);
        tvadd = (TextView) this.findViewById(R.id.tvadd);

        int id;
        String address;

        DataStorage storage = new DataStorage("easylearn",this);
        id =  Integer.parseInt(storage.read("userid",DataStorage.INTEGER).toString());
        String username =  storage.read("username",DataStorage.STRING).toString();

        tvid.setText(""+id);
        tvadd.setText(username);


    }
}
