/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.tutoring;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author Ursina
 */
public class Comment implements Serializable{
    private int commentId;
    private Person author;
    private String content;
    private Post post;
    
    public Comment(){}
    
    public Comment(Person author, String content){
        this.author = author;
        this.content = content;   
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
