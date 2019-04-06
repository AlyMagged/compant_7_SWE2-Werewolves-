package com.werewolves.quizsection.entities;

import java.util.Collection;

public class Submission {
    private int id;
    private int score;
    private int userId;
    private String submitTime;
    private Collection<Quiz> quizzes;

    public Submission(int id) {
        this.id = id;
    }

    public Submission(int score, int userId) {
        this.score = score;
        this.userId = userId;
    }

    public Submission(int id, int score, int userId) {
        this.id = id;
        this.score = score;
        this.userId = userId;
    }

    public Submission(int score, int userId, String submitTime) {
        this.score = score;
        this.userId = userId;
        this.submitTime = submitTime;
    }

    public Submission(int id, int score, int userId, String submitTime) {
        this.id = id;
        this.score = score;
        this.userId = userId;
        this.submitTime = submitTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public Collection<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Collection<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
}
