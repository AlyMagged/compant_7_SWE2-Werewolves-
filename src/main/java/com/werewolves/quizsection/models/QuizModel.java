package com.werewolves.quizsection.models;
import com.werewolves.quizsection.entities.Quiz;

import java.util.Collection;


public abstract class QuizModel extends Model {

    //public abstract int add(Quiz quiz);

    //public abstract Collection<Quiz> getAllQuizzes();

    //public abstract Quiz getQueizeByID(int id);

    //public abstract Quiz updateQuizeByID(com.werewolves.quizsection.entities.Quiz quiz);

    //public abstract Quiz deleteQuizeByID(int id);

    public abstract int insertQuize(Quiz quiz);
}
