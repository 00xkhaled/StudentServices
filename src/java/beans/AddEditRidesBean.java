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
public class AddEditRidesBean implements Serializable {

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

    private AvailableRides selectedRide;
    private final AvailableRidesDao ridesdao = new AvailableRidesDao();
    private ArrayList<AvailableRides> list;

    @Inject
    private SessionBean sessionBean;

    public AddEditRidesBean() {
    }

    //the next methode will help me while editing, so that it will get the values of the 
    //attributes and fill them in the in the input fields
    @PostConstruct
    public void init() {
        try {
            ride_id = sessionBean.getSelectedItemId();

            if (ride_id > 0) {
                AvailableRides ride = ridesdao.getRide(ride_id);

                ride_from = ride.getRideFrom();
                ride_to = ride.getRideTo();
                student_id = ride.getStudent_id();
                name = ride.getName();
                phone = ride.getPhone();
                departure_time = ride.getDepartureTime();
            }
        } catch (Exception ex) {
            Logger.getLogger(AvailableRidesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //this method should add the value directly. and it will navigate to the edit update method in the dao.
    public void addRide() {
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

    public void saveSelectedItemId() {
        System.out.println("beans.AddEditRidesBean.saveSelectedItemId()");
        sessionBean.setSelectedItemId(selectedRide.getRideID());
    }

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

    public ArrayList<AvailableRides> getList() {
        return list;
    }

    public void setList(ArrayList<AvailableRides> list) {
        this.list = list;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
