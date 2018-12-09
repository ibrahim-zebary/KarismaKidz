package com.example.ibrahim.basicmathforkidsnexus10lastupdate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class MainDesign extends AppCompatActivity {

    private CardView numberPart;
    private CardView countPart;
    private CardView addPart;
    private CardView subPart;

    private LinearLayout numbersLinearLayout;
    private LinearLayout countLinearLayout;
    private LinearLayout addLinearLayout;
    private LinearLayout subLinearLayout;

    private LinearLayout numbersIcon;
    private LinearLayout countIcon;
    private LinearLayout addIcon;
    private LinearLayout subIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_design);
        numberPart = (CardView)findViewById(R.id.numbers_part);
        countPart = (CardView)findViewById(R.id.counting_part);
        addPart = (CardView)findViewById(R.id.addition_part);
        subPart = (CardView)findViewById(R.id.subtraction_part);

        numbersLinearLayout = (LinearLayout)findViewById(R.id.numbers_linear_layout);
        countLinearLayout = (LinearLayout)findViewById(R.id.count_linear_layout);
        addLinearLayout = (LinearLayout)findViewById(R.id.add_linear_layout);
        subLinearLayout = (LinearLayout)findViewById(R.id.sub_linear_layout);

        numbersIcon = (LinearLayout)findViewById(R.id.numbers_icon);
        countIcon = (LinearLayout)findViewById(R.id.count_icon);
        addIcon = (LinearLayout)findViewById(R.id.add_icon);
        subIcon = (LinearLayout)findViewById(R.id.sub_icon);
    }
    public void numbersPart(View v) {
        numbersLinearLayout.setVisibility(View.VISIBLE);
        numbersIcon.setVisibility(View.INVISIBLE);

        countLinearLayout.setVisibility(View.INVISIBLE);
        countIcon.setVisibility(View.VISIBLE);
        addLinearLayout.setVisibility(View.INVISIBLE);
        addIcon.setVisibility(View.VISIBLE);
        subLinearLayout.setVisibility(View.INVISIBLE);
        subIcon.setVisibility(View.VISIBLE);
    }

    public void countingPart(View v) {
        countLinearLayout.setVisibility(View.VISIBLE);
        countIcon.setVisibility(View.INVISIBLE);

        numbersLinearLayout.setVisibility(View.INVISIBLE);
        numbersIcon.setVisibility(View.VISIBLE);
        addLinearLayout.setVisibility(View.INVISIBLE);
        addIcon.setVisibility(View.VISIBLE);
        subLinearLayout.setVisibility(View.INVISIBLE);
        subIcon.setVisibility(View.VISIBLE);
    }

    public void additionPart(View v) {
        addLinearLayout.setVisibility(View.VISIBLE);
        addIcon.setVisibility(View.INVISIBLE);

        numbersLinearLayout.setVisibility(View.INVISIBLE);
        numbersIcon.setVisibility(View.VISIBLE);
        countLinearLayout.setVisibility(View.INVISIBLE);
        countIcon.setVisibility(View.VISIBLE);
        subLinearLayout.setVisibility(View.INVISIBLE);
        subIcon.setVisibility(View.VISIBLE);
    }

    public void subtractionPart(View v) {
        subLinearLayout.setVisibility(View.VISIBLE);
        subIcon.setVisibility(View.INVISIBLE);

        numbersLinearLayout.setVisibility(View.INVISIBLE);
        numbersIcon.setVisibility(View.VISIBLE);
        countLinearLayout.setVisibility(View.INVISIBLE);
        countIcon.setVisibility(View.VISIBLE);
        addLinearLayout.setVisibility(View.INVISIBLE);
        addIcon.setVisibility(View.VISIBLE);
    }

    public void numbersClass(View v) {
        Intent intent = new Intent(this,DisplayNumbers.class);
        startActivity(intent);
    }

    public void writeNumberClass(View v) {
        Intent intent = new Intent(this,Numbers.class);
        startActivity(intent);
    }

    public void foxClass(View v) {
        Intent intent = new Intent(this,FoxHouse.class);
        startActivity(intent);
    }

    public void kiteClass(View v) {
        Intent intent = new Intent(this,SkyKite.class);
        startActivity(intent);
    }

    public void fishAddClass(View v) {
        Intent intent = new Intent(this,FishAddition.class);
        startActivity(intent);
    }

    public void birdAddClass(View v) {
        Intent intent = new Intent(this,BirdAddition.class);
        startActivity(intent);
    }

    public void ballonAddClass(View v) {
        Intent intent = new Intent(this,BallonAddition.class);
        startActivity(intent);
    }

    public void fishSubClass(View v) {
        Intent intent = new Intent(this,FishSubtraction.class);
        startActivity(intent);
    }

    public void birdSubClass(View v) {
        Intent intent = new Intent(this,BirdSubtraction.class);
        startActivity(intent);
    }

    public void ballonSubClass(View v) {
        Intent intent = new Intent(this,BallonSubtraction.class);
        startActivity(intent);
    }
}
