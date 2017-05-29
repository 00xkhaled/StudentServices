/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Ursina
 */
public class Student extends Person implements Serializable{
    private String major;
    private int creditScore;
    
    public Student(String firstName, String lastName, String major, String emailAddress, String phoneNumber){
        super(firstName, lastName, emailAddress, phoneNumber);
        this.major = major;
        creditScore = 25; 
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }
    
    public void incrementCreditScore(){
        creditScore = creditScore + 5;
    }
    
    public void decrementCreditScore(){
        creditScore = creditScore - 5;
    }
}
