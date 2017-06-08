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



    private StudentInformation selectedStudent;//model object to save selected student;
    private final StudentInformationDao studentsDao = new StudentInformationDao();//dao object;
    private ArrayList<StudentInformation> students;//list of type model to save result from database

    @Inject
    private SessionBean sessionBean;

    public StudentInformationBean() {
        
    }

    @PostConstruct
    public void init() {
        try {
            students = studentsDao.buildStudent();
        } catch (Exception ex) {
            Logger.getLogger(StudentInformationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public StudentInformation getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(StudentInformation selectedStudent) {
        this.selectedStudent = selectedStudent;
    }


    public void saveSelectedStudentId() {
        sessionBean.setSelectedStudentID(selectedStudent.getStudentId());
    }

    public ArrayList<StudentInformation> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<StudentInformation> students) { //TO SET IN THE list of type model to save result from database
        this.students = students;
    }

    public void deleteSelectedStudent() {
        try {
            studentsDao.deleteStudent(selectedStudent.getStudentId());
        } catch (Exception ex) {
            Logger.getLogger(StudentInformationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
