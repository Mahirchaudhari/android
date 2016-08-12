package com.example.mahir.radio_music;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class radio_music extends Activity {
    RadioButton rbt1,rbt2,rbt3,rbt4,rbt5,rbt6;
    Button btring;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_music);
        allcation();

        rbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
                player = MediaPlayer.create(radio_music.this,R.raw.baby1);
                player.start();

                rbt2.setChecked(false);
                rbt3.setChecked(false);
                rbt4.setChecked(false);
                rbt5.setChecked(false);
                rbt6.setChecked(false);
            }
        });
        rbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
                player = MediaPlayer.create(radio_music.this,R.raw.baby2);
                player.start();

                rbt1.setChecked(false);
                rbt3.setChecked(false);
                rbt4.setChecked(false);
                rbt5.setChecked(false);
                rbt6.setChecked(false);
            }
        });
        rbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
                player = MediaPlayer.create(radio_music.this,R.raw.baby3);
                player.start();

                rbt2.setChecked(false);
                rbt1.setChecked(false);
                rbt4.setChecked(false);
                rbt5.setChecked(false);
                rbt6.setChecked(false);

            }
        });rbt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
                player = MediaPlayer.create(radio_music.this,R.raw.baby4);
                player.start();

                rbt2.setChecked(false);
                rbt1.setChecked(false);
                rbt3.setChecked(false);
                rbt5.setChecked(false);
                rbt6.setChecked(false);
            }
        });
        rbt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
                player = MediaPlayer.create(radio_music.this,R.raw.baby5);
                player.start();

                rbt2.setChecked(false);
                rbt1.setChecked(false);
                rbt4.setChecked(false);
                rbt3.setChecked(false);
                rbt6.setChecked(false);
            }
        });rbt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
                player = MediaPlayer.create(radio_music.this,R.raw.baby6);
                player.start();

                rbt2.setChecked(false);
                rbt1.setChecked(false);
                rbt4.setChecked(false);
                rbt3.setChecked(false);
                rbt5.setChecked(false);
            }
        });
        btring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbt1.isChecked()){
                    Uri path = Uri.parse("android.resource://com.example.mahir.radio_music/raw/baby1.mp3");
                    RingtoneManager.setActualDefaultRingtoneUri(
                            getApplicationContext(), RingtoneManager.TYPE_RINGTONE,
                            path);
                    RingtoneManager.getRingtone(getApplicationContext(), path)
                            .play();
                }

                else if (rbt2.isChecked()){
                    Uri path = Uri.parse("android.resource://com.example.mahir.radio_music/raw/baby2.mp3");
                    RingtoneManager.setActualDefaultRingtoneUri(
                            getApplicationContext(), RingtoneManager.TYPE_RINGTONE,
                            path);
                    RingtoneManager.getRingtone(getApplicationContext(), path)
                            .play();
                }

                else if (rbt3.isChecked()){
                    Uri path = Uri.parse("android.resource://com.example.mahir.radio_music/raw/baby3.mp3");
                    RingtoneManager.setActualDefaultRingtoneUri(
                            getApplicationContext(), RingtoneManager.TYPE_RINGTONE,
                            path);
                    RingtoneManager.getRingtone(getApplicationContext(), path)
                            .play();
                }
                else if (rbt4.isChecked()){
                    Uri path = Uri.parse("android.resource://com.example.mahir.radio_music/raw/baby4.mp3");
                    RingtoneManager.setActualDefaultRingtoneUri(
                            getApplicationContext(), RingtoneManager.TYPE_RINGTONE,
                            path);
                    RingtoneManager.getRingtone(getApplicationContext(), path)
                            .play();
                }
                else if (rbt5.isChecked()){
                    Uri path = Uri.parse("android.resource://com.example.mahir.radio_music/raw/baby5.mp3");
                    RingtoneManager.setActualDefaultRingtoneUri(
                            getApplicationContext(), RingtoneManager.TYPE_RINGTONE,
                            path);
                    RingtoneManager.getRingtone(getApplicationContext(), path)
                            .play();
                }
                else if (rbt6.isChecked()){
                    Uri path = Uri.parse("android.resource://com.example.mahir.radio_music/raw/baby6.mp3");
                    RingtoneManager.setActualDefaultRingtoneUri(
                            getApplicationContext(), RingtoneManager.TYPE_RINGTONE,
                            path);
                    RingtoneManager.getRingtone(getApplicationContext(), path)
                            .play();
                }
            }
        });
    }
    private void allcation() {
    player = MediaPlayer.create(this, R.raw.baby1);
    rbt1 = (RadioButton) this.findViewById(R.id.rbt1);
    rbt2 = (RadioButton) this.findViewById(R.id.rbt2);
    rbt3 = (RadioButton) this.findViewById(R.id.rbt3);
    rbt4 = (RadioButton) this.findViewById(R.id.rbt4);
    rbt5 = (RadioButton) this.findViewById(R.id.rbt5);
    rbt6 = (RadioButton) this.findViewById(R.id.rbt6);
    btring = (Button) this.findViewById(R.id.btring);

    }
}
