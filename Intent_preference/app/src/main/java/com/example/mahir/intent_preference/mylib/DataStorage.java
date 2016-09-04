package com.example.mahir.intent_preference.mylib;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

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
}
