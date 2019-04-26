package com.werewolves.quizsection.models;

import com.werewolves.quizsection.entities.Question;

import java.util.Collection;

public abstract class QuestionModel extends Model {

    public abstract Collection<Question> getAllQuestions(int quizId);

    public abstract Question getQuestionByID(int id);

    public abstract boolean updateQuestionByID(Question question);

    public abstract boolean deleteQuestionByID(int id);

    public abstract int addQuestion(Question question);
}
