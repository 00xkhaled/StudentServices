package beans.tutoring;

import beans.SessionBean;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import models.tutoring.Tutoring;

/**
 *
 * @author Ursina
 */
@Named(value = "tutoringOffersBean")
@ViewScoped
public class TutoringOffersBean implements Serializable{
    private Tutoring selectedTutoring;
    private ArrayList <Tutoring> tutorings;
    
    @Inject
    private SessionBean sessionBean;
    
    public TutoringOffersBean(){
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
    
    public void requestThisCourse(){
        //method that will be called if a student selects a special course
    }
    
}
