package com.example.mahir.storefiles;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStorage
{
    private String SharedPreferenceName;
    private Context ctx;
    private SharedPreferences preference; //declration
    private SharedPreferences.Editor DataWriter; //declration

    public static final int INTEGER =1;
    public static final int FLOAT =2;
    public static final int STRING =3;
    public static final int BOOLEAN =4;
    public static final int LONG = 5;
    public DataStorage(Context ctx){
        this.ctx = ctx;
    }

    public DataStorage(String SharedPreferenceName,Context ctx)
    {
        this.SharedPreferenceName = SharedPreferenceName;
        this.ctx = ctx;
        preference = ctx.getSharedPreferences(SharedPreferenceName,Context.MODE_PRIVATE);
        DataWriter = preference.edit();
    }



    public void write(String key,boolean value)
    {
        Log.w("trace","boolean version()");
        DataWriter.putBoolean(key, value);
        DataWriter.commit();
    }
    public void write(String key,String value)
    {
        Log.w("trace","string version()");
        DataWriter.putString(key, value);
        DataWriter.commit();
    }
    public void write(String key,int value)
    {
        Log.w("trace","int version()");
        DataWriter.putInt(key, value);
        DataWriter.commit();
    }
    public void write(String key,float value)
    {
        Log.w("trace","float version()");
        DataWriter.putFloat(key, value);
        DataWriter.commit();
    }
    public void write(String key,long value)
    {
        Log.w("trace","long version()");
        DataWriter.putLong(key, value);
        DataWriter.commit();
    }

    public Object read(String key,int datatype)
    {

        Object result = new Object();
        if(datatype==INTEGER)
            result= preference.getInt(key,0);
        else if(datatype==STRING)
            result = preference.getString(key,"");
        else if(datatype==BOOLEAN)
            result = preference.getBoolean(key,false);
        else if(datatype==FLOAT)
            result = preference.getFloat(key,0.0f);
        else if(datatype==LONG)
            result = preference.getLong(key,0);

        return result;
    }
    public boolean writeinphone (String filename,String filecontain)
    {
        Boolean iserror = true;
        File myfile = new File(Environment.getExternalStorageDirectory()+"/"+filename);
        myfile.getParentFile().mkdirs();
        try
        {
            FileOutputStream fos = new FileOutputStream(myfile);
            fos.write(filecontain.getBytes());
            iserror = false;
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return iserror;
    }
    public boolean writeinsdcard(String filename,String filecontain){
        Boolean iserror = true;
        try {
            FileOutputStream fos = ctx.openFileOutput(filename,Context.MODE_PRIVATE);
            fos.write(filecontain.getBytes());
            iserror = false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iserror;
    }
    public String readfromphone(String filename){
        File myfile = new File(Environment.getExternalStorageDirectory() +  "/" + filename);
        StringBuffer basket = new StringBuffer();
        try {
            FileInputStream fis = new FileInputStream(myfile);
            byte[] packet = new byte[32];
            String temp = new String();

            while (fis.read(packet)>0){
                temp = new String(packet);
                basket.append(temp);
                packet = new byte[32];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return basket.toString();
    }
    public String readfromsdcard(String filename){
            StringBuffer basket = new StringBuffer();
        try {
            FileInputStream fis = ctx.openFileInput(filename);
            byte[] packet = new byte[32];
            String temp = new String();

            while (fis.read(packet)>0){
                temp = new String(packet);
                basket.append(temp);
                packet = new byte[32];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return basket.toString();
    }

}
