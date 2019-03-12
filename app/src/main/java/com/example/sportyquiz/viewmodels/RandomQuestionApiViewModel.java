package com.example.sportyquiz.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.sportyquiz.MainActivity;
import com.example.sportyquiz.model.Datum;
import com.example.sportyquiz.model.QuestionApiClient;
import com.example.sportyquiz.model.QuestionApiInterface;
import com.example.sportyquiz.model.RandomQuestion;
import com.example.sportyquiz.model.RandomQuestionsResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RandomQuestionApiViewModel extends ViewModel {
    private QuestionApiInterface questionApiInterface;
    public static final String TAG = MainActivity.class.getSimpleName();

    final MutableLiveData<List<RandomQuestion>> questionsResults = new MutableLiveData<>();


    public void init() {
        Retrofit retrofit = QuestionApiClient.getQuestionApiClient();
        questionApiInterface = retrofit.create(QuestionApiInterface.class);
    }

    public RandomQuestionApiViewModel() {

    }


    private Callback<RandomQuestionsResponse> questionCallback = new Callback<RandomQuestionsResponse>() {
        @Override
        public void onResponse(Call<RandomQuestionsResponse> call, Response<RandomQuestionsResponse> response) {
            Log.i(TAG, "the response is" + response.toString());
            if (response.body().getData() != null){

                List<Datum> randomQuestionsResponse = response.body().getData();
                List<RandomQuestion> allQuestions = new ArrayList<>();
                List<String> answerOptions = new ArrayList<>();
                for (int i = 0; i < randomQuestionsResponse.size(); i++) {
                    String questionId = randomQuestionsResponse.get(i).getId();
                    String question = randomQuestionsResponse.get(i).getQuestion();
                    String answer = randomQuestionsResponse.get(i).getAnswer();
                    answerOptions = randomQuestionsResponse.get(i).getOptions();
                    Log.i(TAG, "the options are " + answerOptions.toString());
                    Collections.shuffle(answerOptions);

                    RandomQuestion randomQuestion = new RandomQuestion(questionId, question, answer, answerOptions );
                    Log.i(TAG, "each questions are " + randomQuestion.getAnswerOptions().toString());
                    allQuestions.add(randomQuestion);
                }

                questionsResults.postValue(allQuestions);
            }
            else{
                return;
            }


        }

        @Override
        public void onFailure(Call<RandomQuestionsResponse> call, Throwable t) {
            questionsResults.postValue(null);

        }
    };


    public LiveData<List<RandomQuestion>> getQuestions() {
        Call<RandomQuestionsResponse> call = questionApiInterface.getRandomQuestions();
        call.enqueue(questionCallback);
        return questionsResults;
    }

}
