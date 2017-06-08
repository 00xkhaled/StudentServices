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
public class Lecture implements Serializable{
    private int lectureId;
    private String lectureCode;
    private String lectureNameEn;
    private String lectureNameAr;
    //the following attribute was of type Major:
    private String major;
    private ArrayList <Post> posts;


    public Lecture(String lectureNameEn, ArrayList<Post> posts){
        this.lectureNameEn = lectureNameEn;
        this.posts = posts;
    }
    
    public Lecture(){}
    
    public Lecture (String lectureNameEn){
        this.lectureNameEn = lectureNameEn;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public String getLectureCode() {
        return lectureCode;
    }

    public void setLectureCode(String lectureCode) {
        this.lectureCode = lectureCode;
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
