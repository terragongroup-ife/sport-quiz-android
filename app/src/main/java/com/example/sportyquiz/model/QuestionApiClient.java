package com.example.sportyquiz.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionApiClient {
    public static final String BASE_URL = "https://sport-quiz.herokuapp.com";
    public static Retrofit retrofit = null;

    public static Retrofit getQuestionApiClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}