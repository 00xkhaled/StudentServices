/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.library;

import java.io.Serializable;

/**
 *
 * @author tarekashi
 */
public class Authors implements Serializable {

    private int authorId;
    private String authornameEn;
    private String authornameAr;
    
/**
     * @return the authorId
     */
    public int getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId the authorId to set
     */
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    /**
     * @return the authornameEn
     */
    public String getAuthornameEn() {
        return authornameEn;
    }

    /**
     * @param authornameEn the authornameEn to set
     */
    public void setAuthornameEn(String authornameEn) {
        this.authornameEn = authornameEn;
    }

    /**
     * @return the authornameAr
     */
    public String getAuthornameAr() {
        return authornameAr;
    }

    /**
     * @param authornameAr the authornameAr to set
     */
    public void setAuthornameAr(String authornameAr) {
        this.authornameAr = authornameAr;
    }    
    
}
