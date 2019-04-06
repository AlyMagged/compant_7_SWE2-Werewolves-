package com.werewolves.quizsection.entities;

public class Choice {
    private int id;
    private String title;

    public Choice(int id) {
        this.id = id;
    }

    public Choice(int id, String title) {
        this.id = id;
        this.title = title;
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
}
