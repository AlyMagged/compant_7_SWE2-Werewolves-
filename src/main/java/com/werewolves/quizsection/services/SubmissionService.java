package com.werewolves.quizsection.services;

import com.werewolves.quizsection.entities.Submission;
import com.werewolves.quizsection.models.SubmissionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService {
    SubmissionModel submissionModel ;

    @Autowired
    public Submission add(Submission submission) {
        Submission newSubmission =  this.submissionModel.add(submission);
        return  null ;
    }
}
