package com.example.duncan.testappli;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;


public class PressActivity extends Activity {
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), StartActivity.class));
        counter.cancel();
        finish();
    }

    private int i=0;
    private TextView textView;
    private TextView myText;
    private TextView msg;
    private TextView tv; // textview to display the countdown
    MyCount counter = new MyCount(10000, 1000);

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_press);
        i = 0;
        msg = findViewById(R.id.msg);
        myText = findViewById(R.id.myText);
        myText.setText("Score : "+i);
        textView = findViewById(R.id.textView);
        tv = findViewById(R.id.tv);
        ImageButton bouton= (ImageButton)findViewById(R.id.imageButton);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                myText.setText("Score : "+i);
            }
        });
        // 5000 is the starting number (in milliseconds)
        // 1000 is the number to count down each time (in milliseconds)
        counter.start();


    }


    public class MyCount extends CountDownTimer {

        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {

            int scorefinal = i;

            if (getIntent().getIntExtra("minigame", 0) == 1) {
                Intent appel = new Intent(getApplicationContext(), ResultActivity.class);
                appel.putExtra("scoreslide", scorefinal);
                appel.putExtra("typescore", 3);
                appel.putExtra("minigame", 1);
                startActivity(appel);
            }
            else{
                Intent appel = new Intent(getApplicationContext(), ResultActivity.class);
                appel.putExtra("scoreslide", scorefinal);
                appel.putExtra("typescore", 3);
                appel.putExtra("minigame", 0);
                appel.putExtra("nextGame", 1);
                startActivity(appel);
            }

        }

        @Override
        public void onTick(long millisUntilFinished) {
            tv.setText(""+millisUntilFinished/1000);

        }

    }
}
