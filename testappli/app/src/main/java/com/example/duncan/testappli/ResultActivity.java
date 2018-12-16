package com.example.duncan.testappli;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.transition.Slide;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class ResultActivity extends Activity {
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), StartActivity.class));
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        double score=0;
        TextView textresult = (TextView) findViewById(R.id.textResult);
        TextView scoreTotal = (TextView) findViewById(R.id.scoretotal);
        Button butnxt= (Button)findViewById(R.id.btnNEXT);

        switch (getIntent().getIntExtra("typescore",1)) {
            case 1 : score = getIntent().getIntExtra("rightanswercount",0);
                textresult.setText("Votre score : "+(int)score + " / 5");
                break;
            case 2 : score = getIntent().getDoubleExtra("resultatshake",0);
            textresult.setText("Votre score : " + (int)score);
            break;
            case 3 : score = getIntent().getIntExtra("scoreslide",0);
                textresult.setText("Votre score : " + (int)score);
                butnxt.setText("Play Again");
                break;
        }



            SharedPreferences settings = getSharedPreferences("testappli", Context.MODE_PRIVATE);
            int totalScore = settings.getInt("totalScore",0);
            totalScore += score;


            scoreTotal.setText("Score Total : " + totalScore);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("totalScore", totalScore);
            editor.commit();
    }
public void NextGame(View view){

    switch (getIntent().getIntExtra("typescore",1)) {
        case 1 :
        Intent appel = new Intent(getApplicationContext(), ShakeActivity.class);
        startActivity(appel);
        break;
        case 2 :
            Intent appel1 = new Intent(getApplicationContext(), SlideActivity.class);
            startActivity(appel1);
            break;
        case 3 :
            Intent appel2 = new Intent(getApplicationContext(), StartActivity.class);
            startActivity(appel2);
            break;
    }
}
}