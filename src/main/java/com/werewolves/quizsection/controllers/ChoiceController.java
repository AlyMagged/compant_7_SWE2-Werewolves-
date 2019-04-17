package com.werewolves.quizsection.controllers;

import com.werewolves.quizsection.entities.Choice;
import com.werewolves.quizsection.entities.Question;
import com.werewolves.quizsection.entities.Quiz;
import com.werewolves.quizsection.services.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/quiz/{quizId}/question/{questionId}/choice")
public class ChoiceController {

    @Autowired
    private ChoiceService choiceService;

    @GetMapping(value = {"" , "/"})
    public Collection<Choice> getAllChoices(@PathVariable int quizId ,@PathVariable int questionId){
        return this.choiceService.getAllChoices(quizId , questionId);
    }

    @GetMapping(value = "/{id}")
    public Choice getChoiceByID(@PathVariable int quizId ,@PathVariable int questionId ,@PathVariable int id){
        return this.choiceService.getChoiceByID(quizId , questionId , id);
    }

    @PostMapping(value = {"" , "/"})
    public Choice insertChoice(@PathVariable int quizId ,@PathVariable int questionId ,@RequestBody Choice choice){
        return this.choiceService.insertChoice(quizId , questionId ,choice);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteChoiceByID(@PathVariable int quizId ,@PathVariable int questionId , @PathVariable int id){
        this.choiceService.deleteChoiceByID(quizId , questionId ,id);
    }


    @PutMapping(value = {"","/"})
    public Choice updateChoiceByID(@PathVariable int quizId ,@PathVariable int questionId ,@RequestBody Choice choice){
        return this.choiceService.updateChoiceByID(quizId ,questionId ,choice);
    }


}
