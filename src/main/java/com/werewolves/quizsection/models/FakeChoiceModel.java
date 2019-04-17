package com.werewolves.quizsection.models;

import com.werewolves.quizsection.entities.Choice;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeChoiceModel")
public class FakeChoiceModel extends ChoiceModel {
    private static Map<Integer , Choice> choices;

    static {
        choices = new HashMap<Integer, Choice>(){
            {
                put(1 , new Choice(1 , "Muhammed" , 1 , 1));
                put(2 , new Choice(2 , "Shrief" , 1 , 1));
                put(3 , new Choice(3 , "Ali" , 2, 1));
                put(4 , new Choice(4 , "werewolves" , 2, 2));
            }
        };
    }

    @Override
    public Collection<Choice> getAllChoices(int quizId, int questionId) {
        Collection<Choice> temp = new ArrayList<>();
        for (Integer key : choices.keySet()) {
            Choice value = choices.get(key);

            if(value.getQuestionID() == questionId && value.getQuizID() == quizId){
                temp.add(value);
            }
        }
        return temp;
    }

    @Override
    public Choice getChoiceByID(int quizId, int questionId, int id) {

        for(Integer key : choices.keySet()){
            Choice value = choices.get(key);

            if(value.getQuizID() == quizId && value.getQuestionID() == questionId
                    && value.getId() == id){
                return value;
            }
        }
        return null;
    }

    @Override
    public Choice insertChoice(int quizId, int questionId, Choice choice) {
        choice.setQuizId(quizId);
        choice.setQuestionId(questionId);
        this.choices.put(choice.getId() , choice);
        return choices.get(choice.getId());
    }

    @Override
    public Choice deleteChoiceByID(int quizId, int questionId, int id) {
        Choice temp = null;
        for(Integer key : choices.keySet()){
            Choice value = choices.get(key);

            if(value.getId() == id && value.getQuestionID() == questionId
                && value.getQuizID() == quizId){
                temp = value;
                choices.remove(key);
                break;
            }
        }
        return temp;
    }


    @Override
    public Choice updateChoiceByID(int quizId, int questionId, Choice newChoice) {
        Choice old = choices.get(newChoice.getId());
        old.setTitle(newChoice.getTitle());
        choices.put(old.getId(), old);
        return old;
    }


}
