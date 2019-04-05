package com.werewolves.quizsection.models;

import com.werewolves.quizsection.entities.Choice;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeChoiceModel")
public class FakeChoiceModel implements ChoiceModel {
    private static Map<Integer , Choice> choices;

    static {
        choices = new HashMap<Integer, Choice>(){
            {
                put(1 , new Choice(1 , "Muhammed"));
                put(2 , new Choice(2 , "Shrief"));
                put(3 , new Choice(3 , "Ali"));
                put(4 , new Choice(4 , "werewolves"));
            }
        };
    }

    @Override
    public Collection<Choice> getAllChoices() {
        return this.choices.values();
    }

    @Override
    public Choice getChoiceByID(int id) {
        return this.choices.get(id);
    }

    @Override
    public Choice updateChoiceByID(Choice newChoice) {
        Choice old = choices.get(newChoice.getId());
        old.setTitle(newChoice.getTitle());
        choices.put(old.getId(), old);
        return old;
    }

    @Override
    public Choice deleteChoiceByID(int id) {
        return this.choices.remove(id);
    }

    @Override
    public Choice insertChoice(Choice choice) {
        this.choices.put(choice.getId() , choice);
        return choices.get(choice.getId());
    }
}
