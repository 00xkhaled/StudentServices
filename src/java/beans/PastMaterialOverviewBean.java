/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import models.Lecture;

import models.LectureDocument;

/**
 *
 * @author Ursina
 */
@Named(value = "pastMaterialOverviewBean")
@ViewScoped
public class PastMaterialOverviewBean implements Serializable{
    private Lecture lecture;

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
        
    public PastMaterialOverviewBean(){     
    }
}
