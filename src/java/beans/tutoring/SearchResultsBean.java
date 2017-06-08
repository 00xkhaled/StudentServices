/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.tutoring;

import beans.SessionBean;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import models.tutoring.Lecture;

/**
 *
 * @author Ursina
 */
@Named(value = "searchResultsBean")
@ViewScoped
public class SearchResultsBean implements Serializable{
    
    private Lecture selectedLecture;
    private ArrayList <Lecture> lectures;
    
    @Inject
    private SessionBean sessionBean;
    
    public SearchResultsBean (){
        lectures = new ArrayList<>();
    }
    
    /*private Tutoring selectedTutoring;
    private ArrayList<Tutoring> tutorings;
    
    public SearchResultsBean(){
        tutorings = new ArrayList<>();
    }

    public Tutoring getSelectedTutoring() {
        return selectedTutoring;
    }

    public void setSelectedTutoring(Tutoring selectedTutoring) {
        this.selectedTutoring = selectedTutoring;
    }
    
    public ArrayList<Tutoring> getTutorings() {
        return tutorings;
    }

    public void setTutorings(ArrayList<Tutoring> tutorings) {
        this.tutorings = tutorings;
    }
    
    public ArrayList<Tutoring> sortForTutor(Student student){
        ArrayList<Tutoring> result = new ArrayList<>();
        //for(int i = 0; i < tutorings.size(); i++ ){
        for(Tutoring t: tutorings){
            if(t.getSender().equals(student)){
                result.add(t);
            }
        }
        return(result);
    }
    
    public ArrayList<Tutoring> sortForMajor(Major major){
        ArrayList<Tutoring> result = new ArrayList<>();
        //for(int i = 0; i < tutorings.size(); i++ ){
        for(Tutoring t: tutorings){
            if(t.getMajor.equals(t.getMajor())){
                result.add(t);
            }
        }
        return(result);
    }*/

    public Lecture getSelectedLecture() {
        return selectedLecture;
    }

    public void setSelectedLecture(Lecture selectedLecture) {
        this.selectedLecture = selectedLecture;
    }

    public ArrayList<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(ArrayList<Lecture> lectures) {
        this.lectures = lectures;
    }    
}
