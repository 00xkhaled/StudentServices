/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.tutoring;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ursina
 */
public class Lecturer extends Person implements Serializable{
    private ArrayList<LectureDocument> documents;
    
    public Lecturer(String firstName, String lastName, String emailAddress, String phoneNumber){
        super(firstName, lastName, emailAddress, phoneNumber);
    }

    public ArrayList<LectureDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<LectureDocument> documents) {
        this.documents = documents;
    }
}
