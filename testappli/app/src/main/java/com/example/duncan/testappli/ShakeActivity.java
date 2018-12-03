package com.example.duncan.testappli;


import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    protected void onCreate(Bundle savedInstanceState) {
        tStart = System.currentTimeMillis();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        img=(ImageView) findViewById(R.id.shakerimg);
        img.setX(20);
        img.setY(50);

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
                Toast.makeText(ShakeActivity.this, "Encore !", Toast.LENGTH_SHORT).show();
                int haut = 0;
                if (img.getY()>500) haut = -300;
                else {haut=300;}


                ObjectAnimator.ofFloat(img,"translationY",0,haut).setDuration(50).start();
            handleShakeEvent(count);
            }

            public void handleShakeEvent(int count){
                if (count >= 10){

                    //int elapsedMillis = (int) (SystemClock.elapsedRealtime() - mChronometer.getBase());

                    long tEnd = System.currentTimeMillis();
                    long tDelta = tEnd - tStart;
                    double elapsedMillis = tDelta / 1000.0;
                    Intent appel = new Intent(getApplicationContext(), ResultActivity.class);
                    appel.putExtra("resultatshake", (double) (10 - elapsedMillis));
                    appel.putExtra("typescore", 2);
                    startActivity(appel);
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