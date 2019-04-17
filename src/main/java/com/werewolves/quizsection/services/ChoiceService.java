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

    public Collection<Choice> getAllChoices(int quizId, int questionId) {
        Collection<Choice> choices = choiceModel.getAllChoices(quizId , questionId);
        return choices;
    }

    public Choice getChoiceByID(int quizId, int questionId, int id) {
        Choice choice = choiceModel.getChoiceByID(quizId , questionId , id);
        if(choice == null){
            /** will be modified **/
            return null;
        }else{
            return choice;
        }
    }

    public Choice updateChoiceByID(int quizId, int questionId, Choice choice) {
        Choice updatedChoice = choiceModel.updateChoiceByID(quizId , questionId , choice);
        /** will be some validation about the updateChoice value **/
        if(choice == null){
            /** will be modified **/
            return null;
        }else{
            return updatedChoice;
        }
    }

    public void deleteChoiceByID(int quizId, int questionId, int id) {
        Choice choice = choiceModel.deleteChoiceByID(quizId , questionId ,id);
        if(choice == null){
            /** will be modified **/
        }
    }

    public Choice insertChoice(int quizId, int questionId, Choice choice) {
        Choice newChoice = choiceModel.insertChoice(quizId , questionId ,choice);
        if(newChoice == null){
            /** will be modified **/
            return null;
        }
        return newChoice;
    }
}
