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
import BusReservationModel.StudentInformation; //MODEL
import beans.SessionBean;

/**
 *
 * @author Kamal Jabari
 */
@Named(value = "StudentInformationBean")
@SessionScoped
public class StudentInformationBean implements Serializable {
    
    
    
    private String student_id;
    private String student_fname_en;
    private String student_fname_ar;
    private String student_lname_en;
    private String student_lname_ar;
    private String address_en;
    private String address_ar;
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
            list = std_inf_dao.buildEvents();            
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
    
    // hay hee elee ma3molelha call bl page
    public ArrayList<StudentInformation> getAvailableRides() {
        return list;
    }
    
    
    
     public String getStudentFNameEn(){
        return this.student_fname_en;
    }
     
    public void setStudentFNameEn(String student_fname_en){
        this.student_fname_en=student_fname_en;
    }
    
    public String getStudentFNameAr(){
        return this.student_fname_ar;
    }
    
    public void setStudentFNameAr(String student_fname_ar){
        this.student_fname_ar=student_fname_ar;
    }    

     public String getStudentLNameEn(){
        return this.student_lname_en;
    }
     
    public void setStudentLNameEn(String student_lname_en){
        this.student_lname_en=student_lname_en;
    }
    public String getStudentLNameAr(){
        return this.student_lname_ar;
    }
    
    public void setStudentLNameAr(String student_lname_ar){
        this.student_lname_ar=student_lname_ar;
    }
    
    public String getPhone(){
        return this.phone;
    }
    
    public void setPhone(String phone){
        this.phone=phone;
    }
    
    public String getSeatPreRes(){
        return this.seat_pre_res;
    }
     
    public void setSeatPreRes(String seat_pre_res){
        this.seat_pre_res=seat_pre_res;
    }
    
    public String getStudentAddressAr(){
        return this.address_ar;
    }
    
    public void setStudentAddressAr(String address_ar){
    this.address_ar=address_ar;
    }
    
    public String getStudentAddressEn(){
        return this.address_en;
    }
    
    public void setStudentAddressEn(String address_en){
    this.address_en=address_en;
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
