package com.werewolves.quizsection.models;


import com.werewolves.quizsection.entities.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeQuestionModel")
public class FakeQuestionModel extends QuestionModel {

    private static Map<Integer , Question> questions;

    static {
        questions = new HashMap<Integer, Question>(){
            {
                put(1 , new Question(1 , "What?" , 1));
                put(2 , new Question(2 , "Where?",1));
                put(3 , new Question(3 , "How?" , 2));
                put(4 , new Question(4 , "Who?" , 3));
            }
        };
    }


    @Override
    public int add(Question question) {
        return 0;
    }

    @Override
    public Collection<Question> getAllQuestions(int quizId) {
        Collection<Question> temp = new ArrayList<>();
        for(Integer key : questions.keySet()){
            Question value = questions.get(key);
            if(value.getQuizId() == quizId){
                temp.add(value);
            }
        }
        return temp;
    }

    @Override
    public Question getQuestionByID(int quizId, int id) {
        for(Integer key : questions.keySet()){
            Question value = questions.get(key);
            if(value.getQuizId() == quizId && key == id){
                return value;
            }
        }
        return null;
    }

    @Override
    public Question insertQuestion(int quizId, Question question) {
        question.setQuizId(quizId);
        questions.put(question.getId() , question);
        Question newQ = this.questions.get(question.getId());
        return newQ;
    }

    @Override
    public Question deleteQuestionByID(int quizId, int id) {
        Question temp = null;
        for(Integer key : questions.keySet()){
            Question value = questions.get(key);
            if(key == id && value.getQuizId() == quizId){
                temp = value;
                questions.remove(key);
                break;
            }
        }
        return temp;
    }

    @Override
    public Question updateQuestionByID(int quizId, Question newQuestion) {
        Question old = questions.get(newQuestion.getId());
        old.setCorrectChoiceID(newQuestion.getCorrectChoiceID());
        old.setChoices(newQuestion.getChoices());
        old.setTitle(newQuestion.getTitle());
        old.setQuizId(quizId);

        this.questions.put(old.getId() , old);
        return old;
    }


}
