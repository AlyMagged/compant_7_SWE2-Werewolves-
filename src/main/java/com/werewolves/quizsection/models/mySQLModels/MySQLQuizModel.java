package com.werewolves.quizsection.models.mySQLModels;

import com.werewolves.quizsection.entities.Quiz;
import com.werewolves.quizsection.entities.Skill;
import com.werewolves.quizsection.models.QuizModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("MySQLQuizModel")
public class MySQLQuizModel extends QuizModel {
    private String tableName = "quizes";

    @Override
    public Collection<Quiz> getAllQuizzes() {
        MySQLConnector.openConnection();

        String q = "SELECT * FROM "+this.tableName;

        ResultSet resultSet = MySQLConnector.executeQuery(q);
        Collection<Quiz> quizzes = new ArrayList<>();

        int id, creatorId, skillTypeId, passScore;
        String title;
        float duration;

        try {
            while(resultSet.next())
            {
                id = resultSet.getInt("id");
                creatorId = resultSet.getInt("creator_id");
                skillTypeId = resultSet.getInt("skill_type_id");
                passScore = resultSet.getInt("pass_score");
                title = resultSet.getString("title");
                duration = resultSet.getFloat("duration");
                quizzes.add( new Quiz(id, creatorId, title, passScore, duration, new Skill(skillTypeId)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            MySQLConnector.closeConnection();
            return null;
        }
        MySQLConnector.closeConnection();
        return quizzes;
    }

    @Override
    public Quiz getQuizByID(int id) {

        return null;
    }

    @Override
    public Collection<Quiz> getQuizBySkill(int skillId) {
//        Collection<Quiz> quizzes  =new ArrayList<>() ;
//        for (Integer key : quizzes.keySet()) {
//            Quiz value = quizzes.get(key);
//            if (skillId == value.getSkill().getId()) {
//                quizzes2.add(value) ;
//            }
//
//        }
//        if (quizzes2.isEmpty() )
//        {
//            return null ;
//        }
//        return quizzes2 ;
        return  null;
    }

    @Override
    public int addQuiz(Quiz quiz) {
//        quizzes.put(quiz.getId() , quiz);
//        return quizzes.get(quiz.getId());
        return 0;
    }

    @Override
    public Boolean updateQuiz(Quiz quiz) {
//        if(!this.quizzes.containsKey(quiz.getId()))
//            return false;
//        this.quizzes.put(quiz.getId(),quiz);
//        return true;
        return true;
    }

    @Override
    public Boolean deleteQuiz(int quizId) {

//        if(!quizzes.containsKey(quizId))
//            return false;
//        quizzes.remove(quizId);

        return true;
    }

}
