package com.werewolves.quizsection.models;

import com.werewolves.quizsection.entities.Choice;
import java.util.Collection;

public abstract class ChoiceModel {
    public abstract int add(Choice choice);

    public abstract Collection<Choice> getAllChoices();

    public abstract Choice getChoiceByID(int id);

    public abstract Choice updateChoiceByID(Choice choice);

    public abstract Choice deleteChoiceByID(int id);

    public abstract Choice insertChoice(Choice choice);
}
