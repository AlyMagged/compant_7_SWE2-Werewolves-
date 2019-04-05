package com.werewolves.quizsection.services;

import com.werewolves.quizsection.entities.Choice;
import com.werewolves.quizsection.models.ChoiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class ChoiceService {
    @Autowired
    @Qualifier("fakeChoiceModel")
    private ChoiceModel choiceModel;

    public Collection<Choice> getAllChoices() {
        Collection<Choice> choices = choiceModel.getAllChoices();
        return choices;
    }

    public Choice getChoiceByID(int id) {
        Choice choice = choiceModel.getChoiceByID(id);
        if(choice == null){
            /** will be modified **/
            return null;
        }else{
            return choice;
        }
    }

    public Choice updateChoiceByID(Choice choice) {
        Choice updatedChoice = choiceModel.updateChoiceByID(choice);
        /** will be some validation about the updateChoice value **/
        if(choice == null){
            /** will be modified **/
            return null;
        }else{
            return choice;
        }
    }

    public void deleteChoiceByID(int id) {
        Choice choice = choiceModel.deleteChoiceByID(id);
        if(choice == null){
            /** will be modified **/
        }
    }

    public Choice insertChoice(Choice choice) {
        Choice Newchoice = choiceModel.insertChoice(choice);
        if(choice == null){
            /** will be modified **/
            return null;
        }
        return Newchoice;
    }
}
