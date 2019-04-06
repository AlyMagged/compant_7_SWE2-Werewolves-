package com.werewolves.quizsection.services;


import com.werewolves.quizsection.entities.Question;
import com.werewolves.quizsection.models.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class QuestionService {
    @Autowired
    @Qualifier("fakeQuestionModel")
    QuestionModel questionModel;

    public Collection<Question> getAllQuestions() {
        Collection<Question> questions = this.questionModel.getAllQuestions();
        return questions;
    }

    public Question getQuestionByID(int id) {
        Question question = this.questionModel.getQuestionByID(id);
        if(question == null){
            /** will be modified **/
            return null;
        }else{
            return question;
        }
    }

    public Question updateQuestionByID(Question question) {
        Question updatedQuestion = this.questionModel.updateQuestionByID(question);
        /** will be some validation about the updateChoice value **/
        if(question == null){
            /** will be modified **/
            return null;
        }else{
            return question;
        }
    }

    public void deleteQuestionByID(int id) {
        Question question = this.questionModel.deleteQuestionByID(id);
        if(question == null){
            /** will be modified **/
        }
    }

    public Question insertQuestion(Question question) {
        Question NewQuestion = this.questionModel.insertQuestion(question);
        if(question == null){
            /** will be modified **/
            return null;
        }
        return NewQuestion;
    }
}
