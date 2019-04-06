package com.werewolves.quizsection.models;


import com.werewolves.quizsection.entities.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeQuestionModel")
public class FakeQuestionModel implements QuestionModel {

    private static Map<Integer , Question> questions;

    static {
        questions = new HashMap<Integer, Question>(){
            {
                put(1 , new Question(1 , "What?"));
                put(2 , new Question(2 , "Where?"));
                put(3 , new Question(3 , "How?"));
                put(4 , new Question(4 , "Who?"));
            }
        };
    }


    @Override
    public Collection<Question> getAllQuestions() {
        return questions.values();
    }

    @Override
    public Question getQuestionByID(int id) {
        return questions.get(id);
    }

    @Override
    public Question updateQuestionByID(Question newQuestion) {
        Question old = questions.get(newQuestion.getId());
        old.setCorrectChoiceID(newQuestion.getCorrectChoiceID());
        old.setChoices(newQuestion.getChoices());
        old.setTitle(newQuestion.getTitle());

        this.questions.put(old.getId() , old);
        return old;
    }

    @Override
    public Question deleteQuestionByID(int id) {
        Question deleted = this.questions.get(id);
        this.questions.remove(id);
        return deleted;
    }

    @Override
    public Question insertQuestion(Question question) {
        this.questions.put(question.getId() , question);
        Question newQ = this.questions.get(question.getId());
        return newQ;
    }
}
