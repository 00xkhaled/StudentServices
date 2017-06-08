/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.tutoring;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Ursina
 */
public class Tutoring implements Serializable{
    private int tutoringId;
    private String day;
    private String time;
    private String location;
    private Timestamp offered;
    private Person tutor;
    
    public Tutoring(){}

    public int getTutoringId() {
        return tutoringId;
    }

    public void setTutoringId(int tutoringId) {
        this.tutoringId = tutoringId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getOffered() {
        return offered;
    }

    public void setOffered(Timestamp offered) {
        this.offered = offered;
    }

    public Person getTutor() {
        return tutor;
    }

    public void setTutor(Person tutor) {
        this.tutor = tutor;
    }
    
}
