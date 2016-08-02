package com.example.mahir.intent_implicit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;

/**
 * Created by Mahir on 02-08-2016.
 */
public class camera_bg extends Activity {
    Button setwallpaper;
    ImageView imageView;
    ImageButton ibutton;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_bg);
        ibutton = (ImageButton)findViewById(R.id.ibt);
        setwallpaper = (Button)findViewById(R.id.btsetwallpaper);
        imageView = (ImageView)findViewById(R.id.imageView);
        ibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });
    setwallpaper.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                getApplicationContext().setWallpaper(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Bundle b = data.getExtras();
            bitmap = (Bitmap)b.get("data");
            imageView.setImageBitmap(bitmap);
        }
    }
}
