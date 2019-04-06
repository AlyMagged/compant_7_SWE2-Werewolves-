package com.werewolves.quizsection.services;

import com.werewolves.quizsection.entities.Skill;
import com.werewolves.quizsection.models.SkillModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    @Autowired
    @Qualifier("MySQLSkillModel")
    SkillModel skillModel;

    public int addSkill(Skill skill)
    {
        return skillModel.addSkill(skill);
    }
}
