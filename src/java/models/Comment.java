/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author Ursina
 */
public class Comment implements Serializable{
    private Person author;
    private String conntent;
    
    public Comment(Person author, String conntent){
        this.author = author;
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
    
    
}
