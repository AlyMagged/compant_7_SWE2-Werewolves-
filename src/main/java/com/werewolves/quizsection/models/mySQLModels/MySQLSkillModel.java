package com.werewolves.quizsection.models.mySQLModels;

import com.werewolves.quizsection.entities.Skill;
import com.werewolves.quizsection.models.SkillModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("MySQLSkillModel")
public class MySQLSkillModel extends SkillModel {
    private String tableName = "skills";

    @Override
    public int addSkill(Skill skill) {
        MySQLConnector.openConnection();
        String q = "INSERT INTO "+tableName+"(name) VALUES ('"+skill.getName()+"');";
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
