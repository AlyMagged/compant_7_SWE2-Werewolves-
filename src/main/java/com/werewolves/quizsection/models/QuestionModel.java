package com.werewolves.quizsection.models;

import com.werewolves.quizsection.entities.Question;

import java.util.Collection;

public abstract class QuestionModel extends Model {
    public abstract int add(Question question);

    public abstract Collection<Question> getAllQuestions(int quizId);

    public abstract Question getQuestionByID(int quizId, int id);

    public abstract Question updateQuestionByID(int quizId, Question question);

    public abstract Question deleteQuestionByID(int quizId, int id);

    public abstract Question insertQuestion(int quizId, Question question);
}
