/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.tutoring;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import models.tutoring.Lecture;
import models.tutoring.Lecturer;

/**
 *
 * @author Ursina
 */
@Named(value = "pastMaterialBean")
@ViewScoped
public class PastMaterialBean implements Serializable{
    private Lecturer lecturer;
    private Lecture lecture;

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }  

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
    
    public PastMaterialBean(){     
    }
}
