package com.example.ibrahim.basicmathforkidsnexus10lastupdate;

import android.graphics.Point;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SkyKite extends AppCompatActivity {

    // Screen Size
    private int screenWidth;
    private int screenHeight;

    // Images
    private ImageView arrowUp;
    private ImageView arrowDown;
    private ImageView arrowRight;
    private ImageView arrowLeft;
    private ImageView arrowUp2;
    private ImageView arrowDown2;
    private ImageView arrowRight2;
    private ImageView arrowLeft2;

    // Layout
    private LinearLayout layout;
    private LinearLayout introductionLayout;

    // Position
    private float arrowUpX;
    private float arrowUpY;
    private float arrowDownX;
    private float arrowDownY;
    private float arrowRightX;
    private float arrowRightY;
    private float arrowLeftX;
    private float arrowLeftY;
    private float arrowUpX2;
    private float arrowUpY2;
    private float arrowDownX2;
    private float arrowDownY2;
    private float arrowRightX2;
    private float arrowRightY2;
    private float arrowLeftX2;
    private float arrowLeftY2;

    // Initialize Class
    private Handler handler = new Handler();
    private Timer timer = new Timer();
    private Random random = new Random();
    private TextView kiteCountTxt;
    private TextView timerTxt;

    // Status Check
    private boolean pause_flg = false;

    // variables
    private int result;
    private int randomNumber;
    private int counter;
    private int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sky_kite);

        arrowUp = (ImageView)findViewById(R.id.kite_up);
        arrowDown = (ImageView)findViewById(R.id.kite_down);
        arrowRight = (ImageView)findViewById(R.id.kite_right);
        arrowLeft = (ImageView)findViewById(R.id.kite_left);
        arrowUp2 = (ImageView)findViewById(R.id.kite_up2);
        arrowDown2 = (ImageView)findViewById(R.id.kite_down2);
        arrowRight2 = (ImageView)findViewById(R.id.kite_right2);
        arrowLeft2 = (ImageView)findViewById(R.id.kite_left2);
        layout = (LinearLayout)findViewById(R.id.layout);
        introductionLayout = (LinearLayout)findViewById(R.id.start_layout);
        kiteCountTxt = (TextView)findViewById(R.id.kite_count_txt);
        timerTxt = (TextView)findViewById(R.id.timer_txt);

        // Get Screen Size.
        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        // Move to out of screen.
        arrowUp.setX(-180.0f);
        arrowUp.setY(-180.0f);
        arrowDown.setX(-80.0f);
        arrowDown.setY(screenHeight + 80.0f);
        arrowRight.setX(screenWidth + 80.0f);
        arrowRight.setY(-80.0f);
        arrowLeft.setX(screenWidth + 80.0f);
        arrowLeft.setY(screenHeight + 80.0f);
        arrowUp2.setX(-180.0f);
        arrowUp2.setY(-180.0f);
        arrowDown2.setX(-80.0f);
        arrowDown2.setY(screenHeight + 80.0f);
        arrowRight2.setX(screenWidth + 80.0f);
        arrowRight2.setY(-80.0f);
        arrowLeft2.setX(screenWidth + 80.0f);
        arrowLeft2.setY(screenHeight + 80.0f);


        while (true) {
            randomNumber = random.nextInt(9);
            if (randomNumber < 1)
                continue;
            else if (randomNumber > 8)
                continue;
            else {
                result = randomNumber;
                break;
            }
        }
    }

    private void cancelTimer() {

        time = 0;
        new CountDownTimer(17000,1000) {
            @Override
            public void onTick(long l) {
                switch (time) {
                    case 0: timerTxt.setText("٠٠:١٥");
                        break;
                    case 1: timerTxt.setText("٠٠:١٤");
                        break;
                    case 2: timerTxt.setText("٠٠:١٣");
                        break;
                    case 3: timerTxt.setText("٠٠:١٢");
                        break;
                    case 4: timerTxt.setText("٠٠:١١");
                        break;
                    case 5: timerTxt.setText("٠٠:١٠");
                        break;
                    case 6: timerTxt.setText("٠٠:٠٩");
                        break;
                    case 7: timerTxt.setText("٠٠:٠٨");
                        break;
                    case 8: timerTxt.setText("٠٠:٠٧");
                        break;
                    case 9: timerTxt.setText("٠٠:٠٦");
                        break;
                    case 10: timerTxt.setText("٠٠:٠٥");
                        break;
                    case 11: timerTxt.setText("٠٠:٠٤");
                        break;
                    case 12: timerTxt.setText("٠٠:٠٣");
                        break;
                    case 13: timerTxt.setText("٠٠:٠٢");
                        break;
                    case 14: timerTxt.setText("٠٠:٠١");
                        break;
                    case 15: timerTxt.setText("٠٠:٠٠");
                        break;
                }
                time++;
            }

            @Override
            public void onFinish() {
                timer.cancel();
                arrowUp.setVisibility(View.INVISIBLE);
                arrowUp2.setVisibility(View.INVISIBLE);
                arrowDown.setVisibility(View.INVISIBLE);
                arrowDown2.setVisibility(View.INVISIBLE);
                arrowRight.setVisibility(View.INVISIBLE);
                arrowRight2.setVisibility(View.INVISIBLE);
                arrowLeft.setVisibility(View.INVISIBLE);
                arrowLeft2.setVisibility(View.INVISIBLE);
                layout.setVisibility(View.VISIBLE);
                kiteCountTxt.setVisibility(View.INVISIBLE);
                timerTxt.setVisibility(View.INVISIBLE);
            }
        }.start();
    }
    public void changePos() {
        if(counter < randomNumber) {
            // Up
            arrowUpY -= 10;
            if (arrowUp.getY() + arrowUp.getHeight() < 0) {
                arrowUpX = (float) Math.floor(Math.random() * (screenWidth - arrowUp.getWidth()));
                arrowUpY = screenHeight + 100.0f;
            }
            arrowUp.setX(arrowUpX);
            arrowUp.setY(arrowUpY);
            counter++;

            if (counter < randomNumber) {
                // Down
                arrowDownY += 10;
                if (arrowDown.getY() > screenHeight) {
                    arrowDownX = (float) Math.floor(Math.random() * (screenWidth - arrowDown.getWidth()));
                    arrowDownY = -100.0f;
                }
                arrowDown.setX(arrowDownX);
                arrowDown.setY(arrowDownY);
                counter++;

                if(counter < randomNumber) {
                    // Right
                    arrowRightX += 10;
                    if (arrowRight.getX() > screenWidth) {
                        arrowRightX = -100.0f;
                        arrowRightY = (float) Math.floor(Math.random() * (screenHeight - arrowRight.getHeight()));
                    }
                    arrowRight.setX(arrowRightX);
                    arrowRight.setY(arrowRightY);
                    counter++;

                    if(counter < randomNumber) {
                        // Left
                        arrowLeftX -= 10;
                        if (arrowLeft.getX() + arrowLeft.getWidth() < 0) {
                            arrowLeftX = screenWidth + 100.0f;
                            arrowLeftY = (float) Math.floor(Math.random() * (screenHeight - arrowLeft.getHeight()));
                        }
                        arrowLeft.setX(arrowLeftX);
                        arrowLeft.setY(arrowLeftY);
                        counter++;

                        if(counter < randomNumber) {
                            // Up2
                            arrowUpY2 -= 7;
                            if (arrowUp2.getY() + arrowUp2.getHeight() < 0) {
                                arrowUpX2 = (float) Math.floor(Math.random() * (screenWidth - arrowUp2.getWidth()));
                                arrowUpY2 = screenHeight + 100.0f;
                            }
                            arrowUp2.setX(arrowUpX2);
                            arrowUp2.setY(arrowUpY2);
                            counter++;

                            if(counter < randomNumber) {
                                // Down2
                                arrowDownY2 += 7;
                                if (arrowDown2.getY() > screenHeight) {
                                    arrowDownX2 = (float) Math.floor(Math.random() * (screenWidth - arrowDown2.getWidth()));
                                    arrowDownY2 = -100.0f;
                                }
                                arrowDown2.setX(arrowDownX2);
                                arrowDown2.setY(arrowDownY2);
                                counter++;

                                if(counter < randomNumber) {
                                    // Right2
                                    arrowRightX2 += 7;
                                    if (arrowRight2.getX() > screenWidth) {
                                        arrowRightX2 = -100.0f;
                                        arrowRightY2 = (float) Math.floor(Math.random() * (screenHeight - arrowRight2.getHeight()));
                                    }
                                    arrowRight2.setX(arrowRightX2);
                                    arrowRight2.setY(arrowRightY2);
                                    counter++;

                                    if(counter < randomNumber) {
                                        // Left2
                                        arrowLeftX2 -= 7;
                                        if (arrowLeft2.getX() + arrowLeft2.getWidth() < 0) {
                                            arrowLeftX2 = screenWidth + 100.0f;
                                            arrowLeftY2 = (float) Math.floor(Math.random() * (screenHeight - arrowLeft2.getHeight()));
                                        }
                                        arrowLeft2.setX(arrowLeftX2);
                                        arrowLeft2.setY(arrowLeftY2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        counter = 0;
    }

    public void checkAnswer(View v) {

        if (Integer.parseInt(v.getTag().toString()) == result)
            Toast.makeText(this, "وەڵامەکەت ڕاستە", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "وەڵامەکەت هەڵەیە", Toast.LENGTH_LONG).show();

        // Move to out of screen.
        arrowUp.setX(-180.0f);
        arrowUp.setY(-180.0f);
        arrowDown.setX(-80.0f);
        arrowDown.setY(screenHeight + 80.0f);
        arrowRight.setX(screenWidth + 80.0f);
        arrowRight.setY(-80.0f);
        arrowLeft.setX(screenWidth + 80.0f);
        arrowLeft.setY(screenHeight + 80.0f);
        arrowUp2.setX(-180.0f);
        arrowUp2.setY(-180.0f);
        arrowDown2.setX(-80.0f);
        arrowDown2.setY(screenHeight + 80.0f);
        arrowRight2.setX(screenWidth + 80.0f);
        arrowRight2.setY(-80.0f);
        arrowLeft2.setX(screenWidth + 80.0f);
        arrowLeft2.setY(screenHeight + 80.0f);

        while (true) {
            randomNumber = random.nextInt(9);
            if (randomNumber < 1)
                continue;
            else if (randomNumber > 8)
                continue;
            else if (randomNumber == result)
                continue;
            else {
                result = randomNumber;
                break;
            }
        }
        layout.setVisibility(View.INVISIBLE);
        arrowUp.setVisibility(View.VISIBLE);
        arrowUp2.setVisibility(View.VISIBLE);
        arrowDown.setVisibility(View.VISIBLE);
        arrowDown2.setVisibility(View.VISIBLE);
        arrowRight.setVisibility(View.VISIBLE);
        arrowRight2.setVisibility(View.VISIBLE);
        arrowLeft.setVisibility(View.VISIBLE);
        arrowLeft2.setVisibility(View.VISIBLE);
        kiteCountTxt.setVisibility(View.VISIBLE);
        timerTxt.setVisibility(View.VISIBLE);

        //timer.cancel();
        timer = new Timer();
        // Start the timer.
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
        }, 0, 100);

        cancelTimer();

    }

    public void start(View view) {
        // Start the timer.
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
        }, 0, 100);

        cancelTimer();
        introductionLayout.setVisibility(View.INVISIBLE);
        kiteCountTxt.setVisibility(View.VISIBLE);
        timerTxt.setVisibility(View.VISIBLE);
    }
}