package models.bus_reservation;

import java.io.Serializable;

/*
 * @author Kamal Jabari
 */
public class StudentInformation implements Serializable {

    private int student_id;
    private String student_fname_en;
    private String student_lname_en;
    private String student_fname_ar;
    private String student_lname_ar;
    private int phone;
    private String seat_pre_res;
    private String address_ar;
    private String address_en;

    public int getStudentID() {
        return this.student_id;
    }

    public void setStudentID(int student_id) {
        this.student_id = student_id;
    }

    public String getStudentFNameEn() {
        return this.student_fname_en;
    }

    public void setStudentFNameEn(String student_fname_en) {
        this.student_fname_en = student_fname_en;
    }

    public String getStudentFNameAr() {
        return this.student_fname_ar;
    }

    public void setStudentFNameAr(String student_fname_ar) {
        this.student_fname_ar = student_fname_ar;
    }

    public String getStudentLNameEn() {
        return this.student_lname_en;
    }

    public void setStudentLNameEn(String student_lname_en) {
        this.student_lname_en = student_lname_en;
    }

    public String getStudentLNameAr() {
        return this.student_lname_ar;
    }

    public void setStudentLNameAr(String student_lname_ar) {
        this.student_lname_ar = student_lname_ar;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getSeatPreRes() {
        return this.seat_pre_res;
    }

    public void setSeatPreRes(String seat_pre_res) {
        this.seat_pre_res = seat_pre_res;
    }

    public String getStudentAddressAr() {
        return this.address_ar;
    }

    public void setStudentAddressAr(String address_ar) {
        this.address_ar = address_ar;
    }

    public String getStudentAddressEn() {
        return this.address_en;
    }

    public void setStudentAddressEn(String address_en) {
        this.address_en = address_en;
    }

}
