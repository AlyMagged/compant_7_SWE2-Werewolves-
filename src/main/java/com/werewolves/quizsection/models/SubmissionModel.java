package com.werewolves.quizsection.models;

import com.werewolves.quizsection.entities.Submission;

public abstract class SubmissionModel extends Model {
    public abstract int add(Submission submission);
}