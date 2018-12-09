package com.example.ibrahim.basicmathforkidsnexus10lastupdate;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class Numbers extends Activity
{
    private MediaPlayer mediaPlayer;

    private int numbers[] = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine};
    private int numberSounds[] = {R.raw.one_voice, R.raw.two_voice, R.raw.three_voice, R.raw.four_voice, R.raw.five_voice, R.raw.six_voice, R.raw.seven_voice, R.raw.eight_voice, R.raw.nine_voice};
    private int index = 1;
    private int currIndex = 0;


    private DrawingSurface drawingSurface;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        drawingSurface = findViewById(R.id.drawing_surface);
        drawingSurface.setSourceImage(R.drawable.one);
    }

    public void onNextButtonClick(View view)
    {
        drawingSurface.setSourceImage(numbers[index]);
        currIndex = index;
        index++;
        index = index % numbers.length;
        onSoundButtonClick(null);
    }


    public void onSoundButtonClick(View view)
    {
        mediaPlayer = MediaPlayer.create(this, numberSounds[currIndex]);
        mediaPlayer.start();
    }

    public void onRefreshButtonClick(View view)
    {
        drawingSurface.setSourceImage(numbers[currIndex]);
    }
}