/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ursina
 */
public class Lecture implements Serializable{
    private ArrayList <Lecturer> lecturers;
    private String lectureNameEn;
    private String lectureNameAr;
    //the following attribute was of type Major:
    private String major;
    private ArrayList <Post> posts;
    private ArrayList <LectureDocument> documents;


    public Lecture(String lectureNameEn, ArrayList <Lecturer> lecturers, ArrayList<Post> posts, ArrayList <LectureDocument> documents){
        this.lectureNameEn = lectureNameEn;
        this.lecturers = lecturers;
        this.posts = posts;
        this.documents = documents;
    }
    
    public Lecture (String lectureNameEn, ArrayList <Lecturer> lecturers){
        this.lectureNameEn = lectureNameEn;
        this.lecturers = lecturers;
    }
    
    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(ArrayList<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public String getLectureNameEn() {
        return lectureNameEn;
    }

    public void setLectureNameEn(String lectureNameEn) {
        this.lectureNameEn = lectureNameEn;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<LectureDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<LectureDocument> documents) {
        this.documents = documents;
    }

    public String getLectureNameAr() {
        return lectureNameAr;
    }

    public void setLectureNameAr(String lectureNameAr) {
        this.lectureNameAr = lectureNameAr;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }    
}
