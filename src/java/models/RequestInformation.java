/**
 *
 * @author Khaled
 */


package models;

import java.io.Serializable;
import java.util.Date;
import oracle.sql.TIMESTAMP;
 
public class RequestInformation implements Serializable {
 
    private String firstname;
     
    private String lastname;
     
    private Integer age;
     
    private String street;
     
    private String city;
     
    private String postalCode;
     
    private String info;
     
    private String email;
     
    private String phone;
    
        private String gender;
        
        private String ridefrom;
        
        private String rideto;
        
        private TIMESTAMP time;
        
            private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


         
    public String getRidefrom() {
        return ridefrom;
    }

    public void setRidefrom(String ridefrom) {
        this.ridefrom = ridefrom;
    }

    public String getRideto() {
        return rideto;
    }

    public void setRideto(String rideto) {
        this.rideto = rideto;
    }

    public TIMESTAMP getTime() {
        return time;
    }

    public void setTime(TIMESTAMP time) {
        this.time = time;
    }
        
        

    public String getGender() {
        return gender;
    }

    public void setGender(String Gender) {
        this.gender = Gender;
    }

        
        
    public String getFirstname() {
        return firstname;
    }
 
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
 
    public String getLastname() {
        return lastname;
    }
 
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
 
    public Integer getAge() {
        return age;
    }
 
    public void setAge(Integer age) {
        this.age = age;
    }
 
    public String getStreet() {
        return street;
    }
 
    public void setStreet(String street) {
        this.street = street;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public String getPostalCode() {
        return postalCode;
    }
 
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
 
    public String getInfo() {
        return info;
    }
 
    public void setInfo(String info) {
        this.info = info;
    }
     
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPhone() {
        return phone;
    }
 
    public void setPhone(String phone) {
        this.phone = phone;
    }
}