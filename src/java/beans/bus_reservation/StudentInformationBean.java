package beans.bus_reservation;

import javax.inject.Named;
import java.io.Serializable;
import javax.inject.Inject;
import daos.bus_reservation.StudentInformationDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import models.bus_reservation.StudentInformation;
import beans.SessionBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Kamal Jabari
 */
@Named(value = "studentInformationBean")
@ViewScoped
public class StudentInformationBean implements Serializable {

    private int student_id;
    private String student_fname_en;
    private String student_lname_en;
    private String student_fname_ar;
    private String student_lname_ar;
    private String phone;
    private String seat_pre_res;
    private String address_ar;
    private String address_en;

    private StudentInformation selectedStudent;//model object to save selected student;
    private final StudentInformationDao studentsDao = new StudentInformationDao();//dao object;
    private ArrayList<StudentInformation> list;//list of type model to save result from database

    @Inject
    private SessionBean sessionBean;

    public StudentInformationBean() {

    }

    @PostConstruct
    public void init() {
        try {
            list = studentsDao.buildStudent();
        } catch (Exception ex) {
            Logger.getLogger(StudentInformationBean.class.getName()).log(Level.SEVERE, null, ex);
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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
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

    public StudentInformation getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(StudentInformation selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    public ArrayList<StudentInformation> getStudent() {
        return list;
    }

    public void saveSelectedStudentID() {
        sessionBean.setSelectedStudentID(selectedStudent.getStudentID());
    }

    public ArrayList<StudentInformation> getList() {
        return list;
    }

    public void setList(ArrayList<StudentInformation> list) { //TO SET IN THE list of type model to save result from database
        this.list = list;
    }

    public void deleteSelectedStudent() {
        try {
            studentsDao.deleteStudent(selectedStudent.getStudentID());
            // sessionBean.navigate("Student_info");
        } catch (Exception ex) {
            Logger.getLogger(StudentInformationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
