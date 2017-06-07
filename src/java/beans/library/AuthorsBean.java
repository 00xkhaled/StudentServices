/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.library;

import javax.inject.Named;
import java.io.Serializable;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import models.library.Authors;
import beans.SessionBean;
import javax.faces.view.ViewScoped;
import daos.library.AuthorsDao;


/**
 *
 * @author tarekashi
 */
@Named(value = "AuthorsBean")
@ViewScoped
public class AuthorsBean implements Serializable {

    private int authorId;
    private String authornameEn;
    private String authornameAr;

    private final AuthorsDao authors_dao = new AuthorsDao();
    private ArrayList<Authors> authorList;

    @Inject

    private SessionBean sessionBean;

    public AuthorsBean() { 
    }

    @PostConstruct

    public void init() {
        try {
            authorList = authors_dao.buildAuthors();
        } catch (Exception ex) {
            Logger.getLogger(AuthorsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    public ArrayList<Authors> getList() {
        return authorList;
    }

    public void setList(ArrayList<Authors> list) { //TO SET IN THE list of type model to save result from database
        this.authorList = authorList;
    }
}
