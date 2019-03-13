package com.example.sportyquiz.resultPage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sportyquiz.R;
import com.example.sportyquiz.startPage.StartActivity;

public class ResultActivity extends AppCompatActivity {
    private Button nextButton;
    private TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        scoreTextView = findViewById(R.id.score_textView);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);

            }
        });
    }

   // String score =
}
