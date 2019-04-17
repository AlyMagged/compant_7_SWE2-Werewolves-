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

    public Collection<Question> getAllQuestions(int quizId) {
        Collection<Question> questions = this.questionModel.getAllQuestions(quizId);
        return questions;
    }

    public Question getQuestionByID(int quizId, int id) {
        Question question = this.questionModel.getQuestionByID(quizId ,id);
        if(question == null){
            /** will be modified **/
            return null;
        }else{
            return question;
        }
    }

    public Question insertQuestion(int quizId, Question question) {
        Question NewQuestion = this.questionModel.insertQuestion(quizId ,question);
        if(question == null){
            /** will be modified **/
            return null;
        }
        return NewQuestion;
    }

    public Question updateQuestionByID(int quizId, Question question) {
        Question updatedQuestion = this.questionModel.updateQuestionByID(quizId ,question);
        /** will be some validation about the updateChoice value **/
        if(updatedQuestion == null){
            /** will be modified **/
            return null;
        }
        return updatedQuestion;
    }

    public void deleteQuestionByID(int quizId, int id) {
        Question question = this.questionModel.deleteQuestionByID(quizId ,id);
        if(question == null){
            /** will be modified **/
        }
    }
}
