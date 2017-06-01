package models;

import java.io.Serializable;
import java.sql.Timestamp;

/*
 * @author OthmanKurdi
 */
public class AvailableRides implements Serializable {

    private int ride_id;

    private int student_id;
    private String name;
    private String phone;
    private String gender;

    private String ride_from;
    private String ride_to;
    private String departure_time;

    private int car_plate_number;
    private String car_make;
    private String car_model;
    private String year_of_make;
    private String car_color;

    public int getRide_id() {
        return ride_id;
    }

    public void setRide_id(int ride_id) {
        this.ride_id = ride_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
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

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public int getCar_plate_number() {
        return car_plate_number;
    }

    public void setCar_plate_number(int car_plate_number) {
        this.car_plate_number = car_plate_number;
    }

    public String getCar_make() {
        return car_make;
    }

    public void setCar_make(String car_make) {
        this.car_make = car_make;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getYear_of_make() {
        return year_of_make;
    }

    public void setYear_of_make(String year_of_make) {
        this.year_of_make = year_of_make;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
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

    public String getDepartureTime() {
        return this.departure_time;
    }

    public void setDepartureTime(String departure_time) {
        this.departure_time = departure_time;
    }
}
