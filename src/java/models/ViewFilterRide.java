package models;

import java.io.Serializable;

/*
 * @author Sarayreh
 */
public class ViewFilterRide implements Serializable {

    private int ride_id;
    private String name;
    private String phone;
    private String gender;
    private String ride_from;
    private String ride_to;
  

    

    public int getRide_id() {
        return ride_id;
    }

    public void setRide_id(int ride_id) {
        this.ride_id = ride_id;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRide_from() {
        return ride_from;
    }

    public void setRide_from(String ride_from) {
        this.ride_from = ride_from;
    }

    public String getRide_to() {
        return ride_to;
    }

    public void setRide_to(String ride_to) {
        this.ride_to = ride_to;
    }

    

    public int getRideID() {
        return this.ride_id;
    }

    public void setRideID(int ride_id) {
        this.ride_id = ride_id;
    }

    public String getRideFrom() {
        return this.ride_from;
    }

    public void setRideFrom(String ride_from) {
        this.ride_from = ride_from;
    }

    public String getRideTo() {
        return this.ride_to;
    }

    public void setRideTo(String ride_to) {
        this.ride_to = ride_to;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   
}
