package com.example.ibrahim.basicmathforkidsnexus10lastupdate;

import android.media.MediaPlayer;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;

public class DisplayNumbers extends AppCompatActivity {

    ImageView leftArrow;
    ImageView rightArrow;
    ImageView numImage;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    ImageView img9;
    ImageView img10;
    ImageView img11;
    ImageView img12;
    ImageView img13;
    ImageView img14;
    ImageView img15;
    ImageView img16;
    ImageView img17;
    ImageView img18;
    ImageView img19;
    ImageView img20;

    MediaPlayer num0;
    MediaPlayer num1;
    MediaPlayer num2;
    MediaPlayer num3;
    MediaPlayer num4;
    MediaPlayer num5;
    MediaPlayer num6;
    MediaPlayer num7;
    MediaPlayer num8;
    MediaPlayer num9;
    MediaPlayer num10;
    MediaPlayer num11;
    MediaPlayer num12;
    MediaPlayer num13;
    MediaPlayer num14;
    MediaPlayer num15;
    MediaPlayer num16;
    MediaPlayer num17;
    MediaPlayer num18;
    MediaPlayer num19;
    MediaPlayer num20;

    int tagNum = 1;
    int numberVoice = 1;

    //private CircleButton b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_numbers);

        img1 = (ImageView)findViewById(R.id.img1);
        img2 = (ImageView)findViewById(R.id.img2);
        img3 = (ImageView)findViewById(R.id.img3);
        img4 = (ImageView)findViewById(R.id.img4);
        img5 = (ImageView)findViewById(R.id.img5);
        img6 = (ImageView)findViewById(R.id.img6);
        img7 = (ImageView)findViewById(R.id.img7);
        img8 = (ImageView)findViewById(R.id.img8);
        img9 = (ImageView)findViewById(R.id.img9);
        img10 = (ImageView)findViewById(R.id.img10);
        img11 = (ImageView)findViewById(R.id.img11);
        img12 = (ImageView)findViewById(R.id.img12);
        img13 = (ImageView)findViewById(R.id.img13);
        img14 = (ImageView)findViewById(R.id.img14);
        img15 = (ImageView)findViewById(R.id.img15);
        img16 = (ImageView)findViewById(R.id.img16);
        img17 = (ImageView)findViewById(R.id.img17);
        img18 = (ImageView)findViewById(R.id.img18);
        img19 = (ImageView)findViewById(R.id.img19);
        img20 = (ImageView)findViewById(R.id.img20);

        //b = (CircleButton)findViewById(R.id.button0);

        leftArrow = (ImageView)findViewById(R.id.left_arrow);
        rightArrow = (ImageView)findViewById(R.id.right_arrow);

        numImage = (ImageView)findViewById(R.id.number_image);

        /*num0 = MediaPlayer.create(this,R.raw.number0);
        num1 = MediaPlayer.create(this,R.raw.number1);
        num2 = MediaPlayer.create(this,R.raw.number2);
        num3 = MediaPlayer.create(this,R.raw.number3);
        num4 = MediaPlayer.create(this,R.raw.number4);
        num5 = MediaPlayer.create(this,R.raw.number5);
        num6 = MediaPlayer.create(this,R.raw.number6);
        num7 = MediaPlayer.create(this,R.raw.number7);
        num8 = MediaPlayer.create(this,R.raw.number8);
        num9 = MediaPlayer.create(this,R.raw.number9);
        num10 = MediaPlayer.create(this,R.raw.number10);
        num11 = MediaPlayer.create(this,R.raw.number11);
        num12 = MediaPlayer.create(this,R.raw.number12);
        num13 = MediaPlayer.create(this,R.raw.number13);
        num14 = MediaPlayer.create(this,R.raw.number14);
        num15 = MediaPlayer.create(this,R.raw.number15);
        num16 = MediaPlayer.create(this,R.raw.number16);
        num17 = MediaPlayer.create(this,R.raw.number17);
        num18 = MediaPlayer.create(this,R.raw.number18);
        num19 = MediaPlayer.create(this,R.raw.number19);
        num20 = MediaPlayer.create(this,R.raw.number20);*/

    }

    public void leftButton(View v)
    {
        rightArrow.setClickable(true);
        rightArrow.setAlpha(1f);
        enteredLeftArrow();
        tagNum--;
        numImage.setTag(tagNum);
        setNumImage();
        numImage.setTranslationY(800);
        numImage.setRotationY(180);
        numImage.animate().translationYBy(-800).setDuration(500).rotationY(0);
        if(tagNum <= 0) {
            leftArrow.setClickable(false);
            leftArrow.setAlpha(0.5f);
        }
    }
    public void rightButton(View v)
    {
        leftArrow.setClickable(true);
        leftArrow.setAlpha(1f);
        tagNum++;
        enteredRightArrow();
        numImage.setTag(tagNum);
        setNumImage();
        numImage.setTranslationY(800);
        numImage.setRotationY(180);
        numImage.animate().translationYBy(-800).setDuration(500).rotationY(0);
        if(tagNum >= 20) {
            rightArrow.setClickable(false);
            rightArrow.setAlpha(0.5f);
        }
    }
    /*public void numberVoice(View v)
    {
        numberVoicesInKurdish();
        Log.i("Entered","Entered");
    }
    public void numberVoicesInKurdish() {
        switch (numberVoice)
        {
            case 0: num0.start();
                break;
            case 1:num1.start();
                break;
            case 2:num2.start();
                break;
            case 3:num3.start();
                break;
            case 4:num4.start();
                break;
            case 5:num5.start();
                break;
            case 6:num6.start();
                break;
            case 7:num7.start();
                break;
            case 8:num8.start();
                break;
            case 9:num9.start();
                break;
            case 10:num10.start();
                break;
            case 11:num11.start();
                break;
            case 12:num12.start();
                break;
            case 13:num13.start();
                break;
            case 14:num14.start();
                break;
            case 15:num15.start();
                break;
            case 16:num16.start();
                break;
            case 17:num17.start();
                break;
            case 18:num18.start();
                break;
            case 19:num19.start();
                break;
            case 20:num20.start();
                break;

        }
    }*/
    public void setNumImage()
    {
        switch (Integer.parseInt(numImage.getTag().toString()))
        {
            case 0:numImage.setImageResource(R.drawable.num0);
                break;
            case 1:numImage.setImageResource(R.drawable.num1);
                break;
            case 2:numImage.setImageResource(R.drawable.num2);
                break;
            case 3:numImage.setImageResource(R.drawable.num3);
                break;
            case 4:numImage.setImageResource(R.drawable.num4);
                break;
            case 5:numImage.setImageResource(R.drawable.num5);
                break;
            case 6:numImage.setImageResource(R.drawable.num6);
                break;
            case 7:numImage.setImageResource(R.drawable.num7);
                break;
            case 8:numImage.setImageResource(R.drawable.num8);
                break;
            case 9:numImage.setImageResource(R.drawable.num9);
                break;
            case 10:numImage.setImageResource(R.drawable.num10);
                break;
            case 11:numImage.setImageResource(R.drawable.num11);
                break;
            case 12:numImage.setImageResource(R.drawable.num12);
                break;
            case 13:numImage.setImageResource(R.drawable.num13);
                break;
            case 14:numImage.setImageResource(R.drawable.num14);
                break;
            case 15:numImage.setImageResource(R.drawable.num15);
                break;
            case 16:numImage.setImageResource(R.drawable.num16);
                break;
            case 17:numImage.setImageResource(R.drawable.num17);
                break;
            case 18:numImage.setImageResource(R.drawable.num18);
                break;
            case 19:numImage.setImageResource(R.drawable.num19);
                break;
            case 20:numImage.setImageResource(R.drawable.num20);
                break;
        }
    }
    public void enteredRightArrow()
    {
        switch(tagNum)
        {
            case 0:
                break;
            case 1:img1.animate().alpha(1);
                break;
            case 2:img2.animate().alpha(1);
                break;
            case 3:img3.animate().alpha(1);
                break;
            case 4:img4.animate().alpha(1);
                break;
            case 5:img5.animate().alpha(1);
                break;
            case 6:img6.animate().alpha(1);
                break;
            case 7:img7.animate().alpha(1);
                break;
            case 8:img8.animate().alpha(1);
                break;
            case 9:img9.animate().alpha(1);
                break;
            case 10:img10.animate().alpha(1);
                break;
            case 11:img11.animate().alpha(1);
                break;
            case 12:img12.animate().alpha(1);
                break;
            case 13:img13.animate().alpha(1);
                break;
            case 14:img14.animate().alpha(1);
                break;
            case 15:img15.animate().alpha(1);
                break;
            case 16:img16.animate().alpha(1);
                break;
            case 17:img17.animate().alpha(1);
                break;
            case 18:img18.animate().alpha(1);
                break;
            case 19:img19.animate().alpha(1);
                break;
            case 20:img20.animate().alpha(1);
                break;
        }
        numberVoice++;
        //numberVoicesInKurdish();
    }
    public void enteredLeftArrow()
    {
        switch(tagNum)
        {
            case 0:
                break;
            case 1:img1.animate().alpha(0);
                break;
            case 2:img2.animate().alpha(0);
                break;
            case 3:img3.animate().alpha(0);
                break;
            case 4:img4.animate().alpha(0);
                break;
            case 5:img5.animate().alpha(0);
                break;
            case 6:img6.animate().alpha(0);
                break;
            case 7:img7.animate().alpha(0);
                break;
            case 8:img8.animate().alpha(0);
                break;
            case 9:img9.animate().alpha(0);
                break;
            case 10:img10.animate().alpha(0);
                break;
            case 11:img11.animate().alpha(0);
                break;
            case 12:img12.animate().alpha(0);
                break;
            case 13:img13.animate().alpha(0);
                break;
            case 14:img14.animate().alpha(0);
                break;
            case 15:img15.animate().alpha(0);
                break;
            case 16:img16.animate().alpha(0);
                break;
            case 17:img17.animate().alpha(0);
                break;
            case 18:img18.animate().alpha(0);
                break;
            case 19:img19.animate().alpha(0);
                break;
            case 20:img20.animate().alpha(0);
                break;
        }
        numberVoice--;
        //numberVoicesInKurdish();
    }
}