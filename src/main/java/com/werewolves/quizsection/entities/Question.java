package com.werewolves.quizsection.entities;

import java.util.ArrayList;

public class Question {
    private int id;
    private String title;
    private ArrayList<Choice> choices;
    private int correctChoiceID;

    public Question() {
    }

    public Question(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Question(String title) {
        this.title = title;
    }

    public Question(int id, String title, ArrayList<Choice> choices, int correctChoiceID) {
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

    public ArrayList<Choice> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<Choice> choices) {
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

}
