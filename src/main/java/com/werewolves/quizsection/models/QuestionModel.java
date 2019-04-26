package com.werewolves.quizsection.models;

import com.werewolves.quizsection.entities.Question;

import java.util.Collection;

public abstract class QuestionModel extends Model {

    public abstract Collection<Question> getAllQuestions(int quizId);

    public abstract Question getQuestionByID(int quizId, int id);

    public abstract boolean updateQuestionByID(int quizId, Question question);

    public abstract boolean deleteQuestionByID(int quizId, int id);

    public abstract Question addQuestion(int quizId, Question question);
}
