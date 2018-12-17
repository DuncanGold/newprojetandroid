package com.example.duncan.testappli;


import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import java.util.Random;

public class ShakeActivity extends AppCompatActivity {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;
    private ImageView img;
    private TextView tvShake;
    //private Chronometer mChronometer;

    long tStart;
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), StartActivity.class));
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        tStart = System.currentTimeMillis();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        img=(ImageView) findViewById(R.id.shakerimg);
        img.setX(20);
        img.setY(50);
        final Toast toast = Toast.makeText(ShakeActivity.this, "Encore !", Toast.LENGTH_SHORT);
        tvShake = findViewById(R.id.tvShake);


        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
                /*
                 * The following method, "handleShakeEvent(count):" is a stub //
                 * method you would use to setup whatever you want done once the
                 * device has been shook.
                 */
              //  mChronometer.start();
                toast.show();
                int haut = 0;
                if (img.getY()>500) haut = -250;
                else {haut=250;}


                ObjectAnimator.ofFloat(img,"translationY",0,haut).setDuration(50).start();
            handleShakeEvent(count);
            }

            public void handleShakeEvent(int count){
                if (count >= 20){

                    //int elapsedMillis = (int) (SystemClock.elapsedRealtime() - mChronometer.getBase());

                    long tEnd = System.currentTimeMillis();
                    long tDelta = tEnd - tStart;
                    double elapsedMillis = tDelta / 1000.0;
                    toast.cancel();

                    if (getIntent().getIntExtra("minigame", 0) == 1) {
                        Intent appel = new Intent(getApplicationContext(), ResultActivity.class);
                        appel.putExtra("resultatshake", (double) (10 - elapsedMillis));
                        appel.putExtra("typescore", 2);
                        appel.putExtra("minigame", 1);
                        startActivity(appel);
                    }
                    else{
                        Intent appel = new Intent(getApplicationContext(), ResultActivity.class);
                        appel.putExtra("resultatshake", (double) (10 - elapsedMillis));
                        appel.putExtra("typescore", 2);
                        appel.putExtra("minigame", 0);
                        startActivity(appel);
                    }

                }
            }
        });

    }
    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }
}