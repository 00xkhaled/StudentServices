package beans.bus_reservation;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.bus_reservation.StudentInformation;
import daos.bus_reservation.StudentInformationDao;
import beans.SessionBean;
import java.io.Serializable;

/**
 *
 * @author Kamal Jabari
 *
 */
@Named("addEditStudentBean")
@ViewScoped
public class AddEditStudentBean implements Serializable {

    private final StudentInformationDao studentsDao = new StudentInformationDao();
    private int studentId;
    private String studentFnameEn;
    private String studentLnameEn;
    private String studentFnameAr;
    private String studentLnameAr;
    private int phone;
    private String seatPreRes;
    private String addressAr;
    private String addressEn;

    @Inject
    private SessionBean sessionBean;

    public AddEditStudentBean() {
    }

    @PostConstruct
    public void init() {
        try {
            studentId = sessionBean.getSelectedStudentID();

            if (studentId > 0) {

                StudentInformation student = new StudentInformation();
                studentId = student.getStudentId();
                studentFnameEn = student.getStudentFnameEn();
                studentFnameAr = student.getStudentFnameAr();
                studentLnameEn = student.getStudentLnameEn();
                studentLnameAr = student.getStudentLnameAr();
                addressEn = student.getAddressEn();
                addressAr = student.getAddressAr();
                seatPreRes = student.getSeatPreRes();
                phone = student.getPhone();

            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditStudentBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentFnameEn() {
        return this.studentFnameEn;
    }

    public void setStudentFnameEn(String studentFnameEn) {
        this.studentFnameEn = studentFnameEn;
    }

    public String getStudentFnameAr() {
        return this.studentFnameAr;
    }

    public void setStudentFnameAr(String studentFnameAr) {
        this.studentFnameAr = studentFnameAr;
    }

    public String getStudentLnameEn() {
        return this.studentLnameEn;
    }

    public void setStudentLnameEn(String studentLnameEn) {
        this.studentLnameEn = studentLnameEn;
    }

    public String getStudentLnameAr() {
        return this.studentLnameAr;
    }

    public void setStudentLnameAr(String studentLnameAr) {
        this.studentLnameAr = studentLnameAr;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getSeatPreRes() {
        return this.seatPreRes;
    }

    public void setSeatPreRes(String seatPreRes) {
        this.seatPreRes = seatPreRes;
    }

    public String getAddressAr() {
        return this.addressAr;
    }

    public void setAddressAr(String addressAr) {
        this.addressAr = addressAr;
    }

    public String getAddressEn() {
        return this.addressEn;
    }

    public void setAddressEn(String addressEn) {
        this.addressEn = addressEn;
    }

    public void saveStudent() {
        try {
            StudentInformation student = new StudentInformation();
            student.setStudentId(studentId);
            student.setStudentFnameEn(studentFnameEn);
            student.setStudentFnameAr(studentFnameAr);
            student.setStudentLnameEn(studentLnameEn);
            student.setStudentLnameEn(studentLnameAr);
            student.setAddressEn(addressEn);
            student.setAddressAr(addressAr);
            student.setSeatPreRes(seatPreRes);
            student.setPhone(phone);

            if (sessionBean.getSelectedStudentID() > 0) {
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
