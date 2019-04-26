package com.werewolves.quizsection.models;

import com.werewolves.quizsection.entities.Choice;
import java.util.Collection;

public abstract class ChoiceModel {

    public abstract Collection<Choice> getAllChoices(int quizId, int questionId);

    public abstract Choice getChoiceByID(int quizId, int questionId, int id);

    public abstract Choice addChoice(int quizId, int questionId, Choice choice);

    public abstract boolean deleteChoiceByID(int quizId, int questionId, int id);

    public abstract boolean updateChoice(int quizId, int questionId, Choice choice);

}
