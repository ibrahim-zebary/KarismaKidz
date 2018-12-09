package com.example.ibrahim.basicmathforkidsnexus10lastupdate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void mainPart(View view) {
        Intent intent = new Intent(this,MainDesign.class);
        startActivity(intent);
    }
    public void aboutUsPart(View view) {
        Toast.makeText(this,"Nothing to show",Toast.LENGTH_SHORT).show();
        /*Intent intent = new Intent(this,AboutUs.class);
        startActivity(intent);*/
    }
}
