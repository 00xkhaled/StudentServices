package beans.bus_reservation;

import daos.bus_reservation.StudentInformationDao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.bus_reservation.StudentInformation;
import daos.bus_reservation.StudentInformationDao;
import beans.SessionBean;

/**
 *
 * @author Kamal Jabari
 *
 */
@Named(value = "addEditStudentBean")
@ViewScoped
public class AddEditStudentBean implements Serializable {

    private final StudentInformationDao studentsDao = new StudentInformationDao();
    private int student_id;
    private String student_fname_en;
    private String student_lname_en;
    private String student_fname_ar;
    private String student_lname_ar;
    private int phone;
    private int seat_pre_res;
    private String address_ar;
    private String address_en;

    @Inject
    private SessionBean sessionBean;

    public AddEditStudentBean() {
    }

    @PostConstruct
    public void init() {
        try {
            student_id = sessionBean.getSelectedItemId();

            // eventTypes = eventTypesDao.buildEventTypes();
            if (student_id > 0) {
                StudentInformation student = new StudentInformation();
                student_fname_en = student.getStudentFNameEn();
                student_fname_ar = student.getStudentFNameAr();
                student_lname_en = student.getStudentLNameEn();
                student_lname_ar = student.getStudentLNameAr();
                address_en = student.getStudentAddressEn();
                address_ar = student.getStudentAddressAr();
                seat_pre_res = student.getSeatPreRes();
                phone = student.getPhone();

            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditStudentBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    public int getSeatPreRes() {
        return this.seat_pre_res;
    }

    public void setSeatPreRes(int seat_pre_res) {
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

    public void saveStudent() {
        try {
            StudentInformation student = new StudentInformation();

            student.setStudentID(student_id);
            student.setStudentFNameEn(student_fname_en);
            student.setStudentFNameAr(student_fname_ar);
            student.setStudentLNameEn(student_lname_en);
            student.setStudentLNameEn(student_lname_ar);
            student.setStudentAddressEn(address_en);
            student.setStudentAddressAr(address_ar);
            student.setSeatPreRes(seat_pre_res);
            student.setPhone(phone);

            if (sessionBean.getSelectedItemId() > 0) {
                studentsDao.updateStudent(student);
            } else {
                studentsDao.insertStudent(student);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditStudentBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        sessionBean.navigate("student_info");
    }
}
