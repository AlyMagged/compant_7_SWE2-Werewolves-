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
    @Qualifier("MySQLChoiceModel")
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

    public boolean updateChoiceByID(int quizId, int questionId, Choice choice) {
        if(choiceModel.updateChoice(quizId , questionId , choice)) {
            return true;
        }
        return false;
    }

    public boolean deleteChoiceByID(int quizId, int questionId, int id) {
        if(choiceModel.deleteChoiceByID(quizId , questionId ,id)) {
            return true;
        }
        return false;
    }

    public Choice addChoice(int quizId, int questionId, Choice choice) {
        Choice newChoice = choiceModel.addChoice(quizId , questionId ,choice);
        if(newChoice == null){
            /** will be modified **/
            return null;
        }
        return newChoice;
    }
}
