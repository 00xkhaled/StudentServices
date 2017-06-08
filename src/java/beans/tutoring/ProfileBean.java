/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.tutoring;

/**
 *
 * @author Ursina
 */
import beans.SessionBean;
import daos.tutoring.MajorsDao;
import daos.tutoring.PersonsDao;
import daos.tutoring.SchoolsDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.tutoring.Person;

/**
 *
 * @author Firas.Alhawari
 * 
 */
@Named(value = "profileBean")
@ViewScoped
public class ProfileBean implements Serializable{
    
    private Person student;
    private PersonsDao personsDao;
    private ArrayList<Person> people;
    private MajorsDao majorDao;
    private SchoolsDao schoolsDao;
    
    @Inject
    private SessionBean sessionBean;
    
    public ProfileBean() {        
    }
    
    @PostConstruct
    public void init(){
        try {            
            //needs a HashMap<Integer, Major> (theoretisch aus majorDao)
            people = personsDao.buildPersons(majorDao.buildMajorsMap(schoolsDao.buildSchoolsMap())); 
            student = people.get(0);
        } catch (Exception ex) {
            Logger.getLogger(ProfileBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }
    
    
}

