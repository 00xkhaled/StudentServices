/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.tutoring;

/**
 *
 * @author Ursina
 */
import beans.SessionBean;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Firas.Alhawari
 * 
 */
@Named(value = "profileBean")
@ViewScoped
public class ProfileBean implements Serializable{
    private String firstName;
    private String firstNameAr;
    private String lastName;
    private String lastNameAr;
    private String major;
    private String emailAddress;
    private String phoneNumber;
    private int creditScore;
    
    @Inject
    private SessionBean sessionBean;
    
    public ProfileBean() {        
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getMajor(){
        return major;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setMajor(String major){
        this.major = major;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }
    
        public String getFirstNameAr() {
        return firstNameAr;
    }

    public void setFirstNameAr(String firstNameAr) {
        this.firstNameAr = firstNameAr;
    }

    public String getLastNameAr() {
        return lastNameAr;
    }

    public void setLastNameAr(String lastNameAr) {
        this.lastNameAr = lastNameAr;
    }
}

