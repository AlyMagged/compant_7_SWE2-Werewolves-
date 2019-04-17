package com.werewolves.quizsection.services;

import com.werewolves.quizsection.entities.Quiz;
import com.werewolves.quizsection.entities.Submission;
import com.werewolves.quizsection.models.SubmissionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Service
public class SubmissionService {
    @Autowired
    @Qualifier("MySQLSubmissionModel")
    SubmissionModel submissionModel;

    public Collection<Submission> getAllSubmissions()
    {
        return submissionModel.getAllSubmissions();
    }

    public Submission getSubmissionByID(int id )
    {
        return submissionModel.getSubmissionByID(id);
    }


    public Collection<Submission> getSubmissionsForQuiz(int quizId )
    {
        return submissionModel.getSubmissionForQuiz(quizId);
    }

    public Collection<Submission> getSubmissionsForUser(int userId )
    {

        return submissionModel.getSubmissionForUser(userId);
    }

    public int addSubmission(int userId ,int quizId ,Collection<Integer> answersIds )
    {
        int score = evaluateSubmission(quizId, answersIds);

        // datetime calculate
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = formatter.format(date);


        return submissionModel.addSubmission(new Submission(score,userId, new Quiz(quizId), strDate));
    }

    private int evaluateSubmission(int quizId, Collection<Integer> answersIds)
    {
        //temporary function
        return 10;
    }
}
