    package com.example.duncan.testappli;

    import android.app.Activity;
    import android.app.AlertDialog;
    import android.app.Dialog;
    import android.content.DialogInterface;
    import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;

    import java.lang.reflect.Array;
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.Random;

    public class MainActivity extends Activity {
        // variables du layout
        private TextView countLabel;
        private TextView questionLabel;
        private Button button1;
        private Button button2;
        private Button button3;
        private Button button4;

        private TextView difficulty;
        private String rightAnswer;
        private int rightAnswerCount =0;
        private int quizCount = 1;
        static final private int QUIZnb = 5;

        ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

        String quizData[][]={
                // Trouvez l'intrus
             //{"Mot ayant un rapport avec 3 reponses", "Bonne reponse", "rep1","rep2","rep3"}
                {"Pomme de terre", "Fraise", "Frite","Vodka","Raclette"},
                {"Oeuf", "Cock", "Plat","Brouillé","Poché"},
                {"Fromage", "Bleu ciel", "Emmental","Gruyere","Gateau"},
                {"Protéine", "Haricot", "Boeuf","Dinde","Lotte"},
                {"Patisserie", "Cappuccino", "Cookie","Cake","Cupcake"},
                {"Viennoiserie", "Tortilla", "Croissant","Pain au chocolat","Torsade suisse"}

        };
        String quizData2[][]={
                // Trouvez l'intrus
                //{"Mot ayant un rapport avec 3 reponses", "Bonne reponse", "rep1","rep2","rep3"}
                {"Pomme de terre", "Intermediate", "Frite","Vodka","Raclette"},
                {"Oeuf", "Cock", "Plat","Brouillé","Poché"},
                {"Fromage", "Bleu ciel", "Emmental","Gruyere","Gateau"},
                {"Protéine", "Haricot", "Boeuf","Dinde","Lotte"},
                {"Patisserie", "Cappuccino", "Cookie","Cake","Cupcake"},
                {"Viennoiserie", "Tortilla", "Croissant","Pain au chocolat","Torsade suisse"}

        };
        String quizData3[][]={
                // Trouvez l'intrus
                //{"Mot ayant un rapport avec 3 reponses", "Bonne reponse", "rep1","rep2","rep3"}
                {"Pomme de terre", "HARD", "Frite","Vodka","Raclette"},
                {"Oeuf", "Cock", "Plat","Brouillé","Poché"},
                {"Fromage", "Bleu ciel", "Emmental","Gruyere","Gateau"},
                {"Protéine", "Haricot", "Boeuf","Dinde","Lotte"},
                {"Patisserie", "Cappuccino", "Cookie","Cake","Cupcake"},
                {"Viennoiserie", "Tortilla", "Croissant","Pain au chocolat","Torsade suisse"}

        };



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            countLabel = (TextView)findViewById(R.id.countLabel);
            questionLabel = (TextView)findViewById(R.id.questionLabel);
            button1= (Button)findViewById(R.id.button1);
            button2= (Button)findViewById(R.id.button2);
            button3= (Button)findViewById(R.id.button3);
            button4= (Button)findViewById(R.id.button4);
            difficulty = (TextView)findViewById(R.id.Difficult);

            //reception de la difficulté de quiz depuis startactivity
            int quizCategory = getIntent().getIntExtra("quizcategory", 1);

            if (quizCategory==2){quizData=quizData2; difficulty.setText("Intermediate");}
            if (quizCategory==3){quizData=quizData3; difficulty.setText("Hard");}
            for (int i=0; i<quizData.length;i++){
                ArrayList<String> tempory = new ArrayList<>();
                //{"Mot ayant un rapport avec 3 reponses", "Bonne reponse", "rep1","rep2","rep3"}
                tempory.add(quizData[i][0]);
                tempory.add(quizData[i][1]);
                tempory.add(quizData[i][2]);
                tempory.add(quizData[i][3]);
                tempory.add(quizData[i][4]);

                quizArray.add(tempory);
            }
                showNextQuiz();
        }

        public void showNextQuiz(){
            //fonction pour mettre a jour la question affichee
            String nbquest = quizCount+"/5";
            countLabel.setText(nbquest);

            //nombre aléatoire pour choisir une question au pif entre 0
            Random random = new Random();
            int randomNum = random.nextInt(quizArray.size());

            //On choisit la question dans la liste de questions
            ArrayList<String> quiz = quizArray.get(randomNum);

            //on met en place la question sur le layout
            questionLabel.setText(quiz.get(0));

            // on stocke la bonne reponse
            rightAnswer = quiz.get(1);

            //on enlève l'énoncé de la question et on melange les choix
            quiz.remove(0);
            Collections.shuffle(quiz);

            //affocjage des reponses
            button1.setText(quiz.get(0));
            button2.setText(quiz.get(1));
            button3.setText(quiz.get(2));
            button4.setText(quiz.get(3));

            //on enleve ce quiz de notre liste de quiz
            quizArray.remove(randomNum);
        }

      public void checkAnswer(View view) {

          //creer un bouton pour la reponse selectionnee
          Button answerBtn = (Button) findViewById(view.getId());
          String btnText = answerBtn.getText().toString();

          String alertTitle;

          if (btnText.equals(rightAnswer)) {
              //correct
              alertTitle = "Bonne réponse !";
              rightAnswerCount++;
          } else {
              // faux
              alertTitle = "Mauvaise réponse !";

          }
          if (quizCount == QUIZnb) {

              if (getIntent().getIntExtra("minigame", 0) == 1) {
                  Intent appel = new Intent(getApplicationContext(), ResultActivity.class);
                  appel.putExtra("rightanswercount", rightAnswerCount);
                  appel.putExtra("typescore", 1);
                  appel.putExtra("minigame", 1);
                  startActivity(appel);
              }
              else {
                  //afficher le résultat
                  Random alea = new Random();
                  Intent appel = new Intent(getApplicationContext(), ResultActivity.class);
                  appel.putExtra("rightanswercount", rightAnswerCount);
                  appel.putExtra("typescore", 1);
                  appel.putExtra("minigame", 0);
                  appel.putExtra("nextGame", alea.nextInt(2));
                  startActivity(appel);
              }

          }
              else
                  {
                      quizCount++;
                      /*
                      answerBtn.setOnClickListener(new View.OnClickListener() {

                          @Override
                          public void onClick(View v) {
                              Intent appel = new Intent(MainActivity.this, ResultActivity.class);
                              appel.putExtra("rightanswercount", rightAnswerCount);
                              startActivity(appel);

                          }
                      });*/showNextQuiz();
                  }
          }
          @Override
          public void onBackPressed() {
                startActivity(new Intent(getApplicationContext(), StartActivity.class));
                finish(); }

    }
