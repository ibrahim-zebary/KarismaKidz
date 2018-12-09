package com.example.ibrahim.basicmathforkidsnexus10lastupdate;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FoxHouse extends AppCompatActivity {

    private ImageView wolf1;
    private ImageView wolf2;
    private ImageView wolf3;
    private ImageView wolf4;
    private ImageView wolf5;
    private ImageView house;
    private TextView messageTxt;
    private LinearLayout startLayout;
    private LinearLayout answersLayout;

    private Random random = new Random();

    int randomNo;
    int finishTime;
    int repeatTime;
    int oldRandomNo;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fox_house);

        messageTxt = (TextView)findViewById(R.id.message_txt);
        startLayout = (LinearLayout)findViewById(R.id.start_layout);
        answersLayout = (LinearLayout)findViewById(R.id.answers_layout);

        wolf1 = (ImageView)findViewById(R.id.wolf1);
        wolf2 = (ImageView)findViewById(R.id.wolf2);
        wolf3 = (ImageView)findViewById(R.id.wolf3);
        wolf4 = (ImageView)findViewById(R.id.wolf4);
        wolf5 = (ImageView)findViewById(R.id.wolf5);
        house = (ImageView)findViewById(R.id.house);

        wolf1.setTranslationX(-1000);
        wolf2.setTranslationX(-1000);
        wolf3.setTranslationX(-1000);
        wolf4.setTranslationX(-1000);
        wolf5.setTranslationX(-1000);

    }
    public void start(View view)
    {
        messageTxt.setText("دەتەوێ دووبارە یاری بکەی ؟");
        startLayout.setVisibility(View.INVISIBLE);
        house.setVisibility(View.VISIBLE);
        wolf1.setVisibility(View.VISIBLE);
        wolf2.setVisibility(View.VISIBLE);
        wolf3.setVisibility(View.VISIBLE);
        wolf4.setVisibility(View.VISIBLE);
        wolf5.setVisibility(View.VISIBLE);

        wolf1.setTranslationX(-1000);
        wolf2.setTranslationX(-1000);
        wolf3.setTranslationX(-1000);
        wolf4.setTranslationX(-1000);
        wolf5.setTranslationX(-1000);

        while (true) {
            randomNo = random.nextInt(6);
            if (randomNo <= 0)
                continue;
            else if (randomNo > 5)
                continue;
            else if (oldRandomNo == randomNo)
                continue;
            else {
                oldRandomNo = randomNo;
                break;
            }
        }
        Log.i("Number: ","" + randomNo);

        switch (randomNo)
        {
            case 1: finishTime=10000;repeatTime=2000;
                break;
            case 2: finishTime=11000;repeatTime=2000;
                break;
            case 3: finishTime=13000;repeatTime=2000;
                break;
            case 4: finishTime=15000;repeatTime=2000;
                break;
            case 5: finishTime=17000;repeatTime=2000;
                break;
        }

        new CountDownTimer(finishTime,repeatTime)
        {
            @Override
            public void onTick(long l)
            {
                if(count<randomNo)
                {
                    count++;
                    switch (count)
                    {
                        case 1:wolf1.animate().translationXBy(1000).setDuration(10000);
                            break;
                        case 2:wolf2.animate().translationXBy(1000).setDuration(10000);
                            break;
                        case 3:wolf3.animate().translationXBy(1000).setDuration(10000);
                            break;
                        case 4:wolf4.animate().translationXBy(1000).setDuration(10000);
                            break;
                        case 5:wolf5.animate().translationXBy(1000).setDuration(10000);
                            break;
                    }
                }
            }

            @Override
            public void onFinish()
            {
                wolf1.setVisibility(View.INVISIBLE);
                wolf2.setVisibility(View.INVISIBLE);
                wolf3.setVisibility(View.INVISIBLE);
                wolf4.setVisibility(View.INVISIBLE);
                wolf5.setVisibility(View.INVISIBLE);
                house.setVisibility(View.INVISIBLE);
                answersLayout.setVisibility(View.VISIBLE);
                startLayout.setVisibility(View.INVISIBLE);
                count=0;
            }
        }.start();
    }
    public void setAnswer(View v)
    {
        if(Integer.parseInt(v.getTag().toString()) == randomNo)
            Toast.makeText(this,"وەڵامەکەت ڕاستە",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"وەڵامەکەت هەڵەیە",Toast.LENGTH_LONG).show();
        answersLayout.setVisibility(View.INVISIBLE);
        startLayout.setVisibility(View.VISIBLE);
    }
}
