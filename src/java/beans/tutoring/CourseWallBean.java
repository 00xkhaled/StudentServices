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
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import models.tutoring.Lecture;

@Named(value = "courseWallBean")
@ViewScoped
public class CourseWallBean implements Serializable{
    private Lecture lecture;

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
    
    public CourseWallBean(){
    }
}
