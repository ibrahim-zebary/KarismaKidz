package com.example.ibrahim.basicmathforkidsnexus10lastupdate;

import android.content.ClipData;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class BirdAddition extends AppCompatActivity {

    ImageView imgBird1,imgBird2,imgBird3;
    TextView txtOprt1,txtOprt2,txtReslt;
    Button btn;
    LinearLayout start_layout;

    Random r = new Random();
    View v;

    int num;
    int temp = -1;
    int a;
    int b;
    int c;
    int number1;
    int number2;
    int result;
    int choseABC;
    int imgRes [] = {R.drawable.bird0,
            R.drawable.bird1,
            R.drawable.bird2,
            R.drawable.bird3,
            R.drawable.bird4,
            R.drawable.bird5,
            R.drawable.bird6,
            R.drawable.bird7,
            R.drawable.bird8,
            R.drawable.bird9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bird_addition);

        imgBird1 = (ImageView)findViewById(R.id.img_1);
        imgBird2 = (ImageView)findViewById(R.id.img_2);
        imgBird3 = (ImageView)findViewById(R.id.img_3);

        txtOprt1 = (TextView)findViewById(R.id.txt_oprt1);
        txtOprt2 = (TextView)findViewById(R.id.txt_oprt2);
        txtReslt = (TextView)findViewById(R.id.txt_result);

        btn = (Button)findViewById(R.id.btn);

        start_layout = (LinearLayout)findViewById(R.id.start_layout);

        imgBird1.setOnTouchListener(touchListener);
        imgBird2.setOnTouchListener(touchListener);
        imgBird3.setOnTouchListener(touchListener);

        txtOprt2.setOnDragListener(dragListener);

    }

    View.OnTouchListener touchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent)
        {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            ClipData data = ClipData.newPlainText("","");
            view.startDrag(data,shadowBuilder,view,0);

            v = view;

            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener()
    {
        int dragEvent;
        @Override
        public boolean onDrag(View view, DragEvent event)
        {
            dragEvent = event.getAction();
            switch (dragEvent)
            {
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:

                    result(v);

                    a = -1;
                    b = -1;
                    c = -1;

                    setOperatorNumbers();
                    while(true) {
                        num = r.nextInt(10);
                        if (num < 0)
                            continue;
                        else if (num > 9)
                            continue;
                        else if (temp == num)
                            continue;
                        else if (num == a)
                            continue;
                        else if (num == b)
                            continue;
                        else if (num == c)
                            continue;
                        else {
                            if (!(a > -1))
                                a = num;
                            else if (!(b > -1))
                                b = num;
                            else if (!(c > -1)) {
                                c = num;
                                break;
                            }
                        }
                        temp = num;
                    }
                    setImageRandomlly();
                    setTxtOprt1(number1);
                    settxtReslt(result);
                    break;
            }
            return true;
        }
    };
    public void result(View view) {
        if(Integer.parseInt(view.getTag().toString()) == 1)
            Toast.makeText(this, "وەڵامەکەت ڕاستە", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"وەڵامەکەت ‌‌هەڵەیە",Toast.LENGTH_LONG).show();
    }
    public void start(View v)
    {
        start_layout.setVisibility(View.INVISIBLE);

        imgBird1.setVisibility(View.VISIBLE);
        imgBird2.setVisibility(View.VISIBLE);
        imgBird3.setVisibility(View.VISIBLE);

        txtOprt1.setVisibility(View.VISIBLE);
        txtOprt2.setVisibility(View.VISIBLE);
        txtReslt.setVisibility(View.VISIBLE);

        a = -1;
        b = -1;
        c = -1;

        setOperatorNumbers();
        while(true)
        {
            num = r.nextInt(10);
            if(num < 0)
                continue;
            else if(num > 9)
                continue;
            else if(temp == num)
                continue;
            else
            {
                if(!(a > -1))/////////////////
                    a = num;
                else if (!(b > -1))
                    b = num;
                else if (!(c > -1)) {
                    c = num;
                    break;
                }
            }
            temp = num;
        }
        setImageRandomlly();
        //txtOprt1.setText(number1+"");
        //txtReslt.setText(result+"");
        setTxtOprt1(number1);
        settxtReslt(result);
    }
    public void setTxtOprt1(int ans) {
        switch(ans) {

            case 0:
                txtOprt1.setText("٠");
                break;
            case 1:
                txtOprt1.setText("١");
                break;
            case 2:
                txtOprt1.setText("٢");
                break;
            case 3:
                txtOprt1.setText("٣");
                break;
            case 4:
                txtOprt1.setText("٤");
                break;
            case 5:
                txtOprt1.setText("٥");
                break;
            case 6:
                txtOprt1.setText("٦");
                break;
            case 7:
                txtOprt1.setText("٧");
                break;
            case 8:
                txtOprt1.setText("٨");
                break;
            case 9:
                txtOprt1.setText("٩");
                break;
            case 10:
                txtOprt1.setText("١٠");
                break;
            case 11:
                txtOprt1.setText("١١");
                break;
            case 12:
                txtOprt1.setText("١٢");
                break;
            case 13:
                txtOprt1.setText("١٣");
                break;
            case 14:
                txtOprt1.setText("١٤");
                break;
            case 15:
                txtOprt1.setText("١٥");
                break;
            case 16:
                txtOprt1.setText("١٦");
                break;
            case 17:
                txtOprt1.setText("١٧");
                break;
            case 18:
                txtOprt1.setText("١٨");
                break;
            case 19:
                txtOprt1.setText("١٩");
                break;
            case 20:
                txtOprt1.setText("٢٠");
                break;
        }
    }
    public void settxtReslt(int ans) {
        switch(ans) {

            case 0:
                txtReslt.setText("٠");
                break;
            case 1:
                txtReslt.setText("١");
                break;
            case 2:
                txtReslt.setText("٢");
                break;
            case 3:
                txtReslt.setText("٣");
                break;
            case 4:
                txtReslt.setText("٤");
                break;
            case 5:
                txtReslt.setText("٥");
                break;
            case 6:
                txtReslt.setText("٦");
                break;
            case 7:
                txtReslt.setText("٧");
                break;
            case 8:
                txtReslt.setText("٨");
                break;
            case 9:
                txtReslt.setText("٩");
                break;
            case 10:
                txtReslt.setText("١٠");
                break;
            case 11:
                txtReslt.setText("١١");
                break;
            case 12:
                txtReslt.setText("١٢");
                break;
            case 13:
                txtReslt.setText("١٣");
                break;
            case 14:
                txtReslt.setText("١٤");
                break;
            case 15:
                txtReslt.setText("١٥");
                break;
            case 16:
                txtReslt.setText("١٦");
                break;
            case 17:
                txtReslt.setText("١٧");
                break;
            case 18:
                txtReslt.setText("١٨");
                break;
            case 19:
                txtReslt.setText("١٩");
                break;
            case 20:
                txtReslt.setText("٢٠");
                break;
        }
    }
    public void setOperatorNumbers()
    {
        while(true)
        {
            number1 = r.nextInt(10);
            if(number1<0)
                continue;
            else if(number1>9)
                continue;
            else
                break;
        }
        while (true)
        {
            number2 = r.nextInt(10);
            if (number2<0)
                continue;
            else if(number2>9)
                continue;
            else
                break;
        }
        result = number1 + number2;
    }
    public void setImageRandomlly()
    {
        while(true)
        {
            choseABC = r.nextInt(3);
            if (choseABC < 0)
                continue;
            else if(choseABC > 2)
                continue;
            else if(choseABC == 0 && (b == number2 || c == number2))
                continue;
            else if(choseABC == 1 && (a == number2 || c == number2))
                continue;
            else if(choseABC == 2 && (a == number2 || b == number2))
                continue;
            else
                break;
        }
        switch(choseABC)
        {
            case 0:
                imgBird1.setImageResource(imgRes[number2]);
                imgBird2.setImageResource(imgRes[b]);
                imgBird3.setImageResource(imgRes[c]);

                imgBird1.setTag(1);
                imgBird2.setTag(0);
                imgBird3.setTag(0);
                break;
            case 1:
                imgBird1.setImageResource(imgRes[a]);
                imgBird2.setImageResource(imgRes[number2]);
                imgBird3.setImageResource(imgRes[c]);

                imgBird1.setTag(0);
                imgBird2.setTag(1);
                imgBird3.setTag(0);
                break;
            case 2:
                imgBird1.setImageResource(imgRes[a]);
                imgBird2.setImageResource(imgRes[b]);
                imgBird3.setImageResource(imgRes[number2]);

                imgBird1.setTag(0);
                imgBird2.setTag(0);
                imgBird3.setTag(1);
                break;
        }
    }
}