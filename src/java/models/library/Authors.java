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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthornameEn() {
        return authornameEn;
    }

    public void setAuthornameEn(String authornameEn) {
        this.authornameEn = authornameEn;
    }

    public String getAuthornameAr() {
        return authornameAr;
    }

    public void setAuthornameAr(String authornameAr) {
        this.authornameAr = authornameAr;
    }

}
