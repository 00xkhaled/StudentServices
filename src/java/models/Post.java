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
public class Post implements Serializable{
    private Person author;
    private String conntent;
    private ArrayList <Comment> comments;

    public Post (Person author, String conntent){
        this. author = author;
        this.conntent = conntent;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public String getConntent() {
        return conntent;
    }

    public void setConntent(String conntent) {
        this.conntent = conntent;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }   
}
