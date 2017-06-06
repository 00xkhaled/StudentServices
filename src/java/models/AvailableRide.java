package models;

import java.io.Serializable;

/*
 * @author OthmanKurdi
 */
public class AvailableRide implements Serializable {

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

    public int getRideID() {
        return this.rideId;
    }

    public void setRideID(int rideId) {
        this.rideId = rideId;
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
