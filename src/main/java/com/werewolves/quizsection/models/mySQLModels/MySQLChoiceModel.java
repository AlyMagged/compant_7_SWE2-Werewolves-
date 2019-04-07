package com.werewolves.quizsection.models.mySQLModels;

import com.werewolves.quizsection.entities.Choice;
import com.werewolves.quizsection.models.ChoiceModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
@Qualifier("MySQLChoiceModel")
public class MySQLChoiceModel extends ChoiceModel {
    private String tableName = "choices";


    @Override
    public Collection<Choice> getAllChoices() {
        return null;
    }

    @Override
    public Choice getChoiceByID(int id) {
        return null;
    }

    @Override
    public Choice updateChoiceByID(Choice choice) {
        return null;
    }

    @Override
    public Choice deleteChoiceByID(int id) {
        return null;
    }

    @Override
    public int insertChoice(Choice c) {
        MySQLConnector.openConnection();
        String q = "INSERT INTO " + tableName + "(`answer`, `question_id`) VALUES ('" + c.getTitle() + "', " +c.getQuestion()+");";
        System.out.println("query -> " + q);
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
