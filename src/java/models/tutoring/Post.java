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
public class Post implements Serializable{
    private int postId;
    private Person author;
    private String conntent;
    private ArrayList <Comment> comments;

    public Post (Person author, String conntent){
        this. author = author;
        this.conntent = conntent;
    }
    
    public Post(){}

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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
