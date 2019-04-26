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
    @Qualifier("MySQLQuestionModel")
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
        Question NewQuestion = this.questionModel.addQuestion(quizId ,question);
        if(question == null){
            /** will be modified **/
            return null;
        }
        return NewQuestion;
    }

    public boolean updateQuestionByID(int quizId, Question question) {
        if(this.questionModel.updateQuestionByID(quizId ,question)) {
            return true;
        }
        return false;
    }

    public boolean deleteQuestionByID(int quizId, int id) {
        if(this.questionModel.deleteQuestionByID(quizId ,id)) {
            return true;
        }
        return false;
    }
}
