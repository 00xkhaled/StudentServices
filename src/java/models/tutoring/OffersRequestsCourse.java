/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.tutoring;

import java.io.Serializable;

/**
 *
 * @author Ursina
 */
public class OffersRequestsCourse implements Serializable{
    private int OffersRequestsCourseId;
    private Person learner;
    private Tutoring tutoring;
    private boolean accpeted;
    
    public OffersRequestsCourse(){}

    public int getOffersRequestsCourseId() {
        return OffersRequestsCourseId;
    }

    public void setOffersRequestsCourseId(int OffersRequestsCourseId) {
        this.OffersRequestsCourseId = OffersRequestsCourseId;
    }

    public Person getLearner() {
        return learner;
    }

    public void setLearner(Person learner) {
        this.learner = learner;
    }

    public Tutoring getTutoring() {
        return tutoring;
    }

    public void setTutoring(Tutoring tutoring) {
        this.tutoring = tutoring;
    }

    public boolean isAccpeted() {
        return accpeted;
    }

    public void setAccpeted(boolean accpeted) {
        this.accpeted = accpeted;
    }
    
    
}
