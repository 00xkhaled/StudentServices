package beans;

import daos.AddEditRidesDao;
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
    //STUDENT_CARPOOLING:
    /*01*/private int rideId;
    /*02*/private int studentId;
    /*03*/private String name;
    /*04*/private String phone;
    /*05*/private String gender;
    //RIDES:
    /*06*/private String rideFrom;
    /*07*/private String rideTo;
    /*08*/private String departureTime;
    //CARS:
    /*09*/private int carPlateNumber;
    /*10*/private String carMake;
    /*11*/private String carModel;
    /*12*/private String yearOfMake;
    /*13*/private String carColor;

    private AvailableRide selectedRide;
    private final AddEditRidesDao ridesDao=new AddEditRidesDao();
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
                AvailableRide ride = ridesDao.getRide(rideId);
                
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
            Logger.getLogger(AddEditRidesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //this method should add the value directly. and it will navigate to the edit update method in the dao.
    public void addRide() {
        try {
            AvailableRide ride= new AvailableRide();
            
            ride.setRideID(rideId);
            ride.setStudentId(studentId);
            ride.setName(name);
            ride.setPhone(phone);
            ride.setGender(gender);
            ride.setRideFrom(rideFrom);
            ride.setRideTo(rideTo);
            ride.setDepartureTime(departureTime);
            ride.setCarPlateNumber(carPlateNumber);
            ride.setCarMake(carMake);
            ride.setCarModel(carModel);
            ride.setYearOfMake(yearOfMake);
            ride.setCarColor(carColor);
            
            if (sessionBean.getSelectedItemId() > 0) {
                ridesDao.updateRide(ride);
            } else {
                ridesDao.insertRide(ride);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditRidesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessionBean.navigate("available_rides");

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRideFrom() {
        return rideFrom;
    }

    public void setRideFrom(String rideFrom) {
        this.rideFrom = rideFrom;
    }

    public String getRideTo() {
        return rideTo;
    }

    public void setRideTo(String rideTo) {
        this.rideTo = rideTo;
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

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public AvailableRide getSelectedRide() {
        return selectedRide;
    }

    public void setSelectedRide(AvailableRide selectedRide) {
        this.selectedRide = selectedRide;
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
