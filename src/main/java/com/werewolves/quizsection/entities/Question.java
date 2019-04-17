package com.werewolves.quizsection.entities;

import java.util.Collection;

public class Question {
    private int id;
    private String title;
    private Collection<Choice> choices;
    private int correctChoiceID;
    private Quiz quiz;

    public Question() {
        quiz = new Quiz();
    }

    public Question(int id) {
        this();
        this.id = id;
    }


    public Question(int id, String title) {
        this();
        this.id = id;
        this.title = title;
    }

    public Question(int id, String title , int quizId) {
        this();
        this.id = id;
        this.title = title;
        this.quiz.setId(quizId);
    }


    public Question(String title) {
        this();
        this.title = title;
    }

    public Question(int id, String title, Collection<Choice> choices, int correctChoiceID) {
        this();
        this.id = id;
        this.title = title;
        this.choices = choices;
        this.correctChoiceID = correctChoiceID;
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

    public Collection<Choice> getChoices() {
        return choices;
    }

    public void setChoices(Collection<Choice> choices) {
        this.choices = choices;
    }

    public int getCorrectChoiceID() {
        return correctChoiceID;
    }

    public void setCorrectChoiceID(int correctChoiceID) {
        this.correctChoiceID = correctChoiceID;
    }

    public boolean addChoice(Choice choice){
        return this.choices.add(choice);
    }

    public boolean updateChoice(Choice newChoice){
        for (Choice c : this.choices) {
            if(c.getId() == newChoice.getId()){
                c = newChoice;
                return true;
            }
        }
        return false;
    }

    public boolean deleteChoice(int id){
        for (Choice c : this.choices) {
            if(c.getId() == id){
                this.choices.remove(c);
                return true;
            }
        }
        return false;
    }

    public int getQuizId() {
        return quiz.getId();
    }

    public void setQuizId(int id) {
        this.quiz.setId(id);
    }
}
