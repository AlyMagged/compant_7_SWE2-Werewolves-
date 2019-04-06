package com.werewolves.quizsection.controllers;


import com.werewolves.quizsection.entities.Question;
import com.werewolves.quizsection.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/quiz/{id}/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping(value = {"" , "/"})
    public Collection<Question> getAllQuestions(){
        return this.questionService.getAllQuestions();
    }

    @GetMapping(value = "/{id}")
    public Question getChoiceByID(@PathVariable int id) {
        return this.questionService.getQuestionByID(id);

    }

    @PutMapping(value = "/{id}")
    public Question updateChoiceByID(@RequestBody Question question){
        return this.questionService.updateQuestionByID(question);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteQuestionByID(@PathVariable int id){

        this.questionService.deleteQuestionByID(id);
    }

    @PostMapping(value = {"" , "/"})
    public Question insertQuestion(@RequestBody Question question){

        return this.questionService.insertQuestion(question);
    }
}
