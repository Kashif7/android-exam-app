package com.example.kashif.examapp.data.model;

/**
 * Created by mininduwiorchana on 3/30/18.
 */

public class Question {

    private String id;
    private String questionText;
    private String answerOptionOne;
    private String answerOptionTwo;
    private String answerOptionThree;
    private String answerOptionFour;
    private int correctAnswer;
    private int usersAnswer;


    public Question() {
    }

    public Question(String id, String questionText, String answerOptionOne, String answerOptionTwo,
                    String answerOptionThree, String answerOptionFour, int correctAnswer, int usersAnswer) {
        this.id = id;
        this.questionText = questionText;
        this.answerOptionOne = answerOptionOne;
        this.answerOptionTwo = answerOptionTwo;
        this.answerOptionThree = answerOptionThree;
        this.answerOptionFour = answerOptionFour;
        this.correctAnswer = correctAnswer;
        this.usersAnswer = usersAnswer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswerOptionOne() {
        return answerOptionOne;
    }

    public void setAnswerOptionOne(String answerOptionOne) {
        this.answerOptionOne = answerOptionOne;
    }

    public String getAnswerOptionTwo() {
        return answerOptionTwo;
    }

    public void setAnswerOptionTwo(String answerOptionTwo) {
        this.answerOptionTwo = answerOptionTwo;
    }

    public String getAnswerOptionThree() {
        return answerOptionThree;
    }

    public void setAnswerOptionThree(String answerOptionThree) {
        this.answerOptionThree = answerOptionThree;
    }

    public String getAnswerOptionFour() {
        return answerOptionFour;
    }

    public void setAnswerOptionFour(String answerOptionFour) {
        this.answerOptionFour = answerOptionFour;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getUsersAnswer() {
        return usersAnswer;
    }

    public void setUsersAnswer(int usersAnswer) {
        this.usersAnswer = usersAnswer;
    }
}
