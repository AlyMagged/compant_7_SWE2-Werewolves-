package com.werewolves.quizsection.controllers;

import com.werewolves.quizsection.entities.Submission;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("api/submission")
public class SubmissionController {

    @GetMapping(value = {"","/"})
    public Collection<Submission> getAllSubmissions()
    {
        return null;
    }

    @GetMapping(value = "/{id}")
    public Submission getSubmissionByID(@PathVariable int id)
    {
        return null;
    }

    @GetMapping(value = "/quiz/{quizId}")
    public Collection<Submission> getSubmissionsForQuiz(@PathVariable int quizId)
    {
        return null;
    }

    @GetMapping(value = "/user/{userId}")
    public Collection<Submission> getSubmissionsForUser(@PathVariable int userId)
    {
        return null;
    }

    @PostMapping(value = "/quiz/{quizId}/user/{userId}")
    public int addSubmission(@PathVariable int quizId, @PathVariable int userId, Collection<Integer> answersIds)
    {
        //something seems to be wrong
        return 0;
    }
}
