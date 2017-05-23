
package BusReservationModel;

import java.io.Serializable;
 /*
 * @author Kamal Jabari
 */
public class StudentInformation implements Serializable{

    
    private int student_id;
    private String student_name;
    private String phone;
    private String seat_pre_res;
   
    
    
    public int getStudentID(){
        return this.student_id;
    }
    public void setStudentID(int student_id){
        this.student_id=student_id;
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
    public void setPhone(String phone){
        this.phone=phone;
    }
    
     public String getSeatPreRes(){
        return this.seat_pre_res;
    }
    public void setSeatPreRes(String seat_pre_res){
        this.seat_pre_res=seat_pre_res;
    }
    
}


