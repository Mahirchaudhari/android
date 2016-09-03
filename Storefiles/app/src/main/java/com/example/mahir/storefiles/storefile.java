package com.example.mahir.storefiles;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class storefile extends Activity {
     EditText edtfilename,edtcontain;
     RadioButton rbtphone,rbtsdcard;
     Button btstore,btread;
    Context ctx = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storefile);
        allocation();
        btstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataStorage storage = new DataStorage(ctx);
                boolean iserror = true;
                if (rbtphone.isChecked()==true){
                    iserror = storage.writeinphone(edtfilename.getText().toString(),edtcontain.getText().toString());
                }
                else if (rbtsdcard.isChecked() == true){
                    iserror = storage.writeinsdcard(edtfilename.getText().toString(),edtcontain.getText().toString());
                }
                if (iserror == false){
                    edtfilename.setText("");
                    edtcontain.setText("");
                    Toast.makeText(ctx,"file created",Toast.LENGTH_SHORT);
                }
                else
                    Toast.makeText(ctx,"file not created",Toast.LENGTH_SHORT);
            }
        });
        btread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataStorage storage = new DataStorage(ctx);
                String filecontain = null;
                if (rbtphone.isChecked() == true){
                    filecontain = storage.readfromphone(edtfilename.getText().toString());
                }
                else if (rbtsdcard.isChecked() == true){
                    filecontain = storage.readfromsdcard(edtfilename.getText().toString());
                }
                if (filecontain != null){
                    edtcontain.setText(filecontain);
                }
            }
        });

        rbtphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbtphone.setChecked(true);
                rbtsdcard.setChecked(false);
            }
        });
        rbtsdcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbtphone.setChecked(false);
                rbtsdcard.setChecked(true);
            }
        });
    }
    public void allocation(){

        edtfilename = (EditText)this.findViewById(R.id.edtfilename);
        edtcontain = (EditText) this.findViewById(R.id.edtcontain);
        rbtphone = (RadioButton) this.findViewById(R.id.rbtphone);
        rbtsdcard = (RadioButton) this.findViewById(R.id.rbtsdcard);
        btstore = (Button) this.findViewById(R.id.btstore);
        btread = (Button) this.findViewById(R.id.btread);
    }
}
