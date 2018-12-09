package com.example.ibrahim.basicmathforkidsnexus10lastupdate;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class DrawingSurface extends ImageView
{
    private int bitmapPixels[];
    private int bitmapWidth;
    private int bitmapHeight;
    private Bitmap bitmap;
    BitmapFactory.Options options = new BitmapFactory.Options();



    private final int colors[] = {Color.rgb(0, 135, 68), Color.rgb(0, 87, 231), Color.rgb(214, 45, 32), Color.rgb(255, 167, 0), Color.rgb(244, 67, 54), Color.rgb(233, 30, 99), Color.rgb(156, 39, 176), Color.YELLOW};

    private boolean belongsToColors(int color)
    {
        for (int color1 : colors) if (color == color1) return true;
        return false;
    }

    public DrawingSurface(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        options.inMutable = true;
        options.inScaled = false;
    }

    public void setSourceImage(int image)
    {
        bitmap = BitmapFactory.decodeResource(getResources(), image, options);
        setImageBitmap(bitmap);
        bitmapWidth = bitmap.getWidth();
        bitmapHeight = bitmap.getHeight();

        bitmapPixels = new int[bitmapWidth * bitmapHeight];
        bitmap.getPixels(bitmapPixels, 0, bitmapWidth, 0, 0, bitmapWidth, bitmapHeight);
    }

    public static Bitmap loadBitmapFromView(View v, int width, int height) {
        Bitmap b = Bitmap.createBitmap(width , height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.draw(c);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        Bitmap bitmap1 = loadBitmapFromView(this, getWidth(), getHeight());
        int clickedPixel = bitmap1.getPixel((int)event.getX() , (int)event.getY());

        changeBodyPartColor(clickedPixel);

        return true;
    }


    private int outlineColor = Color.rgb(166, 166, 166);

    private int colorIndex = 0;

    public void changeBodyPartColor(int clickedPixel)
    {
        if (clickedPixel != Color.WHITE && !belongsToColors(clickedPixel) && clickedPixel != outlineColor)
        {
            for (int i = 0; i < bitmapPixels.length; i++)
                if (bitmapPixels[i] == clickedPixel) bitmapPixels[i] = colors[colorIndex];

            bitmap.setPixels(bitmapPixels, 0, bitmapWidth, 0, 0, bitmapWidth, bitmapHeight);
            setImageBitmap(bitmap);
            colorIndex++;
            colorIndex = colorIndex % colors.length;
        }
    }

}
