package com.example.duncan.testappli;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class SlideActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureObject;
    Random rand = new Random();
    private int pos;
    private int sens;
    private String userGest;
    private int nbrOcc = 5;
    private int i=0;
    private TextView textView;
    private TextView myText;
    private TextView tv; // textview to display the countdown
    MyCount counter = new MyCount(10000, 1000);


    public void visibleImage(int posImage,int sensImage){
        ImageView myImage;
        switch(posImage){
            case 0 :
                switch(sensImage){
                    case 0 :
                        myImage = (ImageView) findViewById(R.id.flchBasBD);
                        myImage.setVisibility(ImageView.VISIBLE);
                        break;
                    case 1:
                        myImage = (ImageView) findViewById(R.id.flchHautBD);
                        myImage.setVisibility(ImageView.VISIBLE);
                        break;
                    case 2:
                        myImage = (ImageView) findViewById(R.id.flchGaucheBD);
                        myImage.setVisibility(ImageView.VISIBLE);
                        break;
                    case 3:
                        myImage = (ImageView) findViewById(R.id.flchDroiteBD);
                        myImage.setVisibility(ImageView.VISIBLE);
                        break;}
                break;
            case 1 :
                switch(sensImage){
                    case 0 :
                        myImage = (ImageView) findViewById(R.id.flchBasHD);
                        myImage.setVisibility(ImageView.VISIBLE);
                        break;
                    case 1:
                        myImage = (ImageView) findViewById(R.id.flchHautHD);
                        myImage.setVisibility(ImageView.VISIBLE);
                        break;
                    case 2:
                        myImage = (ImageView) findViewById(R.id.flchGaucheHD);
                        myImage.setVisibility(ImageView.VISIBLE);
                        break;
                    case 3:
                        myImage = (ImageView) findViewById(R.id.flchDroiteHD);
                        myImage.setVisibility(ImageView.VISIBLE);
                        break;}
                break;
            case 2 :
                switch(sensImage){
                    case 0 :
                        myImage = (ImageView) findViewById(R.id.flchBasBG);
                        myImage.setVisibility(ImageView.VISIBLE);
                        break;
                    case 1:
                        myImage = (ImageView) findViewById(R.id.flchHautBG);
                        myImage.setVisibility(ImageView.VISIBLE);
                        break;
                    case 2:
                        myImage = (ImageView) findViewById(R.id.flchGaucheBG);
                        myImage.setVisibility(ImageView.VISIBLE);
                        break;
                    case 3:
                        myImage = (ImageView) findViewById(R.id.flchDroiteBG);
                        myImage.setVisibility(ImageView.VISIBLE);
                        break;}
                break;
            case 3 :
                switch(sensImage){
                    case 0 :
                        myImage = (ImageView) findViewById(R.id.flchBasHG);
                        myImage.setVisibility(ImageView.VISIBLE);
                        break;
                    case 1:
                        myImage = (ImageView) findViewById(R.id.flchHautHG);
                        myImage.setVisibility(ImageView.VISIBLE);
                        break;
                    case 2:
                        myImage = (ImageView) findViewById(R.id.flchGaucheHG);
                        myImage.setVisibility(ImageView.VISIBLE);
                        break;
                    case 3:
                        myImage = (ImageView) findViewById(R.id.flchDroiteHG);
                        myImage.setVisibility(ImageView.VISIBLE);
                        break;}
                break;
        }

    }
    public void invisibleImage(int posImage,int sensImage){
        ImageView myImage;
        switch(posImage){
            case 0 :
                switch(sensImage){
                    case 0 :
                        myImage = (ImageView) findViewById(R.id.flchBasBD);
                        myImage.setVisibility(ImageView.INVISIBLE);
                    case 1:
                        myImage = (ImageView) findViewById(R.id.flchHautBD);
                        myImage.setVisibility(ImageView.INVISIBLE);
                        break;
                    case 2:
                        myImage = (ImageView) findViewById(R.id.flchGaucheBD);
                        myImage.setVisibility(ImageView.INVISIBLE);
                        break;
                    case 3:
                        myImage = (ImageView) findViewById(R.id.flchDroiteBD);
                        myImage.setVisibility(ImageView.INVISIBLE);
                        break;}
                break;
            case 1 :
                switch(sensImage){
                    case 0 :
                        myImage = (ImageView) findViewById(R.id.flchBasHD);
                        myImage.setVisibility(ImageView.INVISIBLE);
                        break;
                    case 1:
                        myImage = (ImageView) findViewById(R.id.flchHautHD);
                        myImage.setVisibility(ImageView.INVISIBLE);
                        break;
                    case 2:
                        myImage = (ImageView) findViewById(R.id.flchGaucheHD);
                        myImage.setVisibility(ImageView.INVISIBLE);
                        break;
                    case 3:
                        myImage = (ImageView) findViewById(R.id.flchDroiteHD);
                        myImage.setVisibility(ImageView.INVISIBLE);
                        break;}
                break;
            case 2 :
                switch(sensImage){
                    case 0 :
                        myImage = (ImageView) findViewById(R.id.flchBasBG);
                        myImage.setVisibility(ImageView.INVISIBLE);
                        break;
                    case 1:
                        myImage = (ImageView) findViewById(R.id.flchHautBG);
                        myImage.setVisibility(ImageView.INVISIBLE);
                        break;
                    case 2:
                        myImage = (ImageView) findViewById(R.id.flchGaucheBG);
                        myImage.setVisibility(ImageView.INVISIBLE);
                        break;
                    case 3:
                        myImage = (ImageView) findViewById(R.id.flchDroiteBG);
                        myImage.setVisibility(ImageView.INVISIBLE);
                        break;}
                break;
            case 3 :
                switch(sensImage){
                    case 0 :
                        myImage = (ImageView) findViewById(R.id.flchBasHG);
                        myImage.setVisibility(ImageView.INVISIBLE);
                        break;
                    case 1:
                        myImage = (ImageView) findViewById(R.id.flchHautHG);
                        myImage.setVisibility(ImageView.INVISIBLE);
                        break;
                    case 2:
                        myImage = (ImageView) findViewById(R.id.flchGaucheHG);
                        myImage.setVisibility(ImageView.INVISIBLE);
                        break;
                    case 3:
                        myImage = (ImageView) findViewById(R.id.flchDroiteHG);
                        myImage.setVisibility(ImageView.INVISIBLE);
                        break;}
                break;
        }
    }
    public void visibleImageAlea(){
        pos=rand.nextInt(4);
        sens=rand.nextInt(4);
        visibleImage(pos,sens);
    }
    public String getSens(int sensImage){
        String sens="";
        switch(sensImage){
            case 0 :
                sens= "B";
                break;
            case 1:
                sens= "T";
                break;
            case 2:
                sens= "L";
                break;
            case 3:
                sens= "R";
                break;}
        return sens;
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), StartActivity.class));
        counter.cancel();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_slide);
        gestureObject = new GestureDetectorCompat(this, new LearnGesture());
        i=0;
        myText = findViewById(R.id.myText);
        myText.setText("Score : "+i);
        visibleImageAlea();
        textView = findViewById(R.id.textView);
        tv = findViewById(R.id.tv);
        // 5000 is the starting number (in milliseconds)
        // 1000 is the number to count down each time (in milliseconds)

        counter.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) { //onSwipeRight
                            /////////////////////////////////////////////////////////////////////////////////////
                            userGest ="R";
                            if(userGest==getSens(sens)){
                                i++;
                                invisibleImage(pos,sens);
                                myText.setText("Score actuel  : "+i);
                                visibleImageAlea();
                            }
                            /////////////////////////////////////////////////////////////////////////////:
                        } else {  //onSwipeLeft
                            ///////////////////////////////////////////////////////////////////////////////////////////
                            userGest ="L";
                            if(userGest==getSens(sens)){
                                i++;
                                invisibleImage(pos,sens);
                                myText.setText("Score actuel  : "+i);
                                visibleImageAlea();
                            }
                            ///////////////////////////////////////////////////////////////////////////////////////////
                        }
                        result = true;
                    }
                }
                else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) { //onSwipeBottom
                        ////////////////////////////////////////////////////////////////////////////////////////////////////////:
                        userGest ="B";
                        if(userGest==getSens(sens)){
                            i++;
                            invisibleImage(pos,sens);
                            myText.setText("Score actuel  : "+i);
                            visibleImageAlea();
                        }
                        ////////////////////////////////////////////////////////////////////////////////////////////////////:
                    } else {//onSwipeTop
                        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////::
                        userGest ="T";
                        if(userGest==getSens(sens)){
                            i++;
                            invisibleImage(pos,sens);
                            myText.setText("Score actuel  : "+i);
                            visibleImageAlea();
                        }
                        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////::::
                    }
                    result = true;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }

    public class MyCount extends CountDownTimer {

        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
        //    setContentView(R.layout.activity2_main);
          //  myText=findViewById(R.id.score);
            //myText.setText(""+i);
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
                startActivity(appel);
            }

        }

        @Override
        public void onTick(long millisUntilFinished) {
            tv.setText(""+millisUntilFinished/1000);

        }

    }
}
