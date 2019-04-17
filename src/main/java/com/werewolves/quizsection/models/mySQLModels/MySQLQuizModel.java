package com.werewolves.quizsection.models.mySQLModels;

import com.werewolves.quizsection.entities.Quiz;
import com.werewolves.quizsection.entities.Skill;
import com.werewolves.quizsection.models.QuizModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("MySQLQuizModel")
public class MySQLQuizModel extends QuizModel {
    private static Map<Integer , Quiz> quizzes;
    private static int counter = 5;
    static {
        quizzes = new HashMap<Integer, Quiz>(){
            {
                put(1 , new Quiz(1,2,"Quiz 1", 50, new Skill(1) ));
                put(2 , new Quiz(2,2,"Quiz 2", 10, new Skill(1) ));
                put(3 , new Quiz(3,2,"Quiz 3", 13, new Skill(1) ));
                put(4 , new Quiz(4,2,"Quiz 4", 14, new Skill(1) ));
            }
        };
    }

    @Override
    public Collection<Quiz> getAllQuizzes() {
        Collection<Quiz> quizzes = new ArrayList<>();
        for (Quiz quiz : this.quizzes.values()) {
            quizzes.add(quiz);
        }
        return quizzes;
    }

    @Override
    public Quiz getQuizByID(int id) {
        return quizzes.get(id);
    }

    @Override
    public int addQuiz(Quiz quiz) {
        quiz.setId(counter++);
        this.quizzes.put(quiz.getId() , quiz);
        return quiz.getId();
    }

    @Override
    public Boolean updateQuiz(Quiz quiz) {
        if(!this.quizzes.containsKey(quiz.getId()))
            return false;
        this.quizzes.put(quiz.getId(),quiz);
        return true;
    }

    @Override
    public Boolean deleteQuiz(int quizId) {
        if(!this.quizzes.containsKey(quizId))
            return false;
        this.quizzes.remove(quizId);
        return true;
    }
}
