package com.werewolves.quizsection.models;

import com.werewolves.quizsection.entities.Question;

import java.util.Collection;

public abstract class QuestionModel extends Model {
    public abstract int add(Question question);

    public abstract Collection<Question> getAllQuestions();

    public abstract Question getQuestionByID(int id);

    public abstract Question updateQuestionByID(com.werewolves.quizsection.entities.Question question);

    public abstract Question deleteQuestionByID(int id);

    public abstract Question insertQuestion(com.werewolves.quizsection.entities.Question question);
}
