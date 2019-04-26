package com.werewolves.quizsection.models.mySQLModels;


import com.werewolves.quizsection.entities.Choice;
import com.werewolves.quizsection.entities.Question;
import com.werewolves.quizsection.entities.Quiz;
import com.werewolves.quizsection.models.QuestionModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("MySQLQuestionModel")
public class MySQLQuestionModel extends QuestionModel {
    private String tableName = "questions";


    @Override
    public Collection<Question> getAllQuestions(int quizId) {
        MySQLConnector.openConnection();
        String q = "SELECT " +
                "q.id q_id, " +
                "q.question_title, " +
                "q.quiz_id, " +
                "q.correct_answer_id, " +
                "c.id c_id, " +
                "c.answer " +
                "FROM " +
                this.tableName+" q LEFT JOIN choices c " +
                "ON q.id = c.question_id " +
                "WHERE q.quiz_id = "+quizId;
        ResultSet resultSet = MySQLConnector.executeQuery(q);

        Map<Integer , Question> questions = new HashMap<Integer, Question>();
        Question questionTemp = null;

        int
                q_id,
                quiz_id,
                correct_answer_id,
                c_id;

        String
                question_title,
                answer;

        try {
            while(resultSet.next())
            {
                q_id = resultSet.getInt("q_id");
                quiz_id = resultSet.getInt("quiz_id");
                correct_answer_id = resultSet.getInt("correct_answer_id");
                c_id = resultSet.getInt("c_id");

                question_title = resultSet.getString("question_title");
                answer = resultSet.getString("answer");

                questionTemp = questions.get(q_id);
                if(questionTemp == null)
                    questionTemp = new Question(q_id,question_title , new Choice(correct_answer_id),  new Quiz(quiz_id));


                questionTemp.addChoice(new Choice(c_id, answer));
                questions.put(questionTemp.getId(),questionTemp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            MySQLConnector.closeConnection();
            return null;
        }
        MySQLConnector.closeConnection();
        return questions.values();
    }

    @Override
    public Question getQuestionByID(int id) {
        MySQLConnector.openConnection();

        String q = "SELECT " +
                "q.id q_id, " +
                "q.question_title, " +
                "q.quiz_id, " +
                "q.correct_answer_id, " +
                "c.id c_id, " +
                "c.answer " +
                "FROM " +
                this.tableName+" q LEFT JOIN choices c " +
                "ON q.id = c.question_id " +
                "WHERE q.id = "+id;


        Question questionTemp = null;

        int
                q_id,
                quiz_id,
                correct_answer_id,
                c_id;

        String
                question_title,
                answer;

        ResultSet resultSet = MySQLConnector.executeQuery(q);
        try {
            while(resultSet.next())
            {
                q_id = resultSet.getInt("q_id");
                quiz_id = resultSet.getInt("quiz_id");
                correct_answer_id = resultSet.getInt("correct_answer_id");
                c_id = resultSet.getInt("c_id");

                question_title = resultSet.getString("question_title");
                answer = resultSet.getString("answer");

                if(questionTemp == null)
                    questionTemp = new Question(q_id,question_title , new Choice(correct_answer_id),  new Quiz(quiz_id));


                questionTemp.addChoice(new Choice(c_id, answer));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            MySQLConnector.closeConnection();
            return null;
        }
        MySQLConnector.closeConnection();
        return questionTemp;
    }

    @Override
    public int addQuestion(Question question) {
        MySQLConnector.openConnection();
        String q = "INSERT INTO "+this.tableName+"(question_title, quiz_id) VALUES ('"+question.getTitle()+"',"+question.getQuiz().getId()+");";

        int id = -1;
        if(MySQLConnector.executeUpdate(q))
            id = MySQLConnector.getIdOfTheLastAddedIn(this.tableName);

        MySQLConnector.closeConnection();
        return id;
    }

    @Override
    public boolean deleteQuestionByID(int id) {
        if(!isExist(id))
            return false;

        MySQLConnector.openConnection();
        String q = "DELETE FROM "+this.tableName+" WHERE id ="+id+";";

        Boolean result = MySQLConnector.executeUpdate(q);
        MySQLConnector.closeConnection();
        return  result;
    }

    @Override
    public boolean updateQuestionByID(Question newQuestion) {
        if(!isExist(newQuestion.getId()))
            return false;

        MySQLConnector.openConnection();
        String q = "UPDATE "+this.tableName+" SET question_title='"+newQuestion.getTitle()+"', quiz_id='"+newQuestion.getQuiz().getId()+"', correct_answer_id="+newQuestion.getCorrectChoice().getId()+" WHERE id ="+newQuestion.getId()+";";
        Boolean result = MySQLConnector.executeUpdate(q);
        MySQLConnector.closeConnection();
        return  result;
    }

    private Boolean isExist(int id)
    {
        Question question = this.getQuestionByID(id);
        if(question == null)
            return false;
        return true;
    }
}
