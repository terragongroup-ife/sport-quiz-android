package com.example.sportyquiz.categoryPage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sportyquiz.MainActivity;
import com.example.sportyquiz.R;

public class CategoryActivity extends AppCompatActivity {

    private Button footballButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        footballButton = findViewById(R.id.football_button);

        footballButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
