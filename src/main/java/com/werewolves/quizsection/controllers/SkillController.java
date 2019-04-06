package com.werewolves.quizsection.controllers;

import com.werewolves.quizsection.entities.Skill;
import com.werewolves.quizsection.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/skill")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @PostMapping(value = {"" , "/"})
    public int addSkill(@RequestBody Skill skill)
    {
        return skillService.addSkill(skill);
    }

    @GetMapping(value = {"","/"})
    public Skill getSkill()
    {
        Skill skill = new Skill("HTML");
        return skill;
    }
}
