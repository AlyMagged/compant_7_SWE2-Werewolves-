package com.werewolves.quizsection.controllers;

import com.werewolves.quizsection.entities.Choice;
import com.werewolves.quizsection.services.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/quiz/{id}/question/{id}/choice")
public class ChoiceController {

    @Autowired
    private ChoiceService choiceService;

    @GetMapping(value = {"" , "/"})
    public Collection<Choice> getAllChoices(){
        return this.choiceService.getAllChoices();
    }

    @GetMapping(value = "/{id}")
    public Choice getChoiceByID(@PathVariable int id){
        return this.choiceService.getChoiceByID(id);
    }

    @PutMapping(value = "/{id}")
    public Choice updateChoiceByID(@RequestBody Choice choice){
        return this.choiceService.updateChoiceByID(choice);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteChoiceByID(@PathVariable int id){
        this.choiceService.deleteChoiceByID(id);
    }

    @PostMapping(value = {"" , "/"})
    public Choice insertChoice(@RequestBody Choice c){
        //Choice c = new Choice(10 , "title" , 2);

        return this.choiceService.insertChoice(c);
    }
}
