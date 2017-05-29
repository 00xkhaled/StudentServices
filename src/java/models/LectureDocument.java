/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author Ursina
 */
public class LectureDocument implements Serializable{
    private String path;
    private String documentName;
    private Lecturer lecturer;
    private Timestamp lastUpdated;
    
    public LectureDocument(String path, String documentName, Lecturer lecturer){
        this.path = path;
        this.documentName = documentName;
        this.lecturer = lecturer;
        this.lastUpdated = Timestamp.valueOf(LocalDateTime.now());
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
    
    public Timestamp getLastUpdated(){
        return lastUpdated;
    }
    
}
