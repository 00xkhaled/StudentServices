/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.tutoring;

import beans.SessionBean;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.tutoring.Major;
import models.tutoring.School;


/**
 *
 * @author Abdalla
 */

@Named(value = "searchCourseBean")
@ViewScoped

public class SearchCourseBean implements Serializable{
    private ArrayList<Major> majors;
    private ArrayList<School> schools; /*can we inherit an arraylist from another? */
    
    @Inject
    private SessionBean sessionBean;

public SearchCourseBean(){
    
}    
    public ArrayList<School> getSchools() {
        return schools;
    }

    public void setSchools(ArrayList<School> schools) {
        this.schools = schools;
    }

    public ArrayList<Major> getMajors() {
        return majors;
    }

    public void setMajors(ArrayList<Major> majors) {
        this.majors = majors;
    }   
}