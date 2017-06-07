package beans.bus_reservation;

import daos.bus_reservation.DriverInformationDao;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.bus_reservation.DriverInformation;
import beans.SessionBean;

/**
 *
 * @author Kamal Jabari
 */
@Named("addEditDriverBean")
@ViewScoped
public class AddEditDriverBean implements Serializable {

    private final DriverInformationDao DriverInformationDao = new DriverInformationDao();
    private int driver_id;
    private String driver_name_en;
    private String driver_name_ar;
    private int phone;
    private String driver_add_en;
    private String driver_add_ar;
    private int driver_license_no;

    @Inject
    private SessionBean sessionBean;

    public AddEditDriverBean() {
    }

    @PostConstruct
    public void init() {
        try {
            driver_id = sessionBean.getSelectedDriverID();

            if (driver_id > 0) {
                DriverInformation driver = new DriverInformation();
                driver.getDriverID();
                driver.getDriverNameEn();
                driver.getDriverNameAr();
                driver.getPhone();
                driver.getDriverAddressEn();
                driver.getDriverAddressAr();
                driver.getDriverLicenseNo();

            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditDriverBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    public void saveDriver() {
        try {
            DriverInformation driver = new DriverInformation();

            driver.setDriverID(driver_id);
            driver.setDriverNameEn(driver_name_en);
            driver.setDriverNameAr(driver_name_ar);
            driver.setPhone(phone);
            driver.setDriverAddressEn(driver_add_en);
            driver.setDriverAddressAr(driver_add_ar);
            driver.setDriverLicenseNo(driver_license_no);

            if (sessionBean.getSelectedDriverID() > 0) {
                DriverInformationDao.updateDriver(driver);
            } else {
                DriverInformationDao.insertDriver(driver);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditDriverBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessionBean.navigate("driver_info");

    }

}
