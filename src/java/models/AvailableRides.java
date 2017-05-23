
package models;
import java.io.Serializable;
import java.sql.Timestamp;
 /*
 * @author OthmanKurdi
 */
public class AvailableRides implements Serializable{

    
    private int ride_id;
    private String ride_from;
    private String ride_to;
    private String name;
    private String phone;
    private String departure_time;
   
    
    
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
}


