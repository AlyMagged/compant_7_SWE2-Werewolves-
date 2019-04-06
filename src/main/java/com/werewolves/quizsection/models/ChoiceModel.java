package com.werewolves.quizsection.models;

import com.werewolves.quizsection.entities.Choice;
import java.util.Collection;

public abstract class ChoiceModel {
    public abstract int add(Choice choice);

    abstract Collection<Choice> getAllChoices();

    abstract Choice getChoiceByID(int id);

    abstract Choice updateChoiceByID(Choice choice);

    abstract Choice deleteChoiceByID(int id);

    abstract Choice insertChoice(Choice choice);
}
