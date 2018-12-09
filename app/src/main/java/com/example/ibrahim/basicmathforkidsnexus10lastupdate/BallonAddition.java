package com.example.ibrahim.basicmathforkidsnexus10lastupdate;

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

public class BallonAddition extends AppCompatActivity {

    private ImageView img1,img2,img3,img4,img5;
    private ImageView fireworkGIF1,fireworkGIF2,sadFaceGIF;
    private Button btn;
    private TextView txt;
    private LinearLayout introductionLayout;

    int [] num0Res = {R.drawable.aa, R.drawable.ab, R.drawable.ac, R.drawable.ad, R.drawable.ae, R.drawable.af, R.drawable.ag, R.drawable.ah, R.drawable.ai, R.drawable.aj, R.drawable.ak};
    int [] num1Res = {R.drawable.ba, R.drawable.bb, R.drawable.bc, R.drawable.bd, R.drawable.be, R.drawable.bf, R.drawable.bg, R.drawable.bh, R.drawable.bi, R.drawable.bj, R.drawable.bk};
    int [] num2Res = {R.drawable.ca, R.drawable.cb, R.drawable.cc, R.drawable.cd, R.drawable.ce, R.drawable.cf, R.drawable.cg, R.drawable.ch, R.drawable.ci, R.drawable.cj, R.drawable.ck};
    int [] num3Res = {R.drawable.da, R.drawable.db, R.drawable.dc, R.drawable.dd, R.drawable.de, R.drawable.df, R.drawable.dg, R.drawable.dh, R.drawable.di, R.drawable.dj, R.drawable.dk};
    int [] num4Res = {R.drawable.ea, R.drawable.eb, R.drawable.ec, R.drawable.ed, R.drawable.ee, R.drawable.ef, R.drawable.eg, R.drawable.eh, R.drawable.ei, R.drawable.ej, R.drawable.ek};
    int [] num5Res = {R.drawable.fa, R.drawable.fb, R.drawable.fc, R.drawable.fd, R.drawable.fe, R.drawable.ff, R.drawable.fg, R.drawable.fh, R.drawable.fi, R.drawable.fj, R.drawable.fk};
    int [] num6Res = {R.drawable.ga, R.drawable.gb, R.drawable.gc, R.drawable.gd, R.drawable.ge, R.drawable.gf, R.drawable.gg, R.drawable.gh, R.drawable.gi, R.drawable.gj, R.drawable.gk};
    int [] num7Res = {R.drawable.ha, R.drawable.hb, R.drawable.hc, R.drawable.hd, R.drawable.he, R.drawable.hf, R.drawable.hg, R.drawable.hh, R.drawable.hi, R.drawable.hj, R.drawable.hk};
    int [] num8Res = {R.drawable.ia, R.drawable.ib, R.drawable.ic, R.drawable.id, R.drawable.ie, R.drawable.ifz,R.drawable.ig, R.drawable.ih, R.drawable.ii, R.drawable.ij, R.drawable.ik};
    int [] num9Res = {R.drawable.ja, R.drawable.jb, R.drawable.jc, R.drawable.jd, R.drawable.je, R.drawable.jf, R.drawable.jg, R.drawable.jh, R.drawable.ji, R.drawable.jj, R.drawable.jk};
    int [] num10Res= {R.drawable.ka, R.drawable.kb, R.drawable.kc, R.drawable.kd, R.drawable.ke, R.drawable.kf, R.drawable.kg, R.drawable.kh, R.drawable.ki, R.drawable.kj, R.drawable.kk};

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
        setContentView(R.layout.ballon_addition);

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
            else
                break;
        }
        result = operator1 + operator2;

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
            case 11:
                txt.setText("کامە باڵۆن دەکاتە ( ١١ )");
                break;
            case 12:
                txt.setText("کامە باڵۆن دەکاتە ( ١٢ )");
                break;
            case 13:
                txt.setText("کامە باڵۆن دەکاتە ( ١٣ )");
                break;
            case 14:
                txt.setText("کامە باڵۆن دەکاتە ( ١٤ )");
                break;
            case 15:
                txt.setText("کامە باڵۆن دەکاتە ( ١٥ )");
                break;
            case 16:
                txt.setText("کامە باڵۆن دەکاتە ( ١٦ )");
                break;
            case 17:
                txt.setText("کامە باڵۆن دەکاتە ( ١٧ )");
                break;
            case 18:
                txt.setText("کامە باڵۆن دەکاتە ( ١٨ )");
                break;
            case 19:
                txt.setText("کامە باڵۆن دەکاتە ( ١٩ )");
                break;
            case 20:
                txt.setText("کامە باڵۆن دەکاتە ( ٢٠ )");
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

}