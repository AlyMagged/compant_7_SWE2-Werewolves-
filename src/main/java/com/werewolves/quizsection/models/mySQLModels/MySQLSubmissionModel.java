package com.werewolves.quizsection.models.mySQLModels;

import com.werewolves.quizsection.entities.Quiz;
import com.werewolves.quizsection.entities.Submission;
import com.werewolves.quizsection.models.SubmissionModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("MySQLSubmissionModel")
public class MySQLSubmissionModel extends SubmissionModel {
    private static Map<Integer , Submission> submissions;
    private static int counter = 5;
    static {
        submissions = new HashMap<Integer, Submission>(){
            {
                put(1 , new Submission(1,5,5, new Quiz(3), "2019-4-12 23:59:59"));
                put(2 , new Submission(2,6,6, new Quiz(3), "2019-4-12 23:59:59"));
                put(3 , new Submission(3,6,6, new Quiz(3), "2019-4-12 23:59:59"));
                put(4 , new Submission(4,6,6, new Quiz(3), "2019-4-12 23:59:59"));
            }
        };
    }

    @Override
    public int addSubmission(Submission submission) {
        submission.setId(counter++);
        this.submissions.put(submission.getId() , submission);
        return submission.getId();
    }

    @Override
    public Collection<Submission> getAllSubmissions() {
        Collection<Submission> submissions = new ArrayList<>();
        for (Submission submission : this.submissions.values()) {
            submissions.add(submission);
        }
        return submissions;
    }

    @Override
    public Submission getSubmissionByID(int id) {
        return this.submissions.get(id);
    }

    @Override
    public Collection<Submission> getSubmissionForQuiz(int quizId)
    {
        Collection<Submission> submissions = new ArrayList<>();
        for (Submission submission : this.submissions.values()) {
            if(submission.getQuiz().getId() == quizId)
                submissions.add(submission);
        }
        return submissions;
    }

    @Override
    public Collection<Submission> getSubmissionForUser(int userId)
    {
        Collection<Submission> submissions = new ArrayList<>();
        for (Submission submission : this.submissions.values()) {
            if(submission.getUserId() == userId)
                submissions.add(submission);
        }
        return submissions;
    }

}
