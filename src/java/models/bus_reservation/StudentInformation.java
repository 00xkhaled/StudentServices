package models.bus_reservation;

import java.io.Serializable;

/**
 * @author Kamal Jabari
 */
public class StudentInformation implements Serializable {

    private int studentId;
    private String studentFnameEn;
    private String studentLnameEn;
    private String studentFnameAr;
    private String studentLnameAr;
    private int phone;
    private String seatPreRes;
    private String addressAr;
    private String addressEn;

    /**
     * @return the studentId
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the studentFnameEn
     */
    public String getStudentFnameEn() {
        return studentFnameEn;
    }

    /**
     * @param studentFnameEn the studentFnameEn to set
     */
    public void setStudentFnameEn(String studentFnameEn) {
        this.studentFnameEn = studentFnameEn;
    }

    /**
     * @return the studentLnameEn
     */
    public String getStudentLnameEn() {
        return studentLnameEn;
    }

    /**
     * @param studentLnameEn the studentLnameEn to set
     */
    public void setStudentLnameEn(String studentLnameEn) {
        this.studentLnameEn = studentLnameEn;
    }

    /**
     * @return the studentFnameAr
     */
    public String getStudentFnameAr() {
        return studentFnameAr;
    }

    /**
     * @param studentFnameAr the studentFnameAr to set
     */
    public void setStudentFnameAr(String studentFnameAr) {
        this.studentFnameAr = studentFnameAr;
    }

    /**
     * @return the studentLnameAr
     */
    public String getStudentLnameAr() {
        return studentLnameAr;
    }

    /**
     * @param studentLnameAr the studentLnameAr to set
     */
    public void setStudentLnameAr(String studentLnameAr) {
        this.studentLnameAr = studentLnameAr;
    }

    /**
     * @return the phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * @return the seatPreRes
     */
    public String getSeatPreRes() {
        return seatPreRes;
    }

    /**
     * @param seatPreRes the seatPreRes to set
     */
    public void setSeatPreRes(String seatPreRes) {
        this.seatPreRes = seatPreRes;
    }

    /**
     * @return the addressAr
     */
    public String getAddressAr() {
        return addressAr;
    }

    /**
     * @param addressAr the addressAr to set
     */
    public void setAddressAr(String addressAr) {
        this.addressAr = addressAr;
    }

    /**
     * @return the addressEn
     */
    public String getAddressEn() {
        return addressEn;
    }

    /**
     * @param addressEn the addressEn to set
     */
    public void setAddressEn(String addressEn) {
        this.addressEn = addressEn;
    }

}
