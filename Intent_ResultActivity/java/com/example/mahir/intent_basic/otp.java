package com.example.mahir.intent_basic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Random;

public class otp extends Activity {
    int num1, num2 , num3;
    Intent return_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Random rand = new Random();
        int num1 =rand.nextInt(99);
        int num2 = rand.nextInt(99);
        int num3 = rand.nextInt(99);

        String random_value =  num1 + "" + num2 + "" + num3;

        return_intent = new Intent();

        return_intent.putExtra("random_value",random_value);
        setResult(999,return_intent);
        otp.this.finish();
    }

    /*public void finish(){
        super.finish();

        this.setResult(999,return_intent);

    }*/
}
