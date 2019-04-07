package com.werewolves.quizsection.models;

import com.werewolves.quizsection.entities.Choice;
import java.util.Collection;

abstract public class ChoiceModel {

    public abstract Collection<Choice> getAllChoices();

    public abstract Choice getChoiceByID(int id);

    public abstract Choice updateChoiceByID(Choice choice);

    public abstract Choice deleteChoiceByID(int id);

    public abstract int insertChoice(Choice c);
}
