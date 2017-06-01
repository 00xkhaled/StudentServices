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
import models.AvailableRide;

/**
 *
 * @author OthmanKurdi
 */
@Named(value = "addEditRidesBean")
@ViewScoped
public class AddEditRidesBean implements Serializable {

    private int rideId;
    private int studentId;
    private String name;
    private String phone;
    private String gender;

    private String rideFrom;
    private String rideTo;
    private String departureTime;

    private int carPlateNumber;
    private String carMake;
    private String carModel;
    private String yearOfMake;
    private String carColor;

    private AvailableRide selectedRide;
    private final AvailableRidesDao ridesdao = new AvailableRidesDao();
    private ArrayList<AvailableRide> list;

    @Inject
    private SessionBean sessionBean;

    public AddEditRidesBean() {
    }

    //the next methode will help me while editing, so that it will get the values of the 
    //attributes and fill them in the in the input fields
    @PostConstruct
    public void init() {
        try {
            rideId = sessionBean.getSelectedItemId();

            if (rideId > 0) {
                AvailableRide ride = ridesdao.getRide(rideId);
                
                //rideId;
                studentId=ride.getStudentId();
                name = ride.getName();
                phone = ride.getPhone();
                gender=ride.getGender();
                
                rideFrom = ride.getRideFrom();
                rideTo = ride.getRideTo();
                departureTime = ride.getDepartureTime();
                
                carPlateNumber=ride.getCarPlateNumber();
                carMake=ride.getCarMake();
                carModel=ride.getCarModel();
                yearOfMake=ride.getYearOfMake();
                carColor=ride.getCarColor();
                
                
            }
        } catch (Exception ex) {
            Logger.getLogger(AvailableRidesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //this method should add the value directly. and it will navigate to the edit update method in the dao.
    public void addRide() {
        try {
            AvailableRide insertRide = new AvailableRide();

            insertRide.setRideFrom(rideFrom);
            insertRide.setRideTo(rideTo);
            insertRide.setName(name);
            insertRide.setPhone(phone);
            insertRide.setDepartureTime(departureTime);
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

    public AvailableRide getSelectedRide() {
        return selectedRide;
    }

    public void setSelectedRide(AvailableRide selectedRides) {
        this.selectedRide = selectedRides;
    }

    public int getRideID() {
        return this.rideId;
    }

    public void setRideID(int rideId) {
        this.rideId = rideId;
    }

    public String getRideFrom() {
        return this.rideFrom;
    }

    public void setRideFrom(String rideFrom) {
        this.rideFrom = rideFrom;
    }

    public String getRideTo() {
        return this.rideTo;
    }

    public void setRideTo(String rideTo) {
        this.rideTo = rideTo;
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

    public void saveSelectedItemId() {
        System.out.println("beans.AddEditRidesBean.saveSelectedItemId()");
        sessionBean.setSelectedItemId(selectedRide.getRideID());
    }

    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    
    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(int carPlateNumber) {
        this.carPlateNumber = carPlateNumber;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getYearOfMake() {
        return yearOfMake;
    }

    public void setYearOfMake(String yearOfMake) {
        this.yearOfMake = yearOfMake;
    }

    public String getCar_color() {
        return carColor;
    }

    public void setCar_color(String carColor) {
        this.carColor = carColor;
    }

    public ArrayList<AvailableRide> getList() {
        return list;
    }

    public void setList(ArrayList<AvailableRide> list) {
        this.list = list;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
