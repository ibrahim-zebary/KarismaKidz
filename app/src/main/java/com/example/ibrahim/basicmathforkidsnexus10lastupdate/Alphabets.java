package com.example.ibrahim.basicmathforkidsnexus10lastupdate;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class Alphabets extends Activity
{
    private MediaPlayer mediaPlayer;

    private int characters[] = {R.drawable.a, R.drawable.e, R.drawable.f, R.drawable.h, R.drawable.i, R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n, R.drawable.t};
    private int characterSounds[] = {R.raw.a, R.raw.e, R.raw.f, R.raw.h, R.raw.i, R.raw.k, R.raw.l, R.raw.m, R.raw.n, R.raw.t};
    private int index = 1;
    private int currIndex = 0;


    private DrawingSurface drawingSurface;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);
        drawingSurface = findViewById(R.id.drawing_surface);
        drawingSurface.setSourceImage(R.drawable.a);
    }

    public void onNextButtonClick(View view)
    {
        drawingSurface.setSourceImage(characters[index]);
        currIndex = index;
        index++;
        index = index % characters.length;
        onSoundButtonClick(null);
    }


    public void onSoundButtonClick(View view)
    {
        mediaPlayer = MediaPlayer.create(this, characterSounds[currIndex]);
        mediaPlayer.start();
    }

    public void onRefreshButtonClick(View view)
    {
        drawingSurface.setSourceImage(characters[currIndex]);
    }
}
