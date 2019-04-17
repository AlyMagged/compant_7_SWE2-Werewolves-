package com.werewolves.quizsection.entities;

import java.util.Collection;

public class Quiz {
    private int id;
    private int creatorId;
    private String title;
    private int passScore;
    private Skill skill;
    private Collection<Submission> submissions;
    private Collection<Question> questions;

    public Quiz(int id) {
        this.id = id;
    }

    public Quiz(int creatorId, String title, int passScor, Skill skillٍ) {
        this.creatorId = creatorId;
        this.title = title;
        this.passScore = passScore;
        this.skill = skillٍ;
    }

    public Quiz(int id, int creatorId, String title, int passScore, Skill skill) {
        this.id = id;
        this.creatorId = creatorId;
        this.title = title;
        this.passScore = passScore;
        this.skill = skill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPassScore() {
        return passScore;
    }

    public void setPassScore(int passScore) {
        this.passScore = passScore;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Collection<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(Collection<Submission> submissions) {
        this.submissions = submissions;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }
}
