package com.werewolves.quizsection.models.mySQLModels;

import com.werewolves.quizsection.entities.Quiz;
import com.werewolves.quizsection.models.QuizModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Qualifier("MySQLQuizModel")
public class MySQLQuizModel extends QuizModel {

    private String tableName = "quizes" ;

    @Override
    public int insertQuize(Quiz quiz) {
        MySQLConnector.openConnection() ;

        String q = "INSERT INTO "+tableName+" VALUES ('"+quiz.getId()+","+quiz.getCreatorId()+", "+ quiz.getTitle()
            +" , "+quiz.getPassScore()+", "+quiz.getSkill()+" ,"+quiz.getSubmissions()+" ,  "+quiz.getQuestions()+"');";
        if(MySQLConnector.executeUpdate(q))
        {
            return MySQLConnector.getIdOfTheLastAddedIn(tableName);
        }
        else
        {
            return 0;
        }
    }
}
