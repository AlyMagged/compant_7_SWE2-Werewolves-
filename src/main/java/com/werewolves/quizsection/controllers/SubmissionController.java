package com.werewolves.quizsection.controllers;

import com.werewolves.quizsection.entities.Quiz;
import com.werewolves.quizsection.entities.Submission;
import com.werewolves.quizsection.services.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/quiz/{id}/submission")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService ;

    @PostMapping(value = {"" , "/"})
    public Submission add(@RequestBody Submission submission)
    {
        return SubmissionService.add(submission) ;
    }




}
