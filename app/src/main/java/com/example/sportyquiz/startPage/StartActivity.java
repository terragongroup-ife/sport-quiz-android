package com.example.sportyquiz.startPage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sportyquiz.R;
import com.example.sportyquiz.categoryPage.CategoryActivity;

public class StartActivity extends AppCompatActivity {

    private Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        signInButton = findViewById(R.id.enter);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (StartActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });
    }
}
