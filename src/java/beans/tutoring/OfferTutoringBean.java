package beans.tutoring;

import beans.SessionBean;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Abdalla
 */

@Named(value = "offerTutoringBean")
@ViewScoped

public class OfferTutoringBean implements Serializable{
    private String day;
    private String time;
    private String place;
    
 @Inject
 private SessionBean sessionBean;

public OfferTutoringBean(){
    
}

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }


}