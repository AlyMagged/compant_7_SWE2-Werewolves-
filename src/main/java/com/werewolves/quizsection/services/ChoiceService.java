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
        Collection<Choice> choices = choiceModel.getAllChoices(questionId);
        return choices;
    }

    public Choice getChoiceByID(int quizId, int questionId, int id) {
        Choice choice = choiceModel.getChoiceByID(id);
        if(choice == null){
            /** will be modified **/
            return null;
        }else{
            return choice;
        }
    }

    public boolean updateChoiceByID(int quizId, int questionId, Choice choice) {
        if(choiceModel.updateChoice(choice)) {
            return true;
        }
        return false;
    }

    public boolean deleteChoiceByID(int quizId, int questionId, int id) {
        if(choiceModel.deleteChoiceByID(id)) {
            return true;
        }
        return false;
    }

    public int addChoice(int quizId, int questionId, Choice choice) {
        return choiceModel.addChoice(questionId ,choice);
    }
}
