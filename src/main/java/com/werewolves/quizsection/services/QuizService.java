package com.werewolves.quizsection.services;

import com.werewolves.quizsection.entities.Quiz;
import com.werewolves.quizsection.models.QuizModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    @Autowired
    @Qualifier("MySQLQuizModel")
    QuizModel quizModel ;

    // will edit
    public Quiz insertQuiz(Quiz quiz)
    {
        int result = this.quizModel.insertQuize(quiz) ;
        if (result != 0 )
        {
            return quiz ;
        }
        else {
            return null;
        }

    }
}
