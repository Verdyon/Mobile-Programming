package com.example.week05__32810;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private SeekBar sbRed, sbGreen, sbBlue;
    private RadioGroup rgBentuk;
    private RadioButton rbPilih;
    private ImageButton btnWarna;
    private CustomView customView;
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue = findViewById(R.id.sbBlue);
        btnWarna = findViewById(R.id.btnWarna);
        rgBentuk = findViewById(R.id.rgBentuk);
        customView = findViewById(R.id.customView);
        customView = new CustomView(this);

        rgBentuk.setOnCheckedChangeListener(
                (group, checkedId) -> {
                    int intRb = rgBentuk.getCheckedRadioButtonId();
                    rbPilih = findViewById(intRb);
                    String bentuk = rbPilih.getText().toString();
                    customView.gantiBentuk(bentuk);
                }
        );

        sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                red = sbRed.getProgress();
                customView.gantiWarna(red, green, blue);
                btnWarna.setBackgroundColor(Color.rgb(red, green, blue));
            }
        });

        sbGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                green = sbGreen.getProgress();
                customView.gantiWarna(red, green, blue);
                btnWarna.setBackgroundColor(Color.rgb(red, green, blue));
            }
        });

        sbBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                blue = sbBlue.getProgress();
                customView.gantiWarna(red, green, blue);
                btnWarna.setBackgroundColor(Color.rgb(red, green, blue));
            }
        });
    }
}