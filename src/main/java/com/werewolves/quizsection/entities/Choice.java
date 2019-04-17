package com.werewolves.quizsection.entities;

public class Choice
{
    private int id;
    private String title;
    private Question question;
    private Quiz quiz;

    public Choice(){
        quiz = new Quiz();
        question = new Question();
    }

    public Choice(int id) {
        this();
        this.id = id;
    }

    public Choice(String title) {
        this();
        this.title = title;
    }

    public Choice(int id, String title) {
        this();
        this.id = id;
        this.title = title;
    }

    public Choice(int id, String title , int questionId , int quizId) {
        this();
        this.id = id;
        this.title = title;
        this.question.setId(questionId);
        this.quiz.setId(quizId);
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

    public int getQuestionID() {
        return question.getId();
    }

    public int getQuizID() {
        return this.quiz.getId();
    }

    public void setQuestionId(int id) {
        this.question.setId(id);
    }

    public void setQuizId(int id) {
        this.quiz.setId(id);
    }

}
