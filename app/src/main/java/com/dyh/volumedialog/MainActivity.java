package com.dyh.volumedialog;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.SeekBar;

import androidx.annotation.Nullable;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        SeekBar seekBarMusic = findViewById(R.id.seekBar);
        seekBarMusic.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        seekBarMusic.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        seekBarMusic.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
