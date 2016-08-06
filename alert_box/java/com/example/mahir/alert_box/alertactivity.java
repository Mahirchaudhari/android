package com.example.mahir.alert_box;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class alertactivity extends AppCompatActivity {
    Button btone,bttwo,btthree,btdatepicker;
    Context ctx;
    private int year , month ,day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertactivity);
        allocation();
        btone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("This is one button alert box");
                builder.setMessage("Hello one");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx,"Button is clicked",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
        bttwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("This is two button alert box");
                builder.setMessage("Hello two");
                builder.setIcon(R.mipmap.ic_launcher);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx,"OK Button is clicked",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("CANCLE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx,"CANCLE Button is clicked",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        btthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("This is three button alert box");
                builder.setMessage("Hello three");
                builder.setIcon(R.mipmap.ic_launcher);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx,"OK Button is clicked",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("CANCLE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx,"CANCLE Button is clicked",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("May Be Later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx,"Maybe later Button is clicked",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        btdatepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog  dialog = new DatePickerDialog(ctx, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Toast.makeText(ctx,day+"-"+month+"-"+year,Toast.LENGTH_SHORT).show();
                    }
                },year,month,day);
                dialog.show();

            }
        });

    }
    private void allocation() {
        ctx =this;
        btone = (Button)findViewById(R.id.btone);
        bttwo = (Button)findViewById(R.id.bttwo);
        btthree = (Button)findViewById(R.id.btthree);
        btdatepicker = (Button)findViewById(R.id.btdatepicker);
        GregorianCalendar calendar = new GregorianCalendar();
        day = calendar.get(calendar.DAY_OF_MONTH);
        month = calendar.get(calendar.MONTH);
        year = calendar.get(calendar.YEAR);
    }
}
