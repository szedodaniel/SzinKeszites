package com.example.szedo.szinkeszites;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements SeekBar.OnSeekBarChangeListener {

    SeekBar SeekR;
    SeekBar SeekG;
    SeekBar SeekB;

    TextView ShowColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get a reference to the seekbars

        SeekR=(SeekBar)findViewById(R.id.seekR);
        SeekG=(SeekBar)findViewById(R.id.seekG);
        SeekB=(SeekBar)findViewById(R.id.seekB);

        ShowColor=(TextView)findViewById(R.id.textView);


        SeekR.setOnSeekBarChangeListener(this);
        SeekG.setOnSeekBarChangeListener(this);
        SeekB.setOnSeekBarChangeListener(this);
    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {


        int R=SeekR.getProgress();
        int G=SeekG.getProgress();
        int B=SeekB.getProgress();

        int id=seekBar.getId();


         if(id == com.example.szedo.szinkeszites.R.id.seekR)
            R=progress;
        else if(id == com.example.szedo.szinkeszites.R.id.seekG)
            G=progress;
        else if(id == com.example.szedo.szinkeszites.R.id.seekB)
            B=progress;
        //Build and show the new color
        ShowColor.setBackgroundColor(Color.rgb(R,G,B));
        //show the color value
        ShowColor.setText(String.format("Red: %d \n", R)
                +String.format("Green: %d \n", G)+String.format("Blue: %d", B));

        ShowColor.setTextColor(Color.rgb(255-R,255-G,255-B));
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        //Only required due to implements
    }
    public void onStopTrackingTouch(SeekBar seekBar) {
        //Only required due to implements
    }
}

