package com.example.sportyquiz.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionApiInterface {

 @GET("random")
 Call<RandomQuestionsResponse> getRandomQuestions();
}
