package BusReservationBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;
import BusReservationDao.StudentInformationDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import BusReservationModel.StudentInformation;
import beans.SessionBean;
/**
 *
 * @author Kamal Jabari
 */
@Named(value = "StudentInformationBean")
@SessionScoped
public class StudentInformationBean implements Serializable {
    
    
    
    private String student_id;
    private String student_name;
    private String phone;
    private String seat_pre_res;
    
    
    private StudentInformation selectedStudent;//model object to save selected student;
    private final StudentInformationDao std_inf_dao=new StudentInformationDao();//dao object;
    private ArrayList<StudentInformation> list;//list of type model to save result from database
    
     @Inject
    private SessionBean sessionBean;
     
    public StudentInformationBean(){
        init();
    
    }
    
     @PostConstruct
    public void init(){
        try {            
            list = std_inf_dao.buildStudent();            
        } catch (Exception ex) {
            Logger.getLogger(StudentInformationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getStudentID(){
        return this.student_id;
    }
    public void setStudentID(String student_id){
        this.student_id=student_id;
    }
     public StudentInformation getSelectedStudent() {//selected model 
        return selectedStudent;
    }
    public void setSelectedStudent(StudentInformation selectedStudent) {
        this.selectedStudent = selectedStudent;
    } 
    public ArrayList<StudentInformation> getStudent() {
        return list;
    }
     public String getStudentName(){
        return this.student_name;
    }
    public void setStudentName(String student_name){
        this.student_name=student_name;
    }
    
     public String getPhone(){
        return this.phone;
    }
    public void setPhone(String student_phone){
        this.phone=student_phone;
    }
    
    
    
     public String getSeatPreRes(){
        return this.seat_pre_res;
    }
    public void setSeatPreRes(String seat_pre_res){
        this.seat_pre_res=seat_pre_res;
    }
    
    public void saveSelectedStudentID(){
        sessionBean.setSelectedItemId(selectedStudent.getStudentID());
    }

    public ArrayList<StudentInformation> getList() {
        return list;
    }

    public void setList(ArrayList<StudentInformation> list) { //TO SET IN THE list of type model to save result from database
        this.list = list;
    }
    
    
}
