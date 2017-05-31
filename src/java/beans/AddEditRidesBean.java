package beans;

import daos.AvailableRidesDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.AvailableRides;

/**
 *
 * @author OthmanKurdi
 */
@Named(value = "addEditRidesBean")
@ViewScoped
public class AddEditRidesBean implements Serializable
{

    private int ride_id;
    private String ride_from;
    private String ride_to;
    private String name;
    private String phone;
    private String departure_time;
   
    private AvailableRides selectedRide;
    private final AvailableRidesDao ridesdao=new AvailableRidesDao();
    private ArrayList<AvailableRides> list;
    
   @Inject
    private SessionBean sessionBean;
   
    public AddEditRidesBean() {
    }
    //the next methode will help me while editing, so that it will get the values of the 
    //attributes and fill them in the in the input fields
     @PostConstruct
    public void init(){
       try {
        ride_id = sessionBean.getSelectedItemId();
            
            if(ride_id > 0){
            AvailableRides ride=ridesdao.getRide(ride_id);
            
            ride_from=ride.getRideFrom();
            ride_to=ride.getRideTo();
            name=ride.getName();
            phone=ride.getPhone();
            departure_time=ride.getDepartureTime();
            }
        } catch (Exception ex) {
            Logger.getLogger(AvailableRidesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //this method should add the value directly. and it will navigate to the edit update method in the dao.
    public void addRide(){
         try { 
        AvailableRides insertRide = new AvailableRides();
        
        insertRide.setRideFrom(ride_from);
        insertRide.setRideTo(ride_to);
        insertRide.setName(name);
        insertRide.setPhone(phone);
        insertRide.setDepartureTime(departure_time);
        System.out.println("beans.AddEditAvailableRidesBean.AddRide()");
            if (sessionBean.getSelectedItemId() > 0) {
                ridesdao.updateRide(insertRide);
            } else {
                ridesdao.insertRide(insertRide);
            }         
        } catch (Exception ex) {
            Logger.getLogger(AddEditRidesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessionBean.navigate("available_rides");
       
    }
    
    public AvailableRides getSelectedRide() {
        return selectedRide;
    }
    public void setSelectedRide(AvailableRides selectedRides) {
        this.selectedRide = selectedRides;
    } 
    public int getRideID(){
        return this.ride_id;
    }
    public void setRideID(int ride_id){
        this.ride_id=ride_id;
    }
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
         System.out.println("beans.AddEditRidesBean.saveSelectedItemId()");
        sessionBean.setSelectedItemId(selectedRide.getRideID());
    }
}
