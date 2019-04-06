package com.werewolves.quizsection.models;

import com.werewolves.quizsection.entities.Question;

import java.util.Collection;

public abstract class QuestionModel extends Model {
    public abstract int add(Question question);

    abstract Collection<Question> getAllQuestions();

    abstract Question getQuestionByID(int id);

    abstract Question updateQuestionByID(com.werewolves.quizsection.entities.Question question);

    abstract Question deleteQuestionByID(int id);

    abstract Question insertQuestion(com.werewolves.quizsection.entities.Question question);
}
