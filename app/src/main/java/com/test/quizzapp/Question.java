package com.test.quizzapp;

public class Question {
    private int questionId;
    private boolean ResId;

    public Question(int questionId, boolean resId) {
        this.questionId = questionId;
        ResId = resId;
    }


    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public boolean isResId() {
        return ResId;
    }

    public void setResId(boolean resId) {
        ResId = resId;
    }
}
