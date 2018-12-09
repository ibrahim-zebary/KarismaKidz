package com.example.ibrahim.basicmathforkidsnexus10lastupdate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class BallonSubtraction extends AppCompatActivity {

    private ImageView img1,img2,img3,img4,img5;
    private ImageView fireworkGIF1,fireworkGIF2,sadFaceGIF;
    private Button btn;
    private TextView txt;
    private LinearLayout introductionLayout;

    int [] num0Res = {R.drawable.aa_s};
    int [] num1Res = {R.drawable.ba_s, R.drawable.bb_s};
    int [] num2Res = {R.drawable.ca_s, R.drawable.cb_s, R.drawable.cc_s};
    int [] num3Res = {R.drawable.da_s, R.drawable.db_s, R.drawable.dc_s, R.drawable.dd_s};
    int [] num4Res = {R.drawable.ea_s, R.drawable.eb_s, R.drawable.ec_s, R.drawable.ed_s, R.drawable.ee_s};
    int [] num5Res = {R.drawable.fa_s, R.drawable.fb_s, R.drawable.fc_s, R.drawable.fd_s, R.drawable.fe_s, R.drawable.ff_s};
    int [] num6Res = {R.drawable.ga_s, R.drawable.gb_s, R.drawable.gc_s, R.drawable.gd_s, R.drawable.ge_s, R.drawable.gf_s, R.drawable.gg_s};
    int [] num7Res = {R.drawable.ha_s, R.drawable.hb_s, R.drawable.hc_s, R.drawable.hd_s, R.drawable.he_s, R.drawable.hf_s, R.drawable.hg_s, R.drawable.hh_s};
    int [] num8Res = {R.drawable.ia_s, R.drawable.ib_s, R.drawable.ic_s, R.drawable.id_s, R.drawable.ie_s, R.drawable.ifz_s,R.drawable.ig_s, R.drawable.ih_s, R.drawable.ii_s};
    int [] num9Res = {R.drawable.ja_s, R.drawable.jb_s, R.drawable.jc_s, R.drawable.jd_s, R.drawable.je_s, R.drawable.jf_s, R.drawable.jg_s, R.drawable.jh_s, R.drawable.ji_s, R.drawable.jj_s};
    int [] num10Res= {R.drawable.ka_s, R.drawable.kb_s, R.drawable.kc_s, R.drawable.kd_s, R.drawable.ke_s, R.drawable.kf_s, R.drawable.kg_s, R.drawable.kh_s, R.drawable.ki_s, R.drawable.kj_s, R.drawable.kk_s};

    Random r = new Random();
    Timer timer = new Timer();
    Handler handler = new Handler();
    Timer timer2 = new Timer();
    Handler handler2 = new Handler();
    View timerView;


    boolean img1Up;
    boolean img1Down;
    boolean img2Up;
    boolean img2Down;
    boolean img3Up;
    boolean img3Down;
    boolean img4Up;
    boolean img4Down;
    boolean img5Up;
    boolean img5Down;

    float img1Y;
    float img2Y;
    float img3Y;
    float img4Y;
    float img5Y;

    int operator1 = -1;
    int operator2 = -1;
    int result = -1;
    int img1Result = -1;
    int img2Result = -1;
    int img3Result = -1;
    int img4Result = -1;
    int img5Result = -1;

    int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ballon_subtraction);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        img1 = (ImageView)findViewById(R.id.img_1);
        img2 = (ImageView)findViewById(R.id.img_2);
        img3 = (ImageView)findViewById(R.id.img_3);
        img4 = (ImageView)findViewById(R.id.img_4);
        img5 = (ImageView)findViewById(R.id.img_5);
        fireworkGIF1 = (ImageView)findViewById(R.id.firework_gif1);
        fireworkGIF2 = (ImageView)findViewById(R.id.firework_gif2);
        sadFaceGIF = (ImageView)findViewById(R.id.sad_face_gif);

        btn = (Button)findViewById(R.id.btn);

        txt = (TextView)findViewById(R.id.txt);

        introductionLayout = (LinearLayout)findViewById(R.id.start_layout);

        img1.setX(150);
        img1.setY(250);// +
        img2.setX(400);
        img2.setY(300);// -
        img3.setX(600);
        img3.setY(200);// +
        img4.setX(800);
        img4.setY(350);// -
        img5.setX(1000);
        img5.setY(300);// +

        img1Y = img1.getY();
        img2Y = img2.getY();
        img3Y = img3.getY();
        img4Y = img4.getY();
        img5Y = img5.getY();


        img1Up = false;
        img1Down = true;
        img2Up = true;
        img2Down = false;
        img3Up = false;
        img3Down = true;
        img4Up = true;
        img4Down = false;
        img5Up = false;
        img5Down = true;

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
        }, 0, 20);
    }

    public void changePos() {
        // Ballon 1
        if(img1Up) {
            img1Y -= 1;
            img1.setY(img1Y);
            if(img1Y == 250){
                img1Up = false;
                img1Down = true;
            }
        } else if(img1Down) {
            img1Y += 1;
            img1.setY(img1Y);
            if(img1Y == 350){
                img1Up = true;
                img1Down = false;
            }
        }
        // Ballon 2
        if(img2Up) {
            img2Y -= 1;
            img2.setY(img2Y);
            if(img2Y == 200){
                img2Up = false;
                img2Down = true;
            }
        } else if(img2Down) {
            img2Y += 1;
            img2.setY(img2Y);
            if(img2Y == 350){
                img2Up = true;
                img2Down = false;
            }
        }
        // Ballon 3
        if(img3Up) {
            img3Y -= 1;
            img3.setY(img3Y);
            if(img3Y == 200){
                img3Up = false;
                img3Down = true;
            }
        } else if(img3Down) {
            img3Y += 1;
            img3.setY(img3Y);
            if(img3Y == 450){
                img3Up = true;
                img3Down = false;
            }
        }
        // Ballon 4
        if(img4Up) {
            img4Y -= 1;
            img4.setY(img4Y);
            if(img4Y == 300){
                img4Up = false;
                img4Down = true;
            }
        } else if(img4Down) {
            img4Y += 1;
            img4.setY(img4Y);
            if(img4Y == 450){
                img4Up = true;
                img4Down = false;
            }
        }
        // Ballon 5
        if(img5Up) {
            img5Y -= 1;
            img5.setY(img5Y);
            if(img5Y == 300){
                img5Up = false;
                img5Down = true;
            }
        } else if(img5Down) {
            img5Y += 1;
            img5.setY(img5Y);
            if(img5Y == 450){
                img5Up = true;
                img5Down = false;
            }
        }


    }

    public void startBallons(View view)
    {

        if(Integer.parseInt(view.getTag().toString()) == 1) {
            Toast.makeText(this, "وەڵامەکەت ڕاستە", Toast.LENGTH_LONG).show();

            fireworkGIF1.setVisibility(View.VISIBLE);
            fireworkGIF2.setVisibility(View.VISIBLE);
        }
        else {
            Toast.makeText(this, "وەڵامەکەت هەڵەیە", Toast.LENGTH_LONG).show();
            sadFaceGIF.setVisibility(View.VISIBLE);
        }
        img1.setVisibility(View.INVISIBLE);
        img2.setVisibility(View.INVISIBLE);
        img3.setVisibility(View.INVISIBLE);
        img4.setVisibility(View.INVISIBLE);
        img5.setVisibility(View.INVISIBLE);

        txt.setVisibility(View.INVISIBLE);

        timerView = view;
        timer2 = new Timer();
        handler2 = new Handler();

        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                handler2.post(new Runnable() {
                    @Override
                    public void run() {

                        if(a == 80) {
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.VISIBLE);
                            img3.setVisibility(View.VISIBLE);
                            img4.setVisibility(View.VISIBLE);
                            img5.setVisibility(View.VISIBLE);

                            txt.setVisibility(View.VISIBLE);

                            fireworkGIF1.setVisibility(View.INVISIBLE);
                            fireworkGIF2.setVisibility(View.INVISIBLE);
                            sadFaceGIF.setVisibility(View.INVISIBLE);
                            start(timerView);
                            timer2.cancel();
                            a = 0;
                        }
                        a++;
                    }
                });
            }
        }, 0, 50);



    }
    public void start(View view)
    {
        introductionLayout.setVisibility(View.INVISIBLE);
        img1Result = -1;
        img2Result = -1;
        img3Result = -1;
        img4Result = -1;
        img5Result = -1;
        img1.setClickable(true);
        img2.setClickable(true);
        img3.setClickable(true);
        img4.setClickable(true);
        img5.setClickable(true);
        img1.setTag(-1);
        img2.setTag(-1);
        img3.setTag(-1);
        img4.setTag(-1);
        img5.setTag(-1);
        btn.setClickable(false);

        img1.setVisibility(View.VISIBLE);
        img2.setVisibility(View.VISIBLE);
        img3.setVisibility(View.VISIBLE);
        img4.setVisibility(View.VISIBLE);
        img5.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);

        for (int i = 1; i < 6; i++) {
            setNumbersForImages();
            setImgRes1(i);
            if(i==1)
                img1Result = result;
            else if(i==2)
                img2Result = result;
            else if(i==3)
                img3Result = result;
            else if(i==4)
                img4Result = result;
            else//if(i==5)
                img5Result = result;
        }
        int randomAns = -1;
        while(true)
        {
            randomAns = r.nextInt(5);
            if(randomAns<0)
                continue;
            else if(randomAns>4)
                continue;
            else
                break;
        }
        switch (randomAns)
        {
            case 0:
                img1.setTag(1);
                randomAns = img1Result;
                break;
            case 1:img2.setTag(1);
                randomAns = img2Result;
                break;
            case 2:img3.setTag(1);
                randomAns = img3Result;
                break;
            case 3:img4.setTag(1);
                randomAns = img4Result;
                break;
            case 4:img5.setTag(1);
                randomAns = img5Result;
                break;
        }
        txtResultKurdish(randomAns);
    }
    public void setNumbersForImages()
    {
        while(true)
        {
            operator1 = r.nextInt(11);
            if(operator1<0)
                continue;
            else if(operator1>10)
                continue;
            else
                break;
        }
        while (true)
        {
            operator2 = r.nextInt(11);
            if (operator2<0)
                continue;
            else if(operator2>10)
                continue;
            else if(operator2>operator1)
                continue;
            else
                break;
        }
        result = operator1 - operator2;

        if(result == img1Result || result == img2Result || result == img3Result || result == img4Result || result == img5Result)
            setNumbersForImages();
    }
    public void txtResultKurdish(int ans) {
        switch(ans) {

            case 0:
                txt.setText("کامە باڵۆن دەکاتە ( ٠ )");
                break;
            case 1:
                txt.setText("کامە باڵۆن دەکاتە ( ١ )");
                break;
            case 2:
                txt.setText("کامە باڵۆن دەکاتە ( ٢ )");
                break;
            case 3:
                txt.setText("کامە باڵۆن دەکاتە ( ٣ )");
                break;
            case 4:
                txt.setText("کامە باڵۆن دەکاتە ( ٤ )");
                break;
            case 5:
                txt.setText("کامە باڵۆن دەکاتە ( ٥ )");
                break;
            case 6:
                txt.setText("کامە باڵۆن دەکاتە ( ٦ )");
                break;
            case 7:
                txt.setText("کامە باڵۆن دەکاتە ( ٧ )");
                break;
            case 8:
                txt.setText("کامە باڵۆن دەکاتە ( ٨ )");
                break;
            case 9:
                txt.setText("کامە باڵۆن دەکاتە ( ٩ )");
                break;
            case 10:
                txt.setText("کامە باڵۆن دەکاتە ( ١٠ )");
                break;
        }
    }

    public void setImgRes1(int i)
    {
        switch(operator1)
        {
            case 0:setNumber0Img(i);
                break;
            case 1:setNumber1Img(i);
                break;
            case 2:setNumber2Img(i);
                break;
            case 3:setNumber3Img(i);
                break;
            case 4:setNumber4Img(i);
                break;
            case 5:setNumber5Img(i);
                break;
            case 6:setNumber6Img(i);
                break;
            case 7:setNumber7Img(i);
                break;
            case 8:setNumber8Img(i);
                break;
            case 9:setNumber9Img(i);
                break;
            case 10:setNumber10Img(i);
                break;
            default:
                break;
        }
    }
    public void setNumber0Img(int i) {
        switch(i)
        {
            case 1:img1.setImageResource(num0Res[operator2]);
                break;
            case 2:img2.setImageResource(num0Res[operator2]);
                break;
            case 3:img3.setImageResource(num0Res[operator2]);
                break;
            case 4:img4.setImageResource(num0Res[operator2]);
                break;
            case 5:img5.setImageResource(num0Res[operator2]);
                break;
        }
    }
    public void setNumber1Img(int i) {
        switch(i)
        {
            case 1:img1.setImageResource(num1Res[operator2]);
                break;
            case 2:img2.setImageResource(num1Res[operator2]);
                break;
            case 3:img3.setImageResource(num1Res[operator2]);
                break;
            case 4:img4.setImageResource(num1Res[operator2]);
                break;
            case 5:img5.setImageResource(num1Res[operator2]);
                break;
        }
    }
    public void setNumber2Img(int i) {
        switch(i)
        {
            case 1:img1.setImageResource(num2Res[operator2]);
                break;
            case 2:img2.setImageResource(num2Res[operator2]);
                break;
            case 3:img3.setImageResource(num2Res[operator2]);
                break;
            case 4:img4.setImageResource(num2Res[operator2]);
                break;
            case 5:img5.setImageResource(num2Res[operator2]);
                break;
        }
    }
    public void setNumber3Img(int i) {
        switch(i)
        {
            case 1:img1.setImageResource(num3Res[operator2]);
                break;
            case 2:img2.setImageResource(num3Res[operator2]);
                break;
            case 3:img3.setImageResource(num3Res[operator2]);
                break;
            case 4:img4.setImageResource(num3Res[operator2]);
                break;
            case 5:img5.setImageResource(num3Res[operator2]);
                break;
        }
    }
    public void setNumber4Img(int i) {
        switch(i)
        {
            case 1:img1.setImageResource(num4Res[operator2]);
                break;
            case 2:img2.setImageResource(num4Res[operator2]);
                break;
            case 3:img3.setImageResource(num4Res[operator2]);
                break;
            case 4:img4.setImageResource(num4Res[operator2]);
                break;
            case 5:img5.setImageResource(num4Res[operator2]);
                break;
        }
    }
    public void setNumber5Img(int i) {
        switch(i)
        {
            case 1:img1.setImageResource(num5Res[operator2]);
                break;
            case 2:img2.setImageResource(num5Res[operator2]);
                break;
            case 3:img3.setImageResource(num5Res[operator2]);
                break;
            case 4:img4.setImageResource(num5Res[operator2]);
                break;
            case 5:img5.setImageResource(num5Res[operator2]);
                break;
        }
    }
    public void setNumber6Img(int i) {
        switch(i)
        {
            case 1:img1.setImageResource(num6Res[operator2]);
                break;
            case 2:img2.setImageResource(num6Res[operator2]);
                break;
            case 3:img3.setImageResource(num6Res[operator2]);
                break;
            case 4:img4.setImageResource(num6Res[operator2]);
                break;
            case 5:img5.setImageResource(num6Res[operator2]);
                break;
        }
    }
    public void setNumber7Img(int i) {
        switch(i)
        {
            case 1:img1.setImageResource(num7Res[operator2]);
                break;
            case 2:img2.setImageResource(num7Res[operator2]);
                break;
            case 3:img3.setImageResource(num7Res[operator2]);
                break;
            case 4:img4.setImageResource(num7Res[operator2]);
                break;
            case 5:img5.setImageResource(num7Res[operator2]);
                break;
        }
    }
    public void setNumber8Img(int i) {
        switch(i)
        {
            case 1:img1.setImageResource(num8Res[operator2]);
                break;
            case 2:img2.setImageResource(num8Res[operator2]);
                break;
            case 3:img3.setImageResource(num8Res[operator2]);
                break;
            case 4:img4.setImageResource(num8Res[operator2]);
                break;
            case 5:img5.setImageResource(num8Res[operator2]);
                break;
        }
    }
    public void setNumber9Img(int i) {
        switch(i)
        {
            case 1:img1.setImageResource(num9Res[operator2]);
                break;
            case 2:img2.setImageResource(num9Res[operator2]);
                break;
            case 3:img3.setImageResource(num9Res[operator2]);
                break;
            case 4:img4.setImageResource(num9Res[operator2]);
                break;
            case 5:img5.setImageResource(num9Res[operator2]);
                break;
        }
    }
    public void setNumber10Img(int i) {
        switch(i)
        {
            case 1:img1.setImageResource(num10Res[operator2]);
                break;
            case 2:img2.setImageResource(num10Res[operator2]);
                break;
            case 3:img3.setImageResource(num10Res[operator2]);
                break;
            case 4:img4.setImageResource(num10Res[operator2]);
                break;
            case 5:img5.setImageResource(num10Res[operator2]);
                break;
        }
    }
    public void close(View v) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}

