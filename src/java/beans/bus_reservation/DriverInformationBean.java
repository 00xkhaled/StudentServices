package beans.bus_reservation;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;
import daos.bus_reservation.DriverInformationDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import models.bus_reservation.DriverInformation; //MODEL
import beans.SessionBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Kamal Jabari
 */
@Named(value = "driverInformationBean")
@ViewScoped
public class DriverInformationBean implements Serializable {

    private int driver_id;
    private String driver_name_en;
    private String driver_name_ar;
    private String driver_add_en;
    private String driver_add_ar;
    private int phone;
    private int driver_license_no;

    private DriverInformation selectedDriver;//model object to save selected student;
    private final DriverInformationDao driverdao = new DriverInformationDao();//dao object;
    private ArrayList<DriverInformation> list;//list of type model to save result from database

    @Inject
    private SessionBean sessionBean;

    public DriverInformationBean() {

    }

    @PostConstruct
    public void init() {
        try {
            list = driverdao.buildDriver();
        } catch (Exception ex) {
            Logger.getLogger(DriverInformationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getDriverID() {
        return this.driver_id;
    }

    public void setDriverID(int driver_id) {
        this.driver_id = driver_id;
    }

    public DriverInformation getSelectedDriver() {//selected model 
        return selectedDriver;
    }

    public void setSelectedDriver(DriverInformation selectedDriver) {
        this.selectedDriver = selectedDriver;
    }

    // hay hee elee ma3molelha call bl page
    public ArrayList<DriverInformation> getDriver() {
        return list;
    }

    public String getDriverNameEn() {
        return this.driver_name_en;
    }

    public void setDriverNameEn(String driver_name_en) {
        this.driver_name_en = driver_name_en;
    }

    public String getDriverNameAr() {
        return this.driver_name_ar;
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

    public void setDriverAddressEn(String driver_add_ar) {
        this.driver_add_ar = driver_add_ar;
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

    public void saveSelectedDriverID() {
        sessionBean.setSelectedDriverID(selectedDriver.getDriverID());
    }

    public ArrayList<DriverInformation> getList() {
        return list;
    }

    public void setList(ArrayList<DriverInformation> list) { //TO SET IN THE list of type model to save result from database
        this.list = list;
    }

    public void deleteSelectedDriver() {
        try {
            driverdao.deleteDriver(selectedDriver.getDriverID());
        } catch (Exception ex) {
            //sar t3deel hon bel information bean kant bus w 5aletha driver
            Logger.getLogger(DriverInformationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
