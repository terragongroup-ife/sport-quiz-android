package com.example.sportyquiz.model;

import java.util.List;

public class RandomQuestion {

    private String questionId;

    private String question;

   private String answer;

   private List<String> answerOptions;

    public RandomQuestion(String questionId, String question, String answer, List<String> answerOptions) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
        this.answerOptions = answerOptions;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<String> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<String> answerOptions) {
        this.answerOptions = answerOptions;
    }
}
