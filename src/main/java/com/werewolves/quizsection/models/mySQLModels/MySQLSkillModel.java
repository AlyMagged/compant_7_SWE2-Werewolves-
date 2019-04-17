package com.werewolves.quizsection.models.mySQLModels;

import com.werewolves.quizsection.entities.Choice;
import com.werewolves.quizsection.entities.Skill;
import com.werewolves.quizsection.models.SkillModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("MySQLSkillModel")
public class MySQLSkillModel extends SkillModel {
    private static Map<Integer , Skill> skills;
    private static int counter = 5;
    static {
        skills = new HashMap<Integer, Skill>(){
            {
                put(1 , new Skill(1,"Html"));
                put(2 , new Skill(2,"CSS"));
                put(3 , new Skill(3,"JS"));
                put(4 , new Skill(4,"JQuery"));
            }
        };
    }

    private String tableName = "skills";

    @Override
    public int addSkill(Skill skill) {
        skill.setId(counter++);
        this.skills.put(skill.getId() , skill);
        return skill.getId();
    }

    @Override
    public Collection<Skill> getAllSkills() {
        Collection<Skill> skills = new ArrayList<>();
        for (Skill skill : this.skills.values()) {
            skills.add(skill);
        }
        return skills;
    }

    @Override
    public Skill getSkillByID(int id) {
        return this.skills.get(id);
    }

    @Override
    public Boolean updateSkill(Skill skill) {
        if(!this.skills.containsKey(skill.getId()))
            return false;
        this.skills.put(skill.getId(),skill);
        return true;
    }

    @Override
    public Boolean deleteSkill(int id) {
        if(!this.skills.containsKey(id))
            return false;
        this.skills.remove(id);
        return true;
    }
//    @Override
//    public int addSkill(Skill skill) {
//        MySQLConnector.openConnection();
//        String q = "INSERT INTO "+tableName+"(name) VALUES ('"+skill.getName()+"');";
//        if(MySQLConnector.executeUpdate(q))
//        {
//            return MySQLConnector.getIdOfTheLastAddedIn(tableName);
//        }
//        else
//        {
//            return 0;
//        }
//    }


}
