package com.werewolves.quizsection.models;


import com.werewolves.quizsection.entities.Question;

import java.util.Collection;

public interface QuestionModel {

    Collection<Question> getAllQuestions();

    Question getQuestionByID(int id);

    Question updateQuestionByID(Question question);

    Question deleteQuestionByID(int id);

    Question insertQuestion(Question question);
}
