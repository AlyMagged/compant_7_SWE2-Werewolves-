package com.werewolves.quizsection.entities;

public class Choice
{
    private int id;
    private String title;
    private int questionID;

    public Choice(){}

    public Choice(int id) {
        this.id = id;
    }

    public Choice(String title) {
        this.title = title;
    }

    public Choice(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Choice(int id, String title, int questionID) {
        this.id = id;
        this.title = title;
        this.questionID = questionID;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuestion() {
        return questionID;
    }

    public void setQuestion(int qId) {
        this.questionID = qId;
    }
}
