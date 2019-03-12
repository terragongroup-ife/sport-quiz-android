package com.example.sportyquiz;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sportyquiz.model.RandomQuestion;
import com.example.sportyquiz.resultPage.ResultActivity;
import com.example.sportyquiz.viewmodels.RandomQuestionApiViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView questionTextView;
    private Button optionAButton, optionBButton, optionCButton, optionDButton;
    private Observer<List<RandomQuestion>> apiQuestionObserver;
    private RandomQuestionApiViewModel randomQuestionApiViewModel;
    private ArrayList<RandomQuestion> allQuestions;
    private int count, score;
    public static final String TAG = MainActivity.class.getSimpleName();
    private String question, answer, optionA, optionB, optionC, optionD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTextView = findViewById(R.id.questionTextView);
        optionAButton = findViewById(R.id.optionA);
        optionBButton = findViewById(R.id.optionB);
        optionCButton = findViewById(R.id.optionC);
        optionDButton = findViewById(R.id.optionD);
        randomQuestionApiViewModel = ViewModelProviders.of(this).get(RandomQuestionApiViewModel.class);
        randomQuestionApiViewModel.init();
        allQuestions = new ArrayList<>();
        apiQuestionObserver = new Observer<List<RandomQuestion>>() {
            @Override
            public void onChanged(@Nullable List<RandomQuestion> randomQuestions) {
                if (randomQuestions != null) {
                    allQuestions = (ArrayList<RandomQuestion>) randomQuestions;
                    count = 0;
                    setUI();
                }else{
                    Toast.makeText(MainActivity.this, "Check your network", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        };
        getQuestions();
        getNextQuestion(optionAButton);
        getNextQuestion(optionBButton);
        getNextQuestion(optionCButton);
        getNextQuestion(optionDButton);
    }

    public void getQuestions() {
        randomQuestionApiViewModel.getQuestions().observe(MainActivity.this, apiQuestionObserver);
    }


    public void getNextQuestion(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if (count <allQuestions.size()){
                    isCorrect(button);
                    setUI();
                }else{
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(intent);
                }


            }
        });
    }

    public int isCorrect(Button button) {
        String usersSelectedAnswer = button.getText().toString().trim();
        if (usersSelectedAnswer.equals(answer)) {
            score++;
        }
        return score;
    }

    public void setUI(){

        questionTextView.setText( allQuestions.get(count).getAnswer());
        answer = allQuestions.get(count).getAnswer();
        score = 0;

        ArrayList<String> options = (ArrayList<String>) allQuestions.get(count).getAnswerOptions();
        Log.i(TAG, "they are " + options.toString());


        optionA = options.get(0);
        optionAButton.setText(optionA);

        optionB = options.get(1);
        optionBButton.setText(optionB);

        optionC = options.get(2);
        optionCButton.setText(optionC);

        optionD = options.get(3);
        optionDButton.setText(optionD);

    }


}
