
package models.bus_reservation;

import java.io.Serializable;

public class SeatRes implements Serializable{

    private int res_id;
    private int bus_number;
    private int student_id;
    private int seat_id;
    private String res_time;
    
    public int getResID(){
        return this.res_id;
    }
    public void setResID(int res_id){
        this.res_id=res_id;
    }
    
    public int getStudentID(){
        return this.student_id;
    }
    public void setStudentID(int s_id){
        this.student_id=s_id;
    }
    
     public int getBusNumber(){
        return this.bus_number;
    }
    public void setBusNumber(int bus_number){
        this.bus_number=bus_number;
    }
    
     public int getSeatID(){
        return this.seat_id;
    }
    public void setSeatID(int seat_id){
        this.seat_id=seat_id;
    } 
    public String getResTime(){
        return this.res_time;
    }
    public void setResTime(String res_time){
        this.res_time=res_time;
    }
   
}


