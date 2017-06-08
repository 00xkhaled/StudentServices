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
import beans.ManageEventsBean;
import beans.SessionBean;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.tutoring.Lecture;

@Named(value = "courseWallBean")
@ViewScoped
public class CourseWallBean implements Serializable{
    private Lecture lecture;
    
    @Inject
    private SessionBean sessionBean;

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
    
    public CourseWallBean(){
    }
    
   /* @PostConstruct
    public void init(){
        try {            
            lecture = lecturesDao.buildLectures();            
        } catch (Exception ex) {
            Logger.getLogger(ManageEventsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
}
