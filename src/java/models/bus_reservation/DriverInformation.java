package models.bus_reservation;

import java.io.Serializable;

/*
 * @author Kamal Jabari
 */
public class DriverInformation implements Serializable {

    private int driver_id;
    private String driver_name_en;
    private String driver_name_ar;
    private int phone;
    private String driver_add_en;
    private String driver_add_ar;
    private int driver_license_no;

    public int getDriverID() {
        return this.driver_id;
    }

    public void setDriverID(int driver_id) {
        this.driver_id = driver_id;
    }

    public String getDriverNameEn() {
        return this.driver_name_en;
    }

    public void setDriverNameEn(String driver_name_en) {
        this.driver_name_en = driver_name_en;
    }

    public String getDriverNameAr() {
        return this.driver_name_en;
    }

    public void setDriverNameAr(String driver_name_ar) {
        this.driver_name_ar = driver_name_ar;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDriverAddressEn() {
        return this.driver_add_en;
    }

    public void setDriverAddressEn(String driver_add_en) {
        this.driver_add_en = driver_add_en;
    }

    public String getDriverAddressAr() {
        return this.driver_add_ar;
    }

    public void setDriverAddressAr(String driver_add_ar) {
        this.driver_add_ar = driver_add_ar;
    }

    public int getDriverLicenseNo() {
        return this.driver_license_no;
    }

    public void setDriverLicenseNo(int driver_license_no) {
        this.driver_license_no = driver_license_no;
    }

}
