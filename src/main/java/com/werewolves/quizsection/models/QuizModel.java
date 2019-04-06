package com.werewolves.quizsection.models;
import com.werewolves.quizsection.entities.Quiz;

public abstract class QuizModel extends Model {
    public abstract int add(Quiz quiz);
}