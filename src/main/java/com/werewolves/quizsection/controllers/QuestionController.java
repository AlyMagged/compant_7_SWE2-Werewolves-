package com.werewolves.quizsection.controllers;


import com.werewolves.quizsection.entities.Question;
import com.werewolves.quizsection.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/quiz/{quizId}/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping(value = {"" , "/"})
    public Collection<Question> getAllQuestions(@PathVariable int quizId){
        return this.questionService.getAllQuestions(quizId);
    }

    @GetMapping(value = "/{id}")
    public Question getQuestionByID(@PathVariable int quizId ,@PathVariable int id) {
        return this.questionService.getQuestionByID(quizId ,id);

    }

    @PostMapping(value = {"" , "/"})
    public Question insertQuestion(@PathVariable int quizId ,@RequestBody Question question){

        return this.questionService.insertQuestion(quizId , question);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteQuestionByID(@PathVariable int quizId ,@PathVariable int id){

        this.questionService.deleteQuestionByID(quizId , id);
    }

    @PutMapping(value = {"" , "/"})
    public Question updateQuestionByID(@PathVariable int quizId ,@RequestBody Question question){
        return this.questionService.updateQuestionByID(quizId , question);
    }

}
