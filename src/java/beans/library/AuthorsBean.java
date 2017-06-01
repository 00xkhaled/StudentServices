/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.library;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import models.library.Authors;
import beans.SessionBean;
import daos.library.AuthorsDao;


/**
 *
 * @author tarekashi
 */
@Named(value = "AuthorsBean")
@SessionScoped
public class AuthorsBean implements Serializable {

    private int authorId;
    private String authornameEn;
    private String authornameAr;
    
    private final AuthorsDao authors_dao = new AuthorsDao();
    private ArrayList<Authors> authorList;
    
    @Inject
    
    private SessionBean sessionBean;
    
    public AuthorsBean(){
        init ();
    }
       @PostConstruct
       
       public void init(){
           try{
               authorList = authors_dao.buildAuthors();
           } catch (Exception ex){
               Logger.getLogger(AuthorsBean.class.getName()).log(Level.SEVERE, null, ex);   
           } 
       }
       
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
      
  
       public ArrayList<Authors> getList() {
        return authorList;
    }
       
       public void setList(ArrayList<Authors> list) { //TO SET IN THE list of type model to save result from database
        this.authorList = authorList;
    }
}
