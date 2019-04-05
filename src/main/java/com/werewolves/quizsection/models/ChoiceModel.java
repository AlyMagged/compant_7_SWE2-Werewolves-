package com.werewolves.quizsection.models;

import com.werewolves.quizsection.entities.Choice;

import java.util.Collection;

public interface ChoiceModel {
    Collection<Choice> getAllChoices();

    Choice getChoiceByID(int id);

    Choice updateChoiceByID(Choice choice);

    Choice deleteChoiceByID(int id);

    Choice insertChoice(Choice choice);
}
