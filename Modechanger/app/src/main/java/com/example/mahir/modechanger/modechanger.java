package com.example.mahir.modechanger;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class modechanger extends Activity {
    Spinner spmode;
    AudioManager manager;
    Context ctx;
    String modelist [] = {"Ringermode","silentmode","vibratemode"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modechanger);
        allocate();
        spmode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int currentposition = spmode.getSelectedItemPosition();
                if (currentposition == 0)
                    manager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                else if (currentposition == 1)
                    manager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                else if (currentposition == 2)
                    manager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

    }

    private void allocate() {
        spmode = (Spinner)this.findViewById(R.id.spnmode);
        ctx = this;
        manager = (AudioManager) ctx.getSystemService(AUDIO_SERVICE);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ctx,android.R.layout.simple_spinner_item,modelist);
        spmode.setAdapter(adapter);
    }
}
