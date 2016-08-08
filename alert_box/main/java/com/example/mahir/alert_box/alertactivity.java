package com.example.mahir.alert_box;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.GregorianCalendar;
import java.util.zip.Inflater;

public class alertactivity extends AppCompatActivity {
    Button btone, bttwo, btthree, btdatepicker, bttimepicker,btcustom,btnradio,btncheckbox;
    Context ctx;
    EditText edtname,edtkey;
    public int year, month, day,hr, min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertactivity);
        allocation();
        btone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("This is one button alert box");
                builder.setMessage("Hello one");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx, "Button is clicked", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(ctx, "OK Button is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("CANCLE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx, "CANCLE Button is clicked", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(ctx, "OK Button is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("CANCLE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx, "CANCLE Button is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("May Be Later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx, "Maybe later Button is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        btdatepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(ctx, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Toast.makeText(ctx, day + "-" + month + "-" + year, Toast.LENGTH_SHORT).show();
                    }
                }, year, month, day);
                dialog.show();

            }
        });
        bttimepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog pickerDialog = new TimePickerDialog(ctx, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hr, int min) {
                        Toast.makeText(ctx,hr+":"+min, Toast.LENGTH_SHORT).show();
                    }
                },hr,min,false);
                pickerDialog.show();
            }
        });
        btcustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(ctx);
                final View myview = inflater.inflate(R.layout.wifi,null);
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Wifi access");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setView(myview);

                builder.setPositiveButton("connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edtname = (EditText)myview.findViewById(R.id.edtname);
                        edtkey = (EditText) myview.findViewById(R.id.edtkey);
                        if (edtname.getText().toString().equals("admin") && edtkey.getText().toString().equals("123123")){
                                Toast.makeText(ctx,"Connected",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(ctx,"Username or password is wrong",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx,"disconnected",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        btnradio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                final String colorlist[] = ctx.getResources().getStringArray(R.array.colorlist);
                builder.setItems(colorlist, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                    String selected_color = colorlist[item];
                        Toast.makeText(ctx,"selected color"+selected_color,Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btncheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                final String Hobby_list[] = ctx.getResources().getStringArray(R.array.Hobby_List);
                boolean chechhobbylist[] = {true,true,false,true};
                builder.setMultiChoiceItems(Hobby_list, chechhobbylist, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int items, boolean isChecked) {
                     String selected_hobby = Hobby_list[items];
                        if (isChecked==true){
                            Toast.makeText(ctx,"selected hobby is"+selected_hobby,Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ctx,"Unselcted hobby is"+selected_hobby,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    private void allocation() {
        ctx = this;
        btone = (Button) findViewById(R.id.btone);
        bttwo = (Button) findViewById(R.id.bttwo);
        btthree = (Button) findViewById(R.id.btthree);
        btdatepicker = (Button) findViewById(R.id.btdatepicker);
        bttimepicker = (Button) findViewById(R.id.bttimepicker);
        btcustom = (Button)findViewById(R.id.btcustom);
        btnradio = (Button)findViewById(R.id.btnradio);
        btncheckbox = (Button)findViewById(R.id.btncheckbox);


        GregorianCalendar calendar = new GregorianCalendar();
        day = calendar.get(calendar.DAY_OF_MONTH);
        month = calendar.get(calendar.MONTH);
        year = calendar.get(calendar.YEAR);
        hr = calendar.get(calendar.HOUR_OF_DAY);
        min = calendar.get(calendar.MINUTE);

    }
}
