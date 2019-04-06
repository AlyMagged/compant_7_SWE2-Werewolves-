package com.werewolves.quizsection.controllers;

import com.werewolves.quizsection.entities.Quiz;
import com.werewolves.quizsection.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/quiz")

public class QuizController  {

    @Autowired
    private QuizService quizService;

    @PostMapping(value = {"" , "/"})
        public Quiz add(@RequestBody Quiz quiz)
        {
            return quizService.insertQuiz(quiz) ;
        }
}
