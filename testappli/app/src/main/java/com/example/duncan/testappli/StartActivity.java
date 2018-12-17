package com.example.duncan.testappli;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StartActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.optionsmenu);
        SharedPreferences settings = getSharedPreferences("testappli", Context.MODE_PRIVATE);
        int totalScore = settings.getInt("totalScore", 0);
        int isMinijeu = 0;
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("totalScore", 0);
        editor.commit();

    }


    @Override
    public void onBackPressed() {
        setContentView(R.layout.optionsmenu);
    }

    public void startQuiz(View view) {

        int quizCategory = 1;
        // on determine la difficulté du jeu
        switch (view.getId()) {
            case R.id.btnsimple:
                quizCategory = 1;
                Intent appel = new Intent(getApplicationContext(), MainActivity.class);
                appel.putExtra("minigame", 0);
                appel.putExtra("quizcategory", quizCategory);
                startActivity(appel);
                break;
            case R.id.btnintermediate:
                quizCategory = 2;
                Intent appel0 = new Intent(getApplicationContext(), WifiDirect.class);
                //appel0.putExtra("quizcategory", quizCategory);
                startActivity(appel0);
                break;
            case R.id.btnhard:
                quizCategory = 3;

                setContentView(R.layout.minijeumenu);
                break;

        }
    }

    public void chooseGame(View view) {

        // on determine la difficulté du jeu
        switch (view.getId()) {
            case R.id.btnsimple6:

                Intent appel = new Intent(getApplicationContext(), MainActivity.class);
                appel.putExtra("minigame", 1);
                startActivity(appel);
                break;
            case R.id.btnsimple7:

                Intent appel1 = new Intent(getApplicationContext(), SlideActivity.class);
                appel1.putExtra("minigame", 1);
                startActivity(appel1);
                break;
            case R.id.btnsimple8:

                Intent appel2 = new Intent(getApplicationContext(), ShakeActivity.class);
                appel2.putExtra("minigame", 1);
                startActivity(appel2);
                break;
            case R.id.btnsimple9:

                Intent appel3 = new Intent(getApplicationContext(), FoodActivity.class);
                appel3.putExtra("minigame", 1);
                startActivity(appel3);
                break;

            case R.id.btnsimple10:

                Intent appel4 = new Intent(getApplicationContext(), PressActivity.class);
                appel4.putExtra("minigame", 1);
                startActivity(appel4);
                break;

        }

    }
}



