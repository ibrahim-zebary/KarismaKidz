package com.example.ibrahim.basicmathforkidsnexus10lastupdate;

import android.content.ClipData;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class FishSubtraction extends AppCompatActivity {

    private Random random = new Random();
    private Handler handler = new Handler();
    private Timer timer = new Timer();

    int screenHeight;
    int screenWidth;
    float gif1X;
    float gif2X;
    float gif3X;

    private GridLayout resultLayout;

    private ImageView fishGIF1;
    private ImageView fishGIF2;
    private ImageView fishGIF3;

    private ImageView water;

    private ImageView image1Oprt1;
    private ImageView image2Oprt1;
    private ImageView image3Oprt1;
    private ImageView image4Oprt1;
    private ImageView image5Oprt1;

    private ImageView image1Oprt2;
    private ImageView image2Oprt2;
    private ImageView image3Oprt2;
    private ImageView image4Oprt2;
    private ImageView image5Oprt2;

    private ImageView image1Result;
    private ImageView image2Result;
    private ImageView image3Result;
    private ImageView image4Result;
    private ImageView image5Result;
    private ImageView image6Result;
    private ImageView image7Result;
    private ImageView image8Result;
    private ImageView image9Result;
    private ImageView image10Result;

    private Button btnResult;

    int randomNum1;
    int randomNum1Temp;
    int randomNum2;
    int randomNum2Temp;
    int result;

    int count;
    int imageTags;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fish_subtraction);

        fishGIF1 = (ImageView)findViewById(R.id.fish_gif1);
        fishGIF2 = (ImageView)findViewById(R.id.fish_gif2);
        fishGIF3 = (ImageView)findViewById(R.id.fish_gif3);

        water = (ImageView)findViewById(R.id.water_image);

        resultLayout = (GridLayout)findViewById(R.id.grid_layout_result);

        image1Oprt1 = (ImageView)findViewById(R.id.image11);
        image2Oprt1 = (ImageView)findViewById(R.id.image12);
        image3Oprt1 = (ImageView)findViewById(R.id.image13);
        image4Oprt1 = (ImageView)findViewById(R.id.image14);
        image5Oprt1 = (ImageView)findViewById(R.id.image15);

        image1Oprt2 = (ImageView)findViewById(R.id.image21);
        image2Oprt2 = (ImageView)findViewById(R.id.image22);
        image3Oprt2 = (ImageView)findViewById(R.id.image23);
        image4Oprt2 = (ImageView)findViewById(R.id.image24);
        image5Oprt2 = (ImageView)findViewById(R.id.image25);

        image1Result = (ImageView)findViewById(R.id.image_result1);
        image2Result = (ImageView)findViewById(R.id.image_result2);
        image3Result = (ImageView)findViewById(R.id.image_result3);
        image4Result = (ImageView)findViewById(R.id.image_result4);
        image5Result = (ImageView)findViewById(R.id.image_result5);
        image6Result = (ImageView)findViewById(R.id.image_result6);
        image7Result = (ImageView)findViewById(R.id.image_result7);
        image8Result = (ImageView)findViewById(R.id.image_result8);
        image9Result = (ImageView)findViewById(R.id.image_result9);
        image10Result = (ImageView)findViewById(R.id.image_result10);

        btnResult = (Button)findViewById(R.id.btn_result);
        btnResult.setClickable(false);

        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        fishGIF1.setX(-80.0f);
        fishGIF1.setY(-80.0f);
        fishGIF2.setX(-80.0f);
        fishGIF2.setY(-80.0f);
        fishGIF3.setX(-80.0f);
        fishGIF3.setY(-80.0f);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePos();
                    }
                });
            }
        }, 0, 50);

        setRandomNumbers();
        setOprt1Images();
        setOprt2Images();

        image1Result.setOnTouchListener(touchListenerImages);
        image2Result.setOnTouchListener(touchListenerImages);
        image3Result.setOnTouchListener(touchListenerImages);
        image4Result.setOnTouchListener(touchListenerImages);
        image5Result.setOnTouchListener(touchListenerImages);
        image6Result.setOnTouchListener(touchListenerImages);
        image7Result.setOnTouchListener(touchListenerImages);
        image8Result.setOnTouchListener(touchListenerImages);
        image9Result.setOnTouchListener(touchListenerImages);
        image10Result.setOnTouchListener(touchListenerImages);

        fishGIF1.setOnTouchListener(touchListenerWater);
        fishGIF2.setOnTouchListener(touchListenerWater);
        fishGIF3.setOnTouchListener(touchListenerWater);

        resultLayout.setOnDragListener(dragListenerResultLayout);

        water.setOnDragListener(dragListenerWater);

    }

    public void setRandomNumbers() {

        while (true) {
            randomNum1 = random.nextInt(6);
            if (randomNum1 < 1)
                continue;
            else if (randomNum1 > 5)
                continue;
            else if(randomNum1Temp == randomNum1)
                continue;
            else {
                randomNum1Temp = randomNum1;
                break;
            }
        }
        while (true) {
            randomNum2 = random.nextInt(6);
            if (randomNum2 < 0)
                continue;
            else if (randomNum2 > 5)
                continue;
            else if(randomNum2Temp == randomNum2)
                continue;
            else if(randomNum1 < randomNum2)
                continue;
            else {
                randomNum2Temp = randomNum2;
                break;
            }
        }

        result = randomNum1 - randomNum2;
        if(result == 0)
            btnResult.setClickable(true);

    }
    public void setOprt1Images() {
        for(int i = 0; i < randomNum1 ; i++)
        {
            if(i == 0)
                image1Oprt1.setImageResource(R.drawable.fish_image);
            else if(i == 1)
                image2Oprt1.setImageResource(R.drawable.fish_image);
            else if(i == 2)
                image3Oprt1.setImageResource(R.drawable.fish_image);
            else if(i == 3)
                image4Oprt1.setImageResource(R.drawable.fish_image);
            else
                image5Oprt1.setImageResource(R.drawable.fish_image);
        }
    }
    public void setOprt2Images() {
        for(int i = 0; i < randomNum2 ; i++)
        {
            if(i == 0)
                image1Oprt2.setImageResource(R.drawable.fish_image);
            else if(i == 1)
                image2Oprt2.setImageResource(R.drawable.fish_image);
            else if(i == 2)
                image3Oprt2.setImageResource(R.drawable.fish_image);
            else if(i == 3)
                image4Oprt2.setImageResource(R.drawable.fish_image);
            else
                image5Oprt2.setImageResource(R.drawable.fish_image);
        }
    }
    public void setResultImages() {
        switch(count) {
            case 1:image1Result.setImageResource(R.drawable.fish_image);
                break;
            case 2:image2Result.setImageResource(R.drawable.fish_image);
                break;
            case 3:image3Result.setImageResource(R.drawable.fish_image);
                break;
            case 4:image4Result.setImageResource(R.drawable.fish_image);
                break;
            case 5:image5Result.setImageResource(R.drawable.fish_image);
                break;
            case 6:image6Result.setImageResource(R.drawable.fish_image);
                break;
            case 7:image7Result.setImageResource(R.drawable.fish_image);
                break;
            case 8:image8Result.setImageResource(R.drawable.fish_image);
                break;
            case 9:image9Result.setImageResource(R.drawable.fish_image);
                break;
            case 10:image10Result.setImageResource(R.drawable.fish_image);
                break;
        }
    }
    public void removeResultImages() {
        switch(count) {
            case 1:image1Result.setImageResource(0);
                break;
            case 2:image2Result.setImageResource(0);
                break;
            case 3:image3Result.setImageResource(0);
                break;
            case 4:image4Result.setImageResource(0);
                break;
            case 5:image5Result.setImageResource(0);
                break;
            case 6:image6Result.setImageResource(0);
                break;
            case 7:image7Result.setImageResource(0);
                break;
            case 8:image8Result.setImageResource(0);
                break;
            case 9:image9Result.setImageResource(0);
                break;
            case 10:image10Result.setImageResource(0);
                break;
        }
    }
    public void removeAllResultImages() {
        image1Result.setImageResource(0);
        image2Result.setImageResource(0);
        image3Result.setImageResource(0);
        image4Result.setImageResource(0);
        image5Result.setImageResource(0);
        image6Result.setImageResource(0);
        image7Result.setImageResource(0);
        image8Result.setImageResource(0);
        image9Result.setImageResource(0);
        image10Result.setImageResource(0);
    }
    public void removeAllOperatorImages() {
        image1Oprt1.setImageResource(0);
        image2Oprt1.setImageResource(0);
        image3Oprt1.setImageResource(0);
        image4Oprt1.setImageResource(0);
        image5Oprt1.setImageResource(0);

        image1Oprt2.setImageResource(0);
        image2Oprt2.setImageResource(0);
        image3Oprt2.setImageResource(0);
        image4Oprt2.setImageResource(0);
        image5Oprt2.setImageResource(0);


    }

    public void changePos() {

        gif1X -= 6;
        if (fishGIF1.getX() + fishGIF1.getWidth() < 0) {
            gif1X = screenWidth + 100.0f;
        }
        fishGIF1.setX(gif1X);
        fishGIF1.setY(570f);

        gif2X += 3;
        if (fishGIF2.getX() > screenWidth) {
            gif2X = -100.0f;
        }
        fishGIF2.setX(gif2X);
        fishGIF2.setY(400);

        gif3X += 4;
        if (fishGIF3.getX() > screenWidth) {
            gif3X = -100.0f;
        }
        fishGIF3.setX(gif3X);
        fishGIF3.setY(280f);


    }

    View.OnTouchListener touchListenerImages = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent)
        {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            ClipData data = ClipData.newPlainText("","");
            view.startDrag(data,shadowBuilder,view,0);
            imageTags = Integer.parseInt(view.getTag().toString());

            return true;
        }
    };

    View.OnDragListener dragListenerResultLayout = new View.OnDragListener()
    {
        int dragEvent;
        @Override
        public boolean onDrag(View view, DragEvent event)
        {
            if(count < 10) {
                dragEvent = event.getAction();
                switch (dragEvent) {

                    case DragEvent.ACTION_DRAG_ENTERED:

                        break;

                    case DragEvent.ACTION_DRAG_EXITED:

                        break;

                    case DragEvent.ACTION_DROP:

                        if( imageTags > 10 ) {
                            btnResult.setClickable(true);
                            count++;
                            setResultImages();
                        }
                        break;
                }
                return true;
            }
            else {
                return false;
            }
        }
    };
    View.OnDragListener dragListenerWater = new View.OnDragListener()
    {
        int dragEvent;
        @Override
        public boolean onDrag(View view, DragEvent event)
        {
            if(count > 0) {
                dragEvent = event.getAction();
                switch (dragEvent) {

                    case DragEvent.ACTION_DRAG_ENTERED:

                        break;

                    case DragEvent.ACTION_DRAG_EXITED:

                        break;

                    case DragEvent.ACTION_DROP:

                        if( imageTags < 11) {
                            removeResultImages();
                            count--;
                        }
                        break;
                }
                return true;
            }
            else {
                return false;
            }
        }
    };


    View.OnTouchListener touchListenerWater = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent)
        {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            ClipData data = ClipData.newPlainText("","");
            view.startDrag(data,shadowBuilder,view,0);
            imageTags = Integer.parseInt(view.getTag().toString());

            return true;
        }
    };
    public void checkResult(View v) {
        if(count == result)
            Toast.makeText(this,"وەڵامەکەت ڕاستە",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"وەڵامەکەت هەڵەیە",Toast.LENGTH_LONG).show();

        count = 0;
        btnResult.setClickable(false);
        removeAllOperatorImages();
        removeAllResultImages();
        setRandomNumbers();
        setOprt1Images();
        setOprt2Images();
    }
}
