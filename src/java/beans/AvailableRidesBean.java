package beans;

import javax.inject.Named;
import java.io.Serializable;
import javax.inject.Inject;
import daos.AvailableRidesDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import models.AvailableRide;
/**
 *
 * @author OthmanKurdi
 */
@Named(value = "availableRidesBean")
@ViewScoped
public class AvailableRidesBean implements Serializable {
    
   
    private int ride_id;
    private String ride_from;
    private String ride_to;
    private String name;
    private String phone;
    private String departure_time;
    
    private AvailableRide selectedRide;
    private final AvailableRidesDao ridesdao=new AvailableRidesDao();
    private ArrayList<AvailableRide> list;
    
     @Inject
    private SessionBean sessionBean;
     
    public AvailableRidesBean(){
    }
    
     @PostConstruct
    public void init(){
      
       try {
           
            list = ridesdao.getRides();            
        } catch (Exception ex) {
            Logger.getLogger(AvailableRidesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getRideID(){
        return Integer.toString(this.ride_id);
    }
    public void setRideID(String ride_id){
        this.ride_id=Integer.parseInt(ride_id);
    }
    public AvailableRide getSelectedRide() {
        return selectedRide;
    }
    public void setSelectedRide(AvailableRide selectedRides) {
        this.selectedRide = selectedRides;
    } 
    // hay hee elee ma3molelha call bl page
    
    
     public String getRideFrom(){
        return this.ride_from;
    }
    public void setRideFrom(String ride_from){
        this.ride_from=ride_from;
    }
    
     public String getRideTo(){
        return this.ride_to;
    }
    public void setRideTo(String ride_to){
        this.ride_to=ride_to;
    }
    
     public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    
     public String getPhone(){
        return this.phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    
     public String getDepartureTime(){
        return this.departure_time;
    }
    public void setDepartureTime(String departure_time){
        this.departure_time=departure_time;
    }
    
    public void saveSelectedItemId(){
        sessionBean.setSelectedItemId(selectedRide.getRideID());
    }

    public ArrayList<AvailableRide> getList() {
        return list;
    }

    public void setList(ArrayList<AvailableRide> list) {
        this.list = list;
    }
     public void deleteSelectedRide(){
        try {
            ridesdao.deleteRide(selectedRide.getRideID());
            sessionBean.navigate("available_rides");
        } catch (Exception ex) {
            Logger.getLogger(AvailableRidesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
