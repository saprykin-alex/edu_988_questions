package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button yesBtn;
    Button noBtn;
    Button showAnswer;
    TextView questionTextView;
    static int questionIndex=0;
    Question[] questions = {
            new Question(R.string.question1, true),
            new Question(R.string.question2, true),
            new Question(R.string.question3, false),
            new Question(R.string.question4, false),
            new Question(R.string.question5, false),
            new Question(R.string.question6, true),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if(savedInstanceState!=null){
//            questionIndex = savedInstanceState.getInt("questionIndex");
//        }
        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);
        questionTextView = findViewById(R.id.questiontextView);
        showAnswer = findViewById(R.id.showAnswer);
        questionTextView.setText(questions[questionIndex].getQuestionText());

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questions[questionIndex].isAnswerTrue())
                    Toast.makeText(MainActivity.this, "Правильно!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Не правильно!", Toast.LENGTH_SHORT).show();
                questionIndex = (questionIndex+1)%questions.length;
                questionTextView.setText(questions[questionIndex].getQuestionText());
            }
        });


        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questions[questionIndex].isAnswerTrue())
                    Toast.makeText(MainActivity.this, "Не правильно!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Правильно!", Toast.LENGTH_SHORT).show();

                questionIndex = (questionIndex+1)%questions.length;
                questionTextView.setText(questions[questionIndex].getQuestionText());

            }
        });
        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer", questions[questionIndex].isAnswerTrue());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("SYSTEM INFO:", "Вызван метод onStart()");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d("SYSTEM INFO:", "Вызван метод onResume()");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d("SYSTEM INFO:", "Вызван метод onPause()");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d("SYSTEM INFO:", "Вызван метод onStop()");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("SYSTEM INFO:", "Вызван метод onDestroy()");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.d("SYSTEM INFO:", "Вызван метод onSaveInstanceState()");
        savedInstanceState.putInt("questionIndex", questionIndex);
    }

}